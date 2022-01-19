/**
 * 
 */
package com.skill.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skill.dtos.CandidateDTO;
import com.skill.entities.Candidate;
import com.skill.entities.Location;
import com.skill.entities.Skill;
import com.skill.repositories.CandidateRepository;
import com.skill.services.CandidateServices;
import com.skill.services.MasterServices;

/**
 * The Class CandidateServicesImpl.
 *
 * @author Ebin
 */
@Service
public class CandidateServicesImpl implements CandidateServices
{
	
	/** The candidate repo. */
	@Autowired
	private CandidateRepository candidateRepo;

	/** The master services. */
	@Autowired
	private MasterServices masterServices;

	/**
	 * Save new.
	 *
	 * @param candidateDTO the candidate DTO
	 * @return the candidate
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public Candidate saveNew(CandidateDTO candidateDTO)
	{
		Candidate candidate = setCandidateEntityFromDto(candidateDTO);
		if (Objects.nonNull(candidate))
		{
			return candidateRepo.save(candidate);
		}
		throw new IllegalArgumentException("Invalid cadidate details");
	}

	/**
	 * Sets the candidate entity from dto.
	 *
	 * @param candidateDTO the candidate DTO
	 * @return the candidate
	 */
	private Candidate setCandidateEntityFromDto(CandidateDTO candidateDTO)
	{
		Candidate candidate = null;
		if (Objects.nonNull(candidateDTO))
		{
			candidate = new Candidate();
			candidate.setAddDate(LocalDate.now());
			candidate.setEmail(candidateDTO.getEmail());
			candidate.setMobile(candidateDTO.getMobile());
			candidate.setName(candidateDTO.getName());
			candidate.setStatus('A');
			if (Objects.nonNull(candidateDTO.getLocation()))
			{
				candidate.setLocation(masterServices.findLocation(candidateDTO.getLocation()));
			}
			if (Objects.nonNull(candidateDTO.getCandidateSkills()) && !candidateDTO.getCandidateSkills().isEmpty())
			{
				List<Skill> skills = masterServices.findAllSkillsByIds(candidateDTO.getCandidateSkills());
				candidate.setCandidateSkills(skills);
			}
			if (Objects.nonNull(candidateDTO.getPreferredLocations())
					&& !candidateDTO.getPreferredLocations().isEmpty())
			{
				List<Location> locations = masterServices.findLocationsByIds(candidateDTO.getPreferredLocations());
				candidate.setPreferredLocations(locations);
			}
		}
		return candidate;
	}

	/**
	 * Find one.
	 *
	 * @param candidateId the candidate id
	 * @return the candidate
	 */
	@Override
	public Candidate findOne(Long candidateId)
	{
		return candidateRepo.getById(candidateId);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<Candidate> findAll()
	{
		return candidateRepo.findAll();
	}

}

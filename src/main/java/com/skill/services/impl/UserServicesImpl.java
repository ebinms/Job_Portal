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

import com.skill.dtos.UserDTO;
import com.skill.entities.User;
import com.skill.entities.Location;
import com.skill.entities.Skill;
import com.skill.repositories.UserRepository;
import com.skill.services.UserServices;
import com.skill.services.MasterServices;

/**
 * The Class CandidateServicesImpl.
 *
 * @author Ebin
 */
@Service
public class UserServicesImpl implements UserServices
{
	
	/** The candidate repo. */
	@Autowired
	private UserRepository candidateRepo;

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
	public User saveNew(UserDTO candidateDTO)
	{
		User candidate = setUserEntityFromDto(candidateDTO);
		if (Objects.nonNull(candidate))
		{
			return candidateRepo.save(candidate);
		}
		throw new IllegalArgumentException("Invalid cadidate details");
	}

	/**
	 * Sets the candidate entity from dto.
	 *
	 * @param userDTO the candidate DTO
	 * @return the candidate
	 */
	private User setUserEntityFromDto(UserDTO userDTO)
	{
		User user = null;
		if (Objects.nonNull(userDTO))
		{
			user = new User();
			user.setAddDate(LocalDate.now());
			user.setEmail(userDTO.getEmail());
			user.setMobile(userDTO.getMobile());
			user.setName(userDTO.getName());
			user.setStatus('A');
			user.setUserType("U");
			if (Objects.nonNull(userDTO.getLocation()))
			{
				user.setLocation(masterServices.findLocation(userDTO.getLocation()));
			}
			if (Objects.nonNull(userDTO.getCandidateSkills()) && !userDTO.getCandidateSkills().isEmpty())
			{
				List<Skill> skills = masterServices.findAllSkillsByIds(userDTO.getCandidateSkills());
				user.setCandidateSkills(skills);
			}
			if (Objects.nonNull(userDTO.getPreferredLocations())
					&& !userDTO.getPreferredLocations().isEmpty())
			{
				List<Location> locations = masterServices.findLocationsByIds(userDTO.getPreferredLocations());
				user.setPreferredLocations(locations);
			}
		}
		return user;
	}

	/**
	 * Find one.
	 *
	 * @param candidateId the candidate id
	 * @return the candidate
	 */
	@Override
	public User findOne(Long candidateId)
	{
		return candidateRepo.getById(candidateId);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<User> findAll()
	{
		return candidateRepo.findAll();
	}

}

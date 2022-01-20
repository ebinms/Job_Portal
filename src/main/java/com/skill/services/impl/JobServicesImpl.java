/**
 * 
 */
package com.skill.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skill.dtos.JobDTO;
import com.skill.entities.User;
import com.skill.entities.Job;
import com.skill.entities.Skill;
import com.skill.repositories.JobRepository;
import com.skill.services.UserServices;
import com.skill.services.JobServices;
import com.skill.services.MasterServices;

/**
 * The Class JobServicesImpl.
 *
 * @author Ebin
 */
@Service
public class JobServicesImpl implements JobServices
{
	
	/** The job repo. */
	@Autowired
	private JobRepository jobRepo;

	/** The candidate services. */
	@Autowired
	private UserServices candidateServices;

	/** The master services. */
	@Autowired
	private MasterServices masterServices;

	/**
	 * Save new job.
	 *
	 * @param jobDTO the job DTO
	 * @return the job
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public Job saveNewJob(final JobDTO jobDTO)
	{
		Job job = setJobEntityFromDTO(jobDTO);
		if (Objects.nonNull(job))
		{
			return jobRepo.saveAndFlush(job);
		}
		throw new IllegalArgumentException("Invalid job details");
	}

	/**
	 * Sets the job entity from DTO.
	 *
	 * @param jobDTO the job DTO
	 * @return the job
	 */
	private Job setJobEntityFromDTO(JobDTO jobDTO)
	{
		if (Objects.nonNull(jobDTO))
		{
			Job job = new Job();
			job.setAddDate(LocalDate.now());
			job.setDescription(jobDTO.getDescription());
			job.setModDate(LocalDateTime.now());
			job.setName(jobDTO.getName());
			job.setStatus('A');

			if (Objects.nonNull(jobDTO.getCompany()))
			{
				job.setCompany(masterServices.findCompany(jobDTO.getCompany()));
			}
			if (Objects.nonNull(jobDTO.getJobSkills()) && !jobDTO.getJobSkills().isEmpty())
			{
				List<Skill> skills = masterServices.findAllSkillsByIds(jobDTO.getJobSkills());
				if (!skills.isEmpty())
				{
					job.setJobSkills(skills);
				}
			}
			return job;
		}
		return null;
	}

	/**
	 * Find all jobs.
	 *
	 * @return the list
	 */
	@Override
	public List<Job> findAllJobs()
	{
		return jobRepo.findAll();
	}

	/**
	 * Find jobs by skills.
	 *
	 * @param skillIds the skill ids
	 * @return the list
	 */
	@Override
	public List<Job> findJobsBySkills(final List<Long> skillIds)
	{
		return jobRepo.findAllByJobSkillsSkillIdIn(skillIds);
	}

	/**
	 * Find candidate preferred jobs.
	 *
	 * @param candidateId the candidate id
	 * @param locationId the location id
	 * @return the list
	 */
	@Override
	public List<Job> findCandidatePreferredJobs(final Long candidateId, final Long locationId)
	{
		final User candidate = candidateServices.findOne(candidateId);
		final List<Skill> candidateSkills = candidate.getCandidateSkills();
		if (Objects.nonNull(candidateSkills))
		{
			final List<Long> skillIds = candidateSkills.stream().filter(Objects::nonNull).map(Skill::getSkillId)
					.collect(Collectors.toList());
			return jobRepo.findAllByJobSkillsSkillIdInAndJobLocationsId(skillIds, locationId);
		}
		return Collections.emptyList();
	}

}

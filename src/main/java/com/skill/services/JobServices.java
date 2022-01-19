/**
 * 
 */
package com.skill.services;

import java.util.List;

import com.skill.dtos.JobDTO;
import com.skill.entities.Job;

/**
 * The Interface JobServices.
 *
 * @author Ebin
 */
public interface JobServices
{
	
	/**
	 * Save new job.
	 *
	 * @param job the job
	 * @return the job
	 */
	Job saveNewJob(JobDTO job);

	/**
	 * Find all jobs.
	 *
	 * @return the list
	 */
	List<Job> findAllJobs();

	/**
	 * Find jobs by skills.
	 *
	 * @param skillIds the skill ids
	 * @return the list
	 */
	List<Job> findJobsBySkills(List<Long> skillIds);

	/**
	 * Find candidate preferred jobs.
	 *
	 * @param candidateId the candidate id
	 * @param locationId the location id
	 * @return the list
	 */
	List<Job> findCandidatePreferredJobs(Long candidateId , Long locationId);
}

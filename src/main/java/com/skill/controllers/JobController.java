/**
 * 
 */
package com.skill.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skill.ApiResponse;
import com.skill.dtos.JobDTO;
import com.skill.services.JobServices;

/**
 * The Class JobController.
 *
 * @author Ebin
 */
@RestController
@RequestMapping("/jobs")
public class JobController
{
	
	/** The api response. */
	private ApiResponse apiResponse;

	/** The job services. */
	@Autowired
	private JobServices jobServices;

	/**
	 * Save job.
	 *
	 * @param jobDto the job dto
	 * @return the response entity
	 */
	@PostMapping(value = "/save")
	public ResponseEntity<ApiResponse> saveJob(@Valid @RequestBody JobDTO jobDto)
	{
		apiResponse = new ApiResponse(1, "Success", jobServices.saveNewJob(jobDto));
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	/**
	 * Gets the preferred jobs.
	 *
	 * @param candidateId the candidate id
	 * @param locationId the location id
	 * @return the preferred jobs
	 */
	@GetMapping(value = "/get/preferred")
	public ResponseEntity<ApiResponse> getPreferredJobs(
			@RequestParam(value = "candidateId", required = true) Long candidateId,
			@RequestParam(value = "locationId", required = true) Long locationId)
	{
		apiResponse = new ApiResponse(1, "Success", jobServices.findCandidatePreferredJobs(candidateId, candidateId));
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
}

/**
 * 
 */
package com.skill.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skill.ApiResponse;
import com.skill.dtos.UserDTO;
import com.skill.services.UserServices;

/**
 * @author Ebin
 *
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController
{
	private ApiResponse apiResponse;
	
	private UserServices candidateServices;
	
	@PostMapping(value = "/save")
	public ResponseEntity<ApiResponse> saveCandidate(@Valid @RequestBody UserDTO candidate)
	{
		apiResponse = new ApiResponse(1, "Success", candidateServices.saveNew(candidate));
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
}

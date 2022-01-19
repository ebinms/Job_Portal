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
import org.springframework.web.bind.annotation.RestController;

import com.skill.ApiResponse;
import com.skill.entities.Skill;
import com.skill.services.MasterServices;

/**
 * @author Ebin
 *
 */
@RestController
@RequestMapping("/skills")
public class SkillController
{

	private ApiResponse apiResponse;

	@Autowired
	private MasterServices skillServices;

	@PostMapping(value = "/save")
	public ResponseEntity<ApiResponse> saveNewSkill(@Valid @RequestBody Skill skill)
	{
		apiResponse = new ApiResponse(1, "Success", skillServices.saveNew(skill));
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/all")
	public ResponseEntity<ApiResponse> getAllSkills()
	{
		apiResponse = new ApiResponse(1, "Success", skillServices.findAllSkills());
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
}

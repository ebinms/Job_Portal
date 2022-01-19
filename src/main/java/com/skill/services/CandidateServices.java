/**
 * 
 */
package com.skill.services;

import java.util.List;

import com.skill.dtos.CandidateDTO;
import com.skill.entities.Candidate;

/**
 * @author Ebin
 *
 */
public interface CandidateServices
{
	Candidate saveNew(CandidateDTO candidate);

	Candidate findOne(Long candidateId);

	List<Candidate> findAll();
}

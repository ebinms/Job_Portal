/**
 * 
 */
package com.skill.services;

import java.util.List;

import com.skill.dtos.UserDTO;
import com.skill.entities.User;

/**
 * @author Ebin
 *
 */
public interface UserServices
{
	User saveNew(UserDTO candidate);

	User findOne(Long candidateId);

	List<User> findAll();
}

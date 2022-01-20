/**
 * 
 */
package com.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skill.entities.User;

/**
 * @author Ebin
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	
}

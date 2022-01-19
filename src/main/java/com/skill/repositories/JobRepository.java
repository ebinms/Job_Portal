/**
 * 
 */
package com.skill.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skill.entities.Job;

/**
 * @author Ebin
 *
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long>
{
	List<Job> findAllByJobSkillsSkillIdIn(List<Long> skillIds);

	List<Job> findAllByJobSkillsSkillIdInAndJobLocationsId(List<Long> skillIds, Long locationId);
}

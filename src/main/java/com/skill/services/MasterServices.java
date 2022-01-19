package com.skill.services;

import java.util.List;

import com.skill.entities.Company;
import com.skill.entities.Location;
import com.skill.entities.Skill;

/**
 * The Interface MasterServices.
 */
public interface MasterServices
{
	
	/**
	 * Save new.
	 *
	 * @param skill the skill
	 * @return the skill
	 */
	Skill saveNew(Skill skill);

	/**
	 * Update skill.
	 *
	 * @param skill the skill
	 * @return the skill
	 */
	Skill updateSkill(Skill skill);

	/**
	 * Find one skill by id.
	 *
	 * @param id the id
	 * @return the skill
	 */
	Skill findOneSkillById(Long id);

	/**
	 * Find all skills.
	 *
	 * @return the list
	 */
	List<Skill> findAllSkills();

	/**
	 * Find all skills by ids.
	 *
	 * @param skillIds the skill ids
	 * @return the list
	 */
	List<Skill> findAllSkillsByIds(List<Long> skillIds);

	/**
	 * Find location.
	 *
	 * @param locationId the location id
	 * @return the location
	 */
	Location findLocation(Long locationId);

	/**
	 * Find locations by ids.
	 *
	 * @param locationIds the location ids
	 * @return the list
	 */
	List<Location> findLocationsByIds(List<Long> locationIds);
	
	/**
	 * Find company.
	 *
	 * @param companyId the company id
	 * @return the company
	 */
	Company findCompany(Long companyId);
}

package com.skill.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.skill.entities.Company;
import com.skill.entities.Location;
import com.skill.entities.Skill;
import com.skill.repositories.CompanyRepository;
import com.skill.repositories.LocationRepository;
import com.skill.repositories.SkillRepository;
import com.skill.services.MasterServices;

/**
 * The Class MasterServicesImpl.
 */
@Service
public class MasterServicesImpl implements MasterServices
{

	/** The skill repo. */
	@Autowired
	private SkillRepository skillRepo;

	/** The location repo. */
	@Autowired
	private LocationRepository locationRepo;
	
	/** The company repo. */
	@Autowired
	private CompanyRepository companyRepo;

	/**
	 * Save new.
	 *
	 * @param skill the skill
	 * @return the skill
	 */
	@CacheEvict(value = "skills", allEntries = true)
	@Override
	public Skill saveNew(Skill skill)
	{
		skill.setAddDate(LocalDate.now());
		skill.setModDate(LocalDateTime.now());
		skill.setStatus('A');
		return skillRepo.saveAndFlush(skill);
	}

	/**
	 * Update skill.
	 *
	 * @param skill the skill
	 * @return the skill
	 */
	@CacheEvict(value = "skills", allEntries = true)
	@Override
	public Skill updateSkill(Skill skill)
	{
		return null;
	}

	/**
	 * Find one skill by id.
	 *
	 * @param id the id
	 * @return the skill
	 */
	@Override
	public Skill findOneSkillById(Long id)
	{
		Optional<Skill> skill = skillRepo.findById(id);
		return skill.isPresent() ? skill.get() : null;
	}

	/**
	 * Find all skills.
	 *
	 * @return the list
	 */
	@Cacheable("skills")
	@Override
	public List<Skill> findAllSkills()
	{
		return skillRepo.findAll();
	}

	/**
	 * Find all skills by ids.
	 *
	 * @param jobSkills the job skills
	 * @return the list
	 */
	@Override
	public List<Skill> findAllSkillsByIds(List<Long> jobSkills)
	{
		if (Objects.nonNull(jobSkills))
		{
			jobSkills = jobSkills.stream().filter(Objects::nonNull).collect(Collectors.toList());
			if (!jobSkills.isEmpty())
			{
				return skillRepo.findAllById(jobSkills);
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Find location.
	 *
	 * @param locationId the location id
	 * @return the location
	 */
	@Override
	public Location findLocation(Long locationId)
	{
		Optional<Location> location = locationRepo.findById(locationId);
		return location.isPresent() ? location.get() : null;
	}

	/**
	 * Find locations by ids.
	 *
	 * @param locationIds the location ids
	 * @return the list
	 */
	@Override
	public List<Location> findLocationsByIds(List<Long> locationIds)
	{
		if (Objects.nonNull(locationIds))
		{
			locationIds = locationIds.stream().filter(Objects::nonNull).collect(Collectors.toList());
			if (!locationIds.isEmpty())
			{
				return locationRepo.findAllById(locationIds);
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Find company.
	 *
	 * @param companyId the company id
	 * @return the company
	 */
	@Override
	public Company findCompany(Long companyId)
	{
		Optional<Company> company = companyRepo.findById(companyId);
		return company.isPresent() ? company.get() : null;
	}

}

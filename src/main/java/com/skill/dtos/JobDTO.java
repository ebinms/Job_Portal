/**
 * 
 */
package com.skill.dtos;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ebin
 *
 */
public class JobDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long jobId;

	private String name;

	private String description;

	private Character status;

	private Long company;

	private List<Long> jobSkills;

	private List<Long> jobLocations;

	public Long getJobId()
	{
		return jobId;
	}

	public void setJobId(Long jobId)
	{
		this.jobId = jobId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Character getStatus()
	{
		return status;
	}

	public void setStatus(Character status)
	{
		this.status = status;
	}

	public List<Long> getJobSkills()
	{
		return jobSkills;
	}

	public void setJobSkills(List<Long> jobSkills)
	{
		this.jobSkills = jobSkills;
	}

	public List<Long> getJobLocations()
	{
		return jobLocations;
	}

	public void setJobLocations(List<Long> jobLocations)
	{
		this.jobLocations = jobLocations;
	}

	public Long getCompany()
	{
		return company;
	}

	public void setCompany(Long company)
	{
		this.company = company;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobDTO other = (JobDTO) obj;
		if (jobId == null)
		{
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

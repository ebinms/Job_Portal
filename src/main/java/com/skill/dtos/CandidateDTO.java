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
public class CandidateDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long candidateId;

	private String name;

	private Long mobile;

	private String email;

	private Character status;

	private Long location;

	private List<Long> candidateSkills;

	private List<Long> preferredLocations;

	public Long getCandidateId()
	{
		return candidateId;
	}

	public void setCandidateId(Long candidateId)
	{
		this.candidateId = candidateId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Long getMobile()
	{
		return mobile;
	}

	public void setMobile(Long mobile)
	{
		this.mobile = mobile;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Character getStatus()
	{
		return status;
	}

	public void setStatus(Character status)
	{
		this.status = status;
	}

	public Long getLocation()
	{
		return location;
	}

	public void setLocation(Long location)
	{
		this.location = location;
	}

	public List<Long> getCandidateSkills()
	{
		return candidateSkills;
	}

	public void setCandidateSkills(List<Long> candidateSkills)
	{
		this.candidateSkills = candidateSkills;
	}

	public List<Long> getPreferredLocations()
	{
		return preferredLocations;
	}

	public void setPreferredLocations(List<Long> preferredLocations)
	{
		this.preferredLocations = preferredLocations;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidateId == null) ? 0 : candidateId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		CandidateDTO other = (CandidateDTO) obj;
		if (candidateId == null)
		{
			if (other.candidateId != null)
				return false;
		} else if (!candidateId.equals(other.candidateId))
			return false;
		if (email == null)
		{
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile == null)
		{
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}
}

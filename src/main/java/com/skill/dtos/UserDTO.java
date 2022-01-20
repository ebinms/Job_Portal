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
public class UserDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long userId;

	private String name;

	private Long mobile;

	private String email;
	
	private String userType;

	private Character status;

	private Long location;

	private List<Long> candidateSkills;

	private List<Long> preferredLocations;

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long candidateId)
	{
		this.userId = candidateId;
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

	public String getUserType()
	{
		return userType;
	}

	public void setUserType(String userType)
	{
		this.userType = userType;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (userId == null)
		{
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
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

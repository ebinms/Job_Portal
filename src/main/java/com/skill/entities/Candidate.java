/**
 * 
 */
package com.skill.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author Ebin
 *
 */
@Entity
@Table(name = "candidates")
public class Candidate implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Long candidateId;

	@NotBlank(message = "Candidate name is a mandatory field")
	@Column(name = "name")
	private String name;

	@NotNull(message = "Mobile number is mandatory")
	@Column(name = "mobile")
	private Long mobile;

	@Email(message = "Invalid Email")
	@Column(name = "email")
	private String email;

	@Column(name = "status")
	private Character status;

	@Column(name = "add_date")
	private LocalDate addDate;

	@Column(name = "mod_date")
	private LocalDateTime modDate;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany
	@JoinTable(name = "candidate_skills", joinColumns = @JoinColumn(name = "candidate_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> candidateSkills;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany
	@JoinTable(name = "candidate_preferred_locations", joinColumns = @JoinColumn(name = "candidate_id"), inverseJoinColumns = @JoinColumn(name = "location_id", referencedColumnName = "id"))
	private List<Location> preferredLocations;

	public Long getCandidateId()
	{
		return candidateId;
	}

	public void setCandidateId(Long candidateId)
	{
		this.candidateId = candidateId;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Character getStatus()
	{
		return status;
	}

	public void setStatus(Character status)
	{
		this.status = status;
	}

	public LocalDate getAddDate()
	{
		return addDate;
	}

	public void setAddDate(LocalDate addDate)
	{
		this.addDate = addDate;
	}

	public LocalDateTime getModDate()
	{
		return modDate;
	}

	public void setModDate(LocalDateTime modDate)
	{
		this.modDate = modDate;
	}

	public List<Skill> getCandidateSkills()
	{
		return candidateSkills;
	}

	public void setCandidateSkills(List<Skill> candidateSkills)
	{
		this.candidateSkills = candidateSkills;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public List<Location> getPreferredLocations()
	{
		return preferredLocations;
	}

	public void setPreferredLocations(List<Location> preferredLocations)
	{
		this.preferredLocations = preferredLocations;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidateId == null) ? 0 : candidateId.hashCode());
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
		Candidate other = (Candidate) obj;
		if (candidateId == null)
		{
			if (other.candidateId != null)
				return false;
		} else if (!candidateId.equals(other.candidateId))
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

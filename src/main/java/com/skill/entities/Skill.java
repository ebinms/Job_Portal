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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author Ebin
 *
 */
@Entity
@Table(name = "skill_master")
public class Skill implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private Long skillId;

	@NotBlank(message = "Skill name is mandatory")
	@Column(name = "skill")
	private String skill;

	@Column(name = "status")
	private Character status;

	@Column(name = "add_date")
	private LocalDate addDate;

	@Column(name = "mod_date")
	private LocalDateTime modDate;

	@ManyToMany(mappedBy = "candidateSkills")
	private List<Candidate> candidates;
	
	@ManyToMany(mappedBy = "jobSkills")
	private List<Job> jobs ;

	public Long getSkillId()
	{
		return skillId;
	}

	public void setSkillId(Long skillId)
	{
		this.skillId = skillId;
	}

	public String getSkill()
	{
		return skill;
	}

	public void setSkill(String skill)
	{
		this.skill = skill;
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

	public List<Candidate> getCandidates()
	{
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates)
	{
		this.candidates = candidates;
	}
	
	public List<Job> getJobs()
	{
		return jobs;
	}

	public void setJobs(List<Job> jobs)
	{
		this.jobs = jobs;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Skill other = (Skill) obj;
		if (skill == null)
		{
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (skillId == null)
		{
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		if (status == null)
		{
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}

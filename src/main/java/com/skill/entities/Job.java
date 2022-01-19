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
import javax.validation.constraints.NotBlank;

/**
 * @author Ebin
 *
 */
@Entity
@Table(name = "jobs")
public class Job implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private Long jobId;

	@NotBlank(message = "Job name is mandatory field")
	@Column(name = "name")
	private String name;

	@NotBlank(message = "Job description is a mandatory field")
	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private Character status;

	@Column(name = "add_date")
	private LocalDate addDate = LocalDate.now();

	@Column(name = "mod_date")
	private LocalDateTime modDate;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToMany
	@JoinTable(name = "job_skills", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> jobSkills;

	@ManyToMany
	@JoinTable(name = "job_locations", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "location_id", referencedColumnName = "id"))
	private List<Location> jobLocations;

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

	public List<Skill> getJobSkills()
	{
		return jobSkills;
	}

	public void setJobSkills(List<Skill> jobSkills)
	{
		this.jobSkills = jobSkills;
	}

	public Company getCompany()
	{
		return company;
	}

	public void setCompany(Company company)
	{
		this.company = company;
	}

	public List<Location> getJobLocations()
	{
		return jobLocations;
	}

	public void setJobLocations(List<Location> jobLocations)
	{
		this.jobLocations = jobLocations;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Job other = (Job) obj;
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
		if (status == null)
		{
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}

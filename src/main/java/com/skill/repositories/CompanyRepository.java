/**
 * 
 */
package com.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skill.entities.Company;

/**
 * @author Ebin
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>
{

}

/**
 * 
 */
package com.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skill.entities.Location;

/**
 * @author Ebin
 *
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long>
{

}

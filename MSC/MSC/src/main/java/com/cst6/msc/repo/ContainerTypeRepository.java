/**
 * 
 */
package com.cst6.msc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst6.msc.model.ContainerType;

/**
 * @author SasankaN
 *
 */
@Repository
public interface ContainerTypeRepository extends JpaRepository<ContainerType, Integer>{

}

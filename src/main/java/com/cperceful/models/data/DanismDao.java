package com.cperceful.models.data;

import com.cperceful.models.Danism;
import org.springframework.data.repository.CrudRepository;

/**
 * Data access object for Danisms
 */
public interface DanismDao extends CrudRepository<Danism, Integer> {
}

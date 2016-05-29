package com.lepsec.repositories;

import com.lepsec.domain.Aircraft;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jnieto on 29/5/16.
 */
public interface AircraftRepository extends CrudRepository<Aircraft,Integer> {
}

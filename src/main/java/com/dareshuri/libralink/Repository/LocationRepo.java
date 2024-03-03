package com.dareshuri.libralink.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.Location;

@Repository
public interface LocationRepo extends CrudRepository<Location,Long> {}

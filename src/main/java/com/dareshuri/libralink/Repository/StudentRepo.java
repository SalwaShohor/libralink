package com.dareshuri.libralink.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dareshuri.libralink.Model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student,Long> {}
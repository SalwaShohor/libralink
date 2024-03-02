package com.dareshuri.libralink.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dareshuri.libralink.Model.Student;
import java.util.Optional;


@Repository
public interface StudentRepo extends CrudRepository<Student,Long> {
    Optional<Student> findByUserId(Long userId);
}
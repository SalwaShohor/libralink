package com.dareshuri.libralink.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.Teacher;
import java.util.Optional;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher,Long> {

    //READ

    Iterable<Teacher> findAll();
    Optional<Teacher> findByUserId(Long userId);
    Optional<Teacher> findById(Long teacherId);

    // CREATE/UPDATE
    <S extends Teacher> S save(S teacher);

    // DELETE
    void deleteById(Long teacherId);

}

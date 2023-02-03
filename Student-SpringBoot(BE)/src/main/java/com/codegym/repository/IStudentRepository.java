package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student,Long> {
Iterable<Student>findAllByNameContaining(String name);

//        @Modifying
//    @Query(value = "select *from student,clazz where clazz.name like :clazz" ,nativeQuery = true)
    Iterable<Student> findStudentsByClazz_Name(@Param("clazz")String clazz);

//    @Modifying
//    @Query(value = "select *from student where clazz like :clazzname " ,nativeQuery = true)
//    Iterable<Student>findAllByClazz(@Param("clazzname") String clazzname);
//


}

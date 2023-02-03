package com.codegym.service;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements ICRUDService<Student, Long> {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.of(iStudentRepository.findById(id).get());
    }

    @Override
    public Student save(Student student) {
        iStudentRepository.save(student);
        return student;
    }

    @Override
    public void delete(Long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findByName(String name) {
        return iStudentRepository.findAllByNameContaining(name);
    }


    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Iterable<Student> findAllByClazz(String clazz) {
        return iStudentRepository.findStudentsByClazz_Name(clazz);
    }
}

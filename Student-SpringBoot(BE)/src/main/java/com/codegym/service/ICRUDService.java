package com.codegym.service;

import com.codegym.model.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICRUDService<T, Long>{
    Optional<T> findById(Long id);

    T save(T t);

    void delete(Long id);

    Iterable<T> findByName(String name);

    Iterable<T> findAll();
    Iterable<T> findAllByClazz(String clazz);
}

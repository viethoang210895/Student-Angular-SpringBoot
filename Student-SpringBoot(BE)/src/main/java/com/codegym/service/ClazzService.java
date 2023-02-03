package com.codegym.service;

import com.codegym.model.Clazz;

import com.codegym.repository.IClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClazzService implements ICRUDService<Clazz, Long> {
    @Autowired
    private IClazzRepository iClazzRepository;

    @Override
    public Optional<Clazz> findById(Long id) {
        return Optional.of(iClazzRepository.findById(id).get());
    }

    @Override
    public Clazz save(Clazz clazz) {
        iClazzRepository.save(clazz);
        return clazz;
    }

    @Override
    public void delete(Long id) {
        iClazzRepository.deleteById(id);
    }

    @Override
    public Iterable<Clazz> findByName(String name) {
        return iClazzRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Clazz> findAll() {
        return iClazzRepository.findAll();
    }

    @Override
    public Iterable<Clazz> findAllByClazz(String clazz) {
        return null;
    }


}

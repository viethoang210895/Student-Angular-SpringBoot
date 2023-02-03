package com.codegym.controller;

import com.codegym.model.Clazz;
import com.codegym.model.Student;
import com.codegym.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private ICRUDService<Clazz, Long> icrudService;

    @GetMapping
    public ResponseEntity<Iterable<Clazz>> showAllClazz() {
        Iterable<Clazz> clazzes = icrudService.findAll();
        if (!clazzes.iterator().hasNext()) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clazzes, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Clazz>findOneClazz(@PathVariable("id") Long id){
        Optional<Clazz> clazz=icrudService.findById(id);
        if (!clazz.isPresent()) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clazz.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Clazz> createClazz(@RequestBody Clazz clazz) {
        Clazz clazz1 = icrudService.save(clazz);
        return new ResponseEntity<>(clazz1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clazz> editClazz(@RequestBody Clazz clazzEdit, @PathVariable Long id) {
        Optional<Clazz> clazz1 = icrudService.findById(id);
        if (clazz1.isPresent()) {
            clazzEdit.setId(clazz1.get().getId());
            return new ResponseEntity<>(icrudService.save(clazzEdit), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Clazz> delete(@PathVariable("id") Long id) {
        Optional<Clazz> clazz = icrudService.findById(id);
        if (clazz.isPresent()) {
            icrudService.delete(id);
            return new ResponseEntity<>(clazz.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Clazz>> showAllByName(@RequestParam("clazz") String clazz) {
        Iterable<Clazz> clazzes = icrudService.findByName(clazz);
        if (!clazzes.iterator().hasNext()) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clazzes, HttpStatus.OK);
    }


}

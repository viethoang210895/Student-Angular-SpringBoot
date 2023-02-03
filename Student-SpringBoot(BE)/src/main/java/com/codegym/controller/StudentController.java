package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private ICRUDService<Student, Long> icrudService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> showAllStudent() {
        Iterable<Student> students = icrudService.findAll();
        if (!students.iterator().hasNext()) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> showOne(@PathVariable("id") Long id) {
        Optional<Student> student = icrudService.findById(id);
        if (!student.isPresent()) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student student1 = icrudService.save(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student studentEdit, @PathVariable("id") Long id) {
        Optional<Student> student = icrudService.findById(id);
        if (!student.isPresent()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentEdit.setId(student.get().getId());
        return new ResponseEntity<>(icrudService.save(studentEdit), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        Optional<Student> student = icrudService.findById(id);
        if (!student.isPresent()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        icrudService.delete(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Student>> showAllByName(@RequestParam("search") String name) {
        Iterable<Student> students = icrudService.findByName(name);
        if (!students.iterator().hasNext()) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/search-by-clazz")
    public ResponseEntity<Student> showAllByDay(@RequestParam("clazz")String clazz) {
        Iterable<Student>students= icrudService.findAllByClazz(clazz);
        return new ResponseEntity(students, HttpStatus.OK);
    }

}
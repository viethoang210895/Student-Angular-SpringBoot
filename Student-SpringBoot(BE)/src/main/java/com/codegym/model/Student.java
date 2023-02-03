package com.codegym.model;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Valid
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 2,max = 50,message = "bắt buộc phải từ 2-50 kí tự")
    private String name;
    @NotEmpty(message = "bắt buộc không được để trống")
    private String dob;
    @ManyToOne
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;

    public Student() {
    }

    public Student(Long id, String name, String dob, String img, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.clazz = clazz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}

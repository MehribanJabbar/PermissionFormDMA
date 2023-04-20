package com.example.dmaapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "department_tbl")
public class DepartmentStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String name;

    @OneToOne(mappedBy = "department")
    @Transient
    private MainTbl main;

    @OneToMany(mappedBy = "department")
    @Transient
    private List<SectionStructure> section;

    public DepartmentStructure(Long id, String name, MainTbl main, List<SectionStructure> section) {
        this.id = id;
        this.name = name;

        this.section = section;
    }

    public DepartmentStructure() {

    }

}

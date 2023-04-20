package com.example.dmaapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "section_tbl")
public class SectionStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "section_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentStructure department;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "mainTbl_id", referencedColumnName = "id")
//    private MainTbl mainTbl;

    @OneToOne(mappedBy = "section")
    @Transient
    private MainTbl main;

    public SectionStructure() {
    }

    public SectionStructure(Long id, String name, DepartmentStructure department) {
        this.id = id;
        this.name = name;
        this.department = department;

    }
}

package com.example.dmaapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name = "main_tbl")
public class MainTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private DepartmentStructure department;

//    @OneToOne(mappedBy = "mainTbl")
//    private DepartmentStructure departmentStructure;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private SectionStructure section;

//    @OneToOne(mappedBy = "mainTbl")
//    private SectionStructure sectionStructure;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

//    @OneToOne(mappedBy = "mainTbl")
//    private Position position;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;


    private String startTime;

    private String endTime;

    private String note;

//    public MainTbl(Long id, DepartmentStructure department, SectionStructure section, Position position, String email, Date startDate, Date endDate, String startTime, String endTime, String note) {
//        this.id = id;
//        this.department = department;
//        this.section = section;
//        this.position = position;
//        this.email = email;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.note = note;
//    }

//    public MainTbl() {
//    }
}

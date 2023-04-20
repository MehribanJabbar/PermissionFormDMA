package com.example.dmaapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "position_tbl")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position_name")
    private String name;

    @OneToOne(mappedBy = "position")
    @Transient
    private MainTbl main;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "mainTbl_id", referencedColumnName = "id")
//    private MainTbl mainTbl;


    public Position(Long id, String name, MainTbl main) {
        this.id = id;
        this.name = name;

    }

    public Position() {
    }
}

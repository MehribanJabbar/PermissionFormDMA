package com.example.dmaapp.repository;

import com.example.dmaapp.entity.DepartmentStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentStructure, Long> {

    List<DepartmentStructure> findAll();



}

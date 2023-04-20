package com.example.dmaapp.service;

import com.example.dmaapp.entity.DepartmentStructure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    List<DepartmentStructure> findAll();
    DepartmentStructure find(Long id);

    DepartmentStructure saveDepartment(DepartmentStructure department);



}

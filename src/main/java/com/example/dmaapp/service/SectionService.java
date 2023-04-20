package com.example.dmaapp.service;

import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.entity.SectionStructure;

import java.util.List;

public interface SectionService {

    List<SectionStructure> findAll();

    List<SectionStructure> findByDepartment(Long id);

    SectionStructure find(Long id);

    SectionStructure saveSection(SectionStructure section);

}

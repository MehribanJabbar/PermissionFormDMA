package com.example.dmaapp.repository;

import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.entity.SectionStructure;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<SectionStructure, Long> {
      List<SectionStructure> findByDepartment(long id);

      List<SectionStructure> findAll();
}

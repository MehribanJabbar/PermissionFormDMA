package com.example.dmaapp.repository;

import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.entity.MainTbl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MainRepository extends JpaRepository<MainTbl, Long> {

    List<MainTbl> findAll();
}

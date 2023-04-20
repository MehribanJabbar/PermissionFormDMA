package com.example.dmaapp.repository;

import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {

    List<Position> findAll();
}

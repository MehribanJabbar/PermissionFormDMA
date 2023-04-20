package com.example.dmaapp.service;
import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.entity.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {

    List<Position> findAll();
    Position find(Long id);

    Position savePosition(Position position);
}

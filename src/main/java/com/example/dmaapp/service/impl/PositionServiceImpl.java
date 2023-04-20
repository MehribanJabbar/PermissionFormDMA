package com.example.dmaapp.service.impl;

import com.example.dmaapp.entity.Position;
import com.example.dmaapp.repository.PositionRepository;
import com.example.dmaapp.service.PositionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Data
public class PositionServiceImpl implements PositionService {

    private final   PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        try {
            positions = positionRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return positions;
    }

    @Override
    public Position find(Long id) {
        return positionRepository.findById(id).get();
    }

    @Override
    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }
}

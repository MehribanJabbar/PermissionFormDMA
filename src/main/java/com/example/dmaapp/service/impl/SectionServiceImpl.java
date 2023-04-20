package com.example.dmaapp.service.impl;

import com.example.dmaapp.entity.SectionStructure;
import com.example.dmaapp.repository.SectionRepository;
import com.example.dmaapp.service.SectionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class SectionServiceImpl implements SectionService {

    private final   SectionRepository sectionRepository;



    @Override
    public List<SectionStructure> findAll() {
        List<SectionStructure> sectionStructures = new ArrayList<>();
        try {
            sectionStructures = sectionRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return sectionStructures;
    }

    @Override
    public List<SectionStructure> findByDepartment(Long id) {
        return sectionRepository.findByDepartment(id);
    }

    @Override
    public SectionStructure find(Long id) {
        return sectionRepository.findById(id).get();
    }

    @Override
    public SectionStructure saveSection(SectionStructure section) {
        return sectionRepository.save(section);
    }


}

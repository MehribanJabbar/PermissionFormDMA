package com.example.dmaapp.service.impl;
import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.repository.DepartmentRepository;
import com.example.dmaapp.service.DepartmentService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentStructure> findAll() {
        List<DepartmentStructure> departmentStructures = new ArrayList<>();
        try {
            departmentStructures = departmentRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return departmentStructures;
    }

    @Override
    public DepartmentStructure find(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public DepartmentStructure saveDepartment(DepartmentStructure department) {
        return departmentRepository.save(department);
    }


}

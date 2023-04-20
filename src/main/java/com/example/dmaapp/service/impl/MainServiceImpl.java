package com.example.dmaapp.service.impl;

import com.example.dmaapp.entity.MainTbl;
import com.example.dmaapp.repository.MainRepository;
import com.example.dmaapp.service.MainService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Data
public class MainServiceImpl implements MainService {

    private final MainRepository mainRepository;

    @Override
    public  void save(MainTbl mainTbl) {
        mainRepository.save(mainTbl);
    }

    @Override
    public List<MainTbl> findAll() {
        List<MainTbl> mainTblList = new ArrayList<>();
        try {
            mainTblList = mainRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }

        return mainTblList;
    }
}

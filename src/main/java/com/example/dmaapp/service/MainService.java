package com.example.dmaapp.service;

import com.example.dmaapp.entity.MainTbl;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MainService {

     void save(MainTbl mainTbl);

     List<MainTbl> findAll();
}

package com.example.dmaapp.runner;

import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.entity.MainTbl;
import com.example.dmaapp.entity.Position;
import com.example.dmaapp.entity.SectionStructure;
import com.example.dmaapp.repository.DepartmentRepository;
import com.example.dmaapp.repository.PositionRepository;
import com.example.dmaapp.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class AddDateToBase implements CommandLineRunner {

    @Autowired
    private  DepartmentRepository departmentRepository;
    @Autowired
    private  SectionRepository sectionRepository;
    @Autowired
    private  PositionRepository positionRepository;

    @Override
    public void run(String... args) throws Exception {

        DepartmentStructure d1=new DepartmentStructure(1L,"Əmək bazarının təhlili və inkişafı departamenti",new MainTbl(),new ArrayList<>());
        DepartmentStructure d2=new DepartmentStructure(2L, "Aktiv məşğulluq tədbirləri departamenti",new MainTbl(), new ArrayList<>());
        DepartmentStructure d3=new DepartmentStructure(3L,"Peşə hazırlığı departamenti",new MainTbl(), new ArrayList<>());
        DepartmentStructure d4=new DepartmentStructure(4L,"Rəqəmsal məşğulluğun təşkili departamenti", new MainTbl(), new ArrayList<>());
        DepartmentStructure d5=new DepartmentStructure(5L,"Sosial tərəfdaşlarla iş departamenti",new MainTbl(), new ArrayList<>());

        departmentRepository.save(d1);
        departmentRepository.save(d2);
        departmentRepository.save(d3);
        departmentRepository.save(d4);
        departmentRepository.save(d5);


        SectionStructure s1d1= new SectionStructure(1l,"Statistika şöbəsi",d1);
        SectionStructure s2d1=new SectionStructure(2L,"Əmək bazarının təhlili şöbəsi ", d1);
        SectionStructure s3d1=new SectionStructure(3L, "Strateji inkişaf şöbəsi", d1);

        SectionStructure s1d2=new SectionStructure(4L,"Özünüməşğulluq şöbəsi", d2);
        SectionStructure s2d2=new SectionStructure(5L, "İşsizlikdən sığorta şöbəsi",d2);
        SectionStructure s3d2=new SectionStructure(6L,"İctimai işlərlə iş şöbəsi", d2);

        SectionStructure s1d3=new SectionStructure(7L,"Peşə hazırlığı mərkəzləri ilə iş şöbəsi", d3);
        SectionStructure s2d3=new SectionStructure(8L,"Tədris müəssisələri ilə iş şöbəsi", d3);

        SectionStructure s1d4=new SectionStructure(9L,"Elektron xidmətlərin təşkili şöbəsi", d4);
        SectionStructure s2d4=new SectionStructure(10L, "Məşğulluqda rəqəmsal innovasiyalar şöbəsi", d4);
        SectionStructure s3d4=new SectionStructure(11L, "Məlumatların təhlili şöbəsi", d4);

        SectionStructure s1d5=new SectionStructure(12L,"Sosial proqramlar şöbəsi",d5);
        SectionStructure s2d5=new SectionStructure(13L,"Sosial əməkdaşlıq şöbəsi",d5);
        SectionStructure s3d5=new SectionStructure(14L,"Qeyri-formal məşğulluğa nəzarət şöbəsi",d5);


        sectionRepository.save(s1d1);
        sectionRepository.save(s2d1);
        sectionRepository.save(s3d1);


        sectionRepository.save(s1d2);
        sectionRepository.save(s2d2);
        sectionRepository.save(s3d2);


        sectionRepository.save(s1d3);
        sectionRepository.save(s2d3);


        sectionRepository.save(s1d4);
        sectionRepository.save(s2d4);
        sectionRepository.save(s3d4);


        sectionRepository.save(s1d5);
        sectionRepository.save(s2d5);
        sectionRepository.save(s3d5);

        Position p1=new Position(1L,"Aparıcı mütəxəssis",null);
        Position p2=new Position(2L,"Baş Aparıcı mütəxəssis",null);
        Position p3=new Position(3L,"Böyük mütəxəssis",null);


        positionRepository.save(p1);
        positionRepository.save(p2);
        positionRepository.save(p3);

    }
}

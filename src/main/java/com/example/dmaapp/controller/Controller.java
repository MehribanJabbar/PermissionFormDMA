package com.example.dmaapp.controller;


import com.example.dmaapp.entity.*;
import com.example.dmaapp.repository.DepartmentRepository;
import com.example.dmaapp.repository.SectionRepository;
import com.example.dmaapp.service.DepartmentService;
import com.example.dmaapp.service.MainService;
import com.example.dmaapp.service.PositionService;
import com.example.dmaapp.service.SectionService;
import lombok.Data;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.stereotype.Controller
@Data
@RequestMapping("/view")
public class Controller {

    private final DepartmentService departmentService;

    private final SectionService sectionService;

    private final PositionService positionService;

    private final MainService mainService;

    private final DepartmentRepository departmentRepository;

    private final SectionRepository sectionRepository;

    @GetMapping("/home")
    public  String indexPage(){
        return  "layout";
    }



    @GetMapping("/permission")
    public String index(Model model,MainTbl mainTbl){
        List<MainTbl> mainTbls = mainService.findAll();
        model.addAttribute("mainTbls",mainTbls);

        List<DepartmentStructure> departments=departmentService.findAll();
        List<SectionStructure>  sections= sectionService.findAll();
        List<Position> positions=positionService.findAll();
        model.addAttribute("departments",departments);
        model.addAttribute("sections", sections);
        model.addAttribute("positions", positions);

        return "permission";
    }


    @PostMapping("/save-permit")
    public String save(@Validated MainTbl mainTbl, Model model){
        mainTbl.setDepartment(departmentService.find(mainTbl.getDepartment().getId()));
        mainTbl.setSection(sectionService.find(mainTbl.getSection().getId()));
        mainTbl.setPosition(positionService.find(mainTbl.getPosition().getId()));
        mainService.save(mainTbl);
        return "redirect:/view/permission";
    }
}

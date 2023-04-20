package com.example.dmaapp.controller;

import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.entity.SectionStructure;
import com.example.dmaapp.repository.SectionRepository;
import com.example.dmaapp.service.DepartmentService;
import com.example.dmaapp.service.SectionService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Data
@RequestMapping("/view")
public class SectionController {
    private final DepartmentService departmentService;
    private final SectionService sectionService;
    private final SectionRepository sectionRepository;

    @GetMapping("/section-page")
    public String addSection(Model model){
        SectionStructure addSections=new SectionStructure();
        model.addAttribute("section", addSections);
        model.addAttribute("sections", sectionService.findAll());
        List<DepartmentStructure> departments= departmentService.findAll();
        model.addAttribute("departments",departments);
        return "addSection";
    }

    @PostMapping("/save-section")
    public String saveSection(@Validated SectionStructure section, Model model){
        sectionService.saveSection(section);
        return "redirect:section-page";
    }

    @GetMapping ("/edit/section/{id}")
    public String editSection(@PathVariable("id") Long id, Model model){
        List<DepartmentStructure> departments= departmentService.findAll();
        SectionStructure section=sectionRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid user id:"+id));
        model.addAttribute("section", section);
        model.addAttribute("departments",departments);
        return "editSection";
    }

    @PostMapping("/update/section/{id}")
    public String updateSection(@PathVariable("id") long id, @Validated SectionStructure section, BindingResult result, Model model){
        if (result.hasErrors()){
            section.setId(id);
            return "editSection";
        }
        sectionRepository.save(section);
        return "redirect:/view/section-page";
    }

    @GetMapping("/delete/section/{id}")
    public String deleteSection(@PathVariable("id") long id) {
        SectionStructure section=sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id is not found" + id));
        sectionRepository.delete(section);
        return "redirect:/view/section-page";
    }


}

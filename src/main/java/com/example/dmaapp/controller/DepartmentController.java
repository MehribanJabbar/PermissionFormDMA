package com.example.dmaapp.controller;

import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.repository.DepartmentRepository;
import com.example.dmaapp.service.DepartmentService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@Data
@RequestMapping("/view")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    @GetMapping("/department-page")
    public String addDepartment(Model model){
        DepartmentStructure addDepartments=new DepartmentStructure();
        model.addAttribute("department", addDepartments);
        model.addAttribute("departments",departmentService.findAll());
        return "addDepartment";
    }


    @PostMapping("/save-department")
    public String saveDepartment(@Validated DepartmentStructure department, Model model){
        // model.addAttribute("department", department);
        departmentService.saveDepartment(department);
        return "redirect:department-page";
    }

    @GetMapping ("/edit/department/{id}")
    public String editDepartment(@PathVariable("id") Long id, Model model){
        DepartmentStructure department=departmentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid user id:"+id));
        model.addAttribute("department", department);
        return "editDepartment";
    }

    @PostMapping("/update/department/{id}")
    public String updateDepartment(@PathVariable("id") long id, @Validated DepartmentStructure department, BindingResult result, Model model){
        if (result.hasErrors()){
            department.setId(id);
            return "editDepartment";
        }
        departmentRepository.save(department);
        return "redirect:/view/department-page";
    }

    @GetMapping("/delete/department/{id}")
    public String deleteDepartment(@PathVariable("id") long id) {
        DepartmentStructure department=departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id is not found" + id));
        departmentRepository.delete(department);
        return "redirect:/view/department-page";
    }
}

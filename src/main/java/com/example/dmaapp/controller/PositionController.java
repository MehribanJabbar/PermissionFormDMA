package com.example.dmaapp.controller;

import com.example.dmaapp.entity.DepartmentStructure;
import com.example.dmaapp.entity.Position;
import com.example.dmaapp.repository.PositionRepository;
import com.example.dmaapp.service.PositionService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Data
@RequestMapping("/view")

public class PositionController {
    private final PositionService positionService;

    private final PositionRepository positionRepository;

    @GetMapping("/position-page")
    public String addPosition(Model model){
        Position addPosition= new Position();
        model.addAttribute("position", addPosition);
        model.addAttribute("positions", positionService.findAll());
        return "addPosition";
    }

    @PostMapping("/save-position")
    public String savePosition(@Validated Position position, Model model){
        positionService.savePosition(position);
        return "redirect:position-page";
    }

    @GetMapping ("/edit/position/{id}")
    public String editPosition(@PathVariable("id") Long id, Model model){
        Position position=positionRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid user id:"+id));
        model.addAttribute("position", position);
        return "editPosition";
    }

    @PostMapping("/update/position/{id}")
    public String updatePosition(@PathVariable("id") long id, @Validated Position position, BindingResult result, Model model){
        if (result.hasErrors()){
            position.setId(id);
            return "editPosition";
        }
        positionRepository.save(position);
        return "redirect:/view/position-page";
    }

    @GetMapping("/delete/position/{id}")
    public String deletePosition(@PathVariable("id") long id) {
        Position position=positionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id is not found" + id));
        positionRepository.delete(position);
        return "redirect:/view/position-page";
    }

}

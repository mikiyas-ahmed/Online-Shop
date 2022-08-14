package com.example.onlineshop.controllers;

import com.example.onlineshop.entity.MensCloth;
import com.example.onlineshop.services.MensClothRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cloth/men")
public class MenClothController {

    MensClothRepositoryService menService;

    @Autowired
    public MenClothController(MensClothRepositoryService menService){ this.menService=menService; }

    @GetMapping
    public String getMenClothList( Model model){
        List<MensCloth> clothList =  menService.findAll();
        model.addAttribute("menClothList",clothList);
        return "mens_cloth/list_mens_cloth";
    }

    @GetMapping("/cheapest")
    public String getSortedClothList(Model model){
        List<MensCloth> sortedMenCloth= menService.sortedList();
        model.addAttribute("menClothList",sortedMenCloth);
        return "mens_cloth/list_mens_cloth";
    }

    @GetMapping("/{id}")
    public String getMensClothById(@PathVariable("id") Long id, Model model) {
        MensCloth cloth = menService.findById(id);
        model.addAttribute("clothDetail",cloth);
        return "cloth_detail";
    }

    @GetMapping("/new")
    public String getMenClothRegisterForm( Model model) {
        MensCloth cloth = new MensCloth();
        model.addAttribute("menForm",cloth);
        return "mens_cloth/new_men_cloth";
    }

    @PostMapping("/save")
    public String saveClothToTheTable(MensCloth mensCloth) {
        menService.save(mensCloth);
        return "redirect:/cloth/men";
    }
}

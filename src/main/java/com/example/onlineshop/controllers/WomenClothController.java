package com.example.onlineshop.controllers;


import com.example.onlineshop.entity.WomensCloth;
import com.example.onlineshop.services.WomensClothRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cloth/women")
public class WomenClothController {

    WomensClothRepositoryService womenService;

    @Autowired
    public WomenClothController(WomensClothRepositoryService womenService){ this.womenService=womenService; }

    @GetMapping
    public String displayCloth(Model model){
        List<WomensCloth> clothList =  womenService.findAll();
        model.addAttribute("womenClothList",clothList);
        return "womens_cloth/list_womens_cloth";
    }

    @GetMapping("cheapest")
    public String displayCheapestCloth(Model model){
        List<WomensCloth> clothList = womenService.sortedList();
        model.addAttribute("womenClothList",clothList);
        return "womens_cloth/list_womens_cloth";
    }

    @GetMapping("/{id}")
    public String displayClothById(@PathVariable("id") Long id, Model model) {

        WomensCloth clothDetail =  womenService.findById(id);
        model.addAttribute("clothDetail",clothDetail);
        return "cloth_detail";
    }

    @GetMapping("/new")
    public String displayMenClothform( Model model) {
        WomensCloth cloth = new WomensCloth();
        model.addAttribute("womenForm",cloth);
        return "womens_cloth/new_womens_cloth";
    }

    @PostMapping("/save")
    public String saveNewCloth(WomensCloth womensCloth ) {
        womenService.save(womensCloth);
        return "redirect:/cloth/women";
    }
}

package com.example.onlineshop.controllers;

import com.example.onlineshop.entity.MensCloth;
import com.example.onlineshop.entity.WomensCloth;
import com.example.onlineshop.services.MensClothRepositoryService;
import com.example.onlineshop.services.WomensClothRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    WomensClothRepositoryService womenService;
    MensClothRepositoryService menService;

    @Autowired
    public HomeController(WomensClothRepositoryService womenService,
                          MensClothRepositoryService menService){
        this.womenService=womenService;
        this.menService=menService;
    }
    @GetMapping
    public String displayCloth( Model model){
        List<MensCloth> menClothList =  menService.findAll();
        model.addAttribute("menClothList",menClothList);
        List<WomensCloth> womenClothList =  womenService.findAll();
        model.addAttribute("womenClothList",womenClothList);
        return "home/list_cloth";
    }
}

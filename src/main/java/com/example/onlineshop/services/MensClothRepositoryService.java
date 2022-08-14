package com.example.onlineshop.services;

import com.example.onlineshop.dao.MensClothRepository;
import com.example.onlineshop.entity.MensCloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MensClothRepositoryService {

    MensClothRepository menRepo;

    @Autowired
    public MensClothRepositoryService(MensClothRepository menRepo){ this.menRepo=menRepo; }

    public MensCloth save(MensCloth employee) {
        return menRepo.save(employee);
    }

    public List<MensCloth> findAll() {
        return menRepo.findAll();
    }

    public MensCloth findById(Long id){ return menRepo.findById(id).get(); }

    public List<MensCloth> sortedList() {
        List<MensCloth> clothList= menRepo.findAll();
         Collections.sort(clothList, Comparator.comparingInt(MensCloth::getPrice));
        return clothList;
    }
}

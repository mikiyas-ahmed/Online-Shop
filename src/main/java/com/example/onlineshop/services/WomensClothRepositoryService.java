package com.example.onlineshop.services;

import com.example.onlineshop.dao.WomensClothRepository;
import com.example.onlineshop.entity.WomensCloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class WomensClothRepositoryService {

    WomensClothRepository womenRepo;

    @Autowired
    public WomensClothRepositoryService(WomensClothRepository womenRepo){ this.womenRepo=womenRepo; }

    public WomensCloth save(WomensCloth cloth) {
        return womenRepo.save(cloth);
    }

    public List<WomensCloth> findAll() { return womenRepo.findAll(); }

    public WomensCloth findById(Long id){ return womenRepo.findById(id).get(); }

    public List<WomensCloth> sortedList() {
        List<WomensCloth> clothList= womenRepo.findAll();
        Collections.sort(clothList, Comparator.comparingInt(WomensCloth::getPrice));
        return clothList;
    }
}

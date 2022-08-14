package com.example.onlineshop.dao;

import com.example.onlineshop.entity.MensCloth;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MensClothRepository extends CrudRepository <MensCloth,Long> {
     List<MensCloth> findAll();
}

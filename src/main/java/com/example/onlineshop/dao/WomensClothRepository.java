package com.example.onlineshop.dao;

import com.example.onlineshop.entity.WomensCloth;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WomensClothRepository extends CrudRepository <WomensCloth, Long> {
    List<WomensCloth> findAll();

}

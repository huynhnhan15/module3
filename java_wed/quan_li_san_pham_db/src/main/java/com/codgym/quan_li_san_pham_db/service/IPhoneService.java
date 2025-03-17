package com.codgym.quan_li_san_pham_db.service;

import com.codgym.quan_li_san_pham_db.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();

    Phone findById(int id);

    List<Phone> searchByName(String name);


}
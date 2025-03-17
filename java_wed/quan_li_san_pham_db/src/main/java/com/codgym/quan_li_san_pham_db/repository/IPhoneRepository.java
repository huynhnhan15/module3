package com.codgym.quan_li_san_pham_db.repository;

import com.codgym.quan_li_san_pham_db.model.Phone;

import java.util.List;

public interface IPhoneRepository {
    List<Phone> findAll();
    Phone findById(int id);
    boolean update(Phone phone);
    List<Phone> searchByName(String name);
}
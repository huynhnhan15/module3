package com.codgym.quan_li_san_pham_db.service;

import com.codgym.quan_li_san_pham_db.model.Phone;
import com.codgym.quan_li_san_pham_db.repository.IPhoneRepository;
import com.codgym.quan_li_san_pham_db.repository.PhoneRepository;

import java.util.List;

public class PhoneService implements IPhoneService {
    private IPhoneRepository phoneRepository = new PhoneRepository();

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findById(int id) {
        return phoneRepository.findById(id);
    }
}
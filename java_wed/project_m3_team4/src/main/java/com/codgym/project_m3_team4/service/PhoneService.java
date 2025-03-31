package com.codgym.project_m3_team4.service;

import com.codgym.project_m3_team4.model.Phone;


import com.codgym.project_m3_team4.repository.IPhoneRepository;
import com.codgym.project_m3_team4.repository.PhoneRepository;

import java.util.List;

public class PhoneService implements IPhoneService {

    private IPhoneRepository phoneRepository = new PhoneRepository();

    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.getAllPhones();
    }
}
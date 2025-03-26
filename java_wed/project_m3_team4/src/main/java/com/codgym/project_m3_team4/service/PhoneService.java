package com.codgym.project_m3_team4.service;

import com.codgym.project_m3_team4.model.Phone;
import com.codgym.project_m3_team4.repository.IDienThoaiRepository;
import com.codgym.project_m3_team4.repository.PhoneRepository;

import java.util.List;

public class PhoneService implements IDienThoaiService {
    private IDienThoaiRepository phoneRepository = new PhoneRepository();


    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.getAllPhones();
    }

    @Override
    public void deletePhone(int id) {
        phoneRepository.deletePhone(id);
    }

    @Override
    public Phone getPhoneById(int id) {
        return null;
    }

    @Override
    public void updatePhone(Phone phone) {
        phoneRepository.updatePhone(phone);
    }
}
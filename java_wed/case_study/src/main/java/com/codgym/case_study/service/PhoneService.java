package com.codgym.case_study.service;

import com.codgym.case_study.model.Phone;
import com.codgym.case_study.repository.IPhoneRepository;
import com.codgym.case_study.repository.PhoneRepository;
import java.util.List;

public class PhoneService implements IPhoneService {
    private final IPhoneRepository phoneRepository = new PhoneRepository();

    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.getAllPhones();
    }

    @Override
    public Phone getPhoneById(int id) {
        return phoneRepository.getPhoneById(id);
    }

    @Override
    public void deletePhoneById(int id) {
        phoneRepository.deletePhoneById(id);
    }

    @Override
    public List<Phone> searchPhones(String keyword) {
        return phoneRepository.searchPhones(keyword);
    }

    @Override
    public void addPhone(Phone phone) {
        phoneRepository.addPhone(phone);
    }

    @Override
    public void updatePhoneStatus(int id, String newStatus) {
        phoneRepository.updatePhoneStatus(id, newStatus);
    }
}

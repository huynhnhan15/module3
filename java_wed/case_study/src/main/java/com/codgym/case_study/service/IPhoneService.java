package com.codgym.case_study.service;

import com.codgym.case_study.model.Phone;
import java.util.List;

public interface IPhoneService {
    List<Phone> getAllPhones();
    Phone getPhoneById(int id);
    void deletePhoneById(int id);
    List<Phone> searchPhones(String keyword);
    void addPhone(Phone phone);

    void updatePhoneStatus(int id, String newStatus);
}

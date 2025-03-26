package com.codgym.project_m3_team4.service;


import com.codgym.project_m3_team4.model.Phone;

import java.util.List;

public interface IDienThoaiService {
    List<Phone> getAllPhones();
    void deletePhone(int id);

    Phone getPhoneById(int id);

    void updatePhone(Phone phone);
}
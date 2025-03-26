package com.codgym.project_m3_team4.repository;


import com.codgym.project_m3_team4.model.Phone;

import java.util.List;

public interface IDienThoaiRepository {
    List<Phone> getAllPhones();
    void deletePhone(int id);

    void updatePhone(Phone phone);
}
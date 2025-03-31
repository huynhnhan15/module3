package com.codgym.case_study.repository;

import com.codgym.case_study.model.Phone;
import java.util.List;

public interface IPhoneRepository {
    List<Phone> getAllPhones();
    Phone getPhoneById(int id);
    void deletePhoneById(int id);
    List<Phone> searchPhones(String keyword);
    void addPhone(Phone phone); // Thêm phương thức thêm sản phẩm

    void updatePhoneStatus(int id, String newStatus);
}

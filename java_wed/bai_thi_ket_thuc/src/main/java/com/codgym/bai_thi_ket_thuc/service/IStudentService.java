package com.codgym.bai_thi_ket_thuc.service;

import com.codgym.bai_thi_ket_thuc.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    List<Student> findAll() throws SQLException;
    Student findById(String id) throws SQLException;
    void save(Student student) throws SQLException;
    void update(Student student) throws SQLException;
    void delete(String id) throws SQLException;
}
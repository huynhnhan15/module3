package com.codgym.bai_thi_ket_thuc.repository;

import com.codgym.bai_thi_ket_thuc.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll() throws SQLException;
    Student findById(String id) throws SQLException;
    void save(Student student) throws SQLException;
    void update(Student student) throws SQLException;
    void delete(String id) throws SQLException;
}
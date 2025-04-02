package com.codgym.bai_thi_ket_thuc.service;

import com.codgym.bai_thi_ket_thuc.model.Student;
import com.codgym.bai_thi_ket_thuc.repository.IStudentRepository;
import com.codgym.bai_thi_ket_thuc.repository.StudentRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() throws SQLException {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) throws SQLException {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) throws SQLException {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) throws SQLException {
        studentRepository.update(student);
    }

    @Override
    public void delete(String id) throws SQLException {
        studentRepository.delete(id);
    }
}
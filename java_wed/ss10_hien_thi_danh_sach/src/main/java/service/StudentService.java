package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    // xử lý nghiệp vụ:
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        // gọi repository ( lấy dữ liệu)
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        studentRepository.add(student);
        return true;
    }
}
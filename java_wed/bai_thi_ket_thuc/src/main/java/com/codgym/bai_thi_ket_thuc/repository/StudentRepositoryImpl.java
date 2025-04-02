package com.codgym.bai_thi_ket_thuc.repository;

import com.codgym.bai_thi_ket_thuc.model.Student;
import com.codgym.bai_thi_ket_thuc.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM student";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE student_id = ?";
    private static final String INSERT_STUDENT = "INSERT INTO student VALUES (?, ?, ?)";
    private static final String UPDATE_STUDENT = "UPDATE student SET full_name = ?, class = ? WHERE student_id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE student_id = ?";

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String fullName = rs.getString("full_name");
                String className = rs.getString("class");
                students.add(new Student(studentId, fullName, className));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return students;
    }

    @Override
    public Student findById(String id) throws SQLException {
        Student student = null;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("full_name");
                String className = rs.getString("class");
                student = new Student(id, fullName, className);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return student;
    }

    @Override
    public void save(Student student) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setString(1, student.getStudentId());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setString(3, student.getClassName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
    }

    @Override
    public void update(Student student) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getClassName());
            preparedStatement.setString(3, student.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
    }

    @Override
    public void delete(String id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
    }
}
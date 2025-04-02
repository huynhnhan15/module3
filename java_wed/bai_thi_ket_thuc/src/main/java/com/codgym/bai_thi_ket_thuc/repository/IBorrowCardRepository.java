package com.codgym.bai_thi_ket_thuc.repository;

import com.codgym.bai_thi_ket_thuc.model.BorrowCard;

import java.sql.SQLException;
import java.util.List;

public interface IBorrowCardRepository {
    List<BorrowCard> findAll() throws SQLException;
    BorrowCard findById(String id) throws SQLException;
    boolean save(BorrowCard borrowCard) throws SQLException;
    void update(BorrowCard borrowCard) throws SQLException;
    void delete(String id) throws SQLException;
    List<BorrowCard> findByStudentId(String studentId) throws SQLException;
    String generateBorrowId() throws SQLException;
}
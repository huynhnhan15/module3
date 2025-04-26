
package com.codgym.bai_thi_ket_thuc.service;

import com.codgym.bai_thi_ket_thuc.model.BorrowCard;

import java.sql.SQLException;
import java.util.List;

public interface IBorrowCardService {
    List<BorrowCard> findAll() throws SQLException;
    BorrowCard findById(String id) throws SQLException;
    boolean save(BorrowCard borrowCard) throws SQLException;
    void update(BorrowCard borrowCard);
    void delete(String id);
    List<BorrowCard> findByStudentId(String studentId);
    String generateBorrowId();
}

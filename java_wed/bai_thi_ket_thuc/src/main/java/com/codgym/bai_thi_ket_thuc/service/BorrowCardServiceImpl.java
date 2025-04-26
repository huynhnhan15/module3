
package com.codgym.bai_thi_ket_thuc.service;

import com.codgym.bai_thi_ket_thuc.model.BorrowCard;
import com.codgym.bai_thi_ket_thuc.repository.BorrowCardRepositoryImpl;
import com.codgym.bai_thi_ket_thuc.repository.IBorrowCardRepository;

import java.sql.SQLException;
import java.util.List;

public class BorrowCardServiceImpl implements IBorrowCardService {
    private IBorrowCardRepository borrowCardRepository = new BorrowCardRepositoryImpl();

    @Override
    public List<BorrowCard> findAll() throws SQLException {
        return borrowCardRepository.findAll();
    }

    @Override
    public BorrowCard findById(String id) throws SQLException {
        return borrowCardRepository.findById(id);
    }

    @Override
    public boolean save(BorrowCard borrowCard) throws SQLException {
        return borrowCardRepository.save(borrowCard);
    }

    @Override
    public void update(BorrowCard borrowCard) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<BorrowCard> findByStudentId(String studentId) {
        return List.of();
    }

    @Override
    public String generateBorrowId() {
        return "";
    }
}

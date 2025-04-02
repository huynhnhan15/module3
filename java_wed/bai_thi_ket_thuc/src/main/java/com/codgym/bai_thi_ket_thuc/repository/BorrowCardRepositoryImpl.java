package com.codgym.bai_thi_ket_thuc.repository;

import com.codgym.bai_thi_ket_thuc.model.BorrowCard;
import com.codgym.bai_thi_ket_thuc.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BorrowCardRepositoryImpl implements IBorrowCardRepository {
    private static final String SELECT_ALL_BORROW_CARDS = "SELECT * FROM borrow_card";
    private static final String SELECT_BORROW_CARD_BY_ID = "SELECT * FROM borrow_card WHERE borrow_id = ?";
    private static final String INSERT_BORROW_CARD = "INSERT INTO borrow_card VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_BORROW_CARD = "UPDATE borrow_card SET book_id = ?, student_id = ?, status = ?, borrow_date = ?, return_date = ? WHERE borrow_id = ?";
    private static final String DELETE_BORROW_CARD = "DELETE FROM borrow_card WHERE borrow_id = ?";
    private static final String SELECT_BORROW_CARDS_BY_STUDENT_ID = "SELECT * FROM borrow_card WHERE student_id = ?";
    private static final String CHECK_BORROW_ID_EXISTS = "SELECT COUNT(*) FROM borrow_card WHERE borrow_id = ?";

    @Override
    public List<BorrowCard> findAll() throws SQLException {
        List<BorrowCard> borrowCards = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BORROW_CARDS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                borrowCards.add(extractBorrowCardFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return borrowCards;
    }

    @Override
    public BorrowCard findById(String id) throws SQLException {
        BorrowCard borrowCard = null;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BORROW_CARD_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                borrowCard = extractBorrowCardFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return borrowCard;
    }

    @Override
    public boolean save(BorrowCard borrowCard) throws SQLException {
        Connection connection = DBConnection.getConnection();
        boolean success = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BORROW_CARD);
            preparedStatement.setString(1, borrowCard.getBorrowId());
            preparedStatement.setString(2, borrowCard.getBookId());
            preparedStatement.setString(3, borrowCard.getStudentId());
            preparedStatement.setBoolean(4, borrowCard.isStatus());
            preparedStatement.setDate(5, Date.valueOf(borrowCard.getBorrowDate()));
            preparedStatement.setDate(6, Date.valueOf(borrowCard.getReturnDate()));

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return success;
    }

    @Override
    public void update(BorrowCard borrowCard) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BORROW_CARD);
            preparedStatement.setString(1, borrowCard.getBookId());
            preparedStatement.setString(2, borrowCard.getStudentId());
            preparedStatement.setBoolean(3, borrowCard.isStatus());
            preparedStatement.setDate(4, Date.valueOf(borrowCard.getBorrowDate()));
            preparedStatement.setDate(5, Date.valueOf(borrowCard.getReturnDate()));
            preparedStatement.setString(6, borrowCard.getBorrowId());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BORROW_CARD);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
    }

    @Override
    public List<BorrowCard> findByStudentId(String studentId) throws SQLException {
        List<BorrowCard> borrowCards = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BORROW_CARDS_BY_STUDENT_ID);
            preparedStatement.setString(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                borrowCards.add(extractBorrowCardFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return borrowCards;
    }

    @Override
    public String generateBorrowId() throws SQLException {
        Random random = new Random();
        String borrowId;
        boolean exists;

        do {
            // Generate random 4-digit number
            int randomNum = 1000 + random.nextInt(9000);
            borrowId = "MS-" + randomNum;

            // Check if ID already exists
            exists = checkBorrowIdExists(borrowId);
        } while (exists);

        return borrowId;
    }

    private boolean checkBorrowIdExists(String borrowId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        boolean exists = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BORROW_ID_EXISTS);
            preparedStatement.setString(1, borrowId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }

        return exists;
    }

    private BorrowCard extractBorrowCardFromResultSet(ResultSet rs) throws SQLException {
        String borrowId = rs.getString("borrow_id");
        String bookId = rs.getString("book_id");
        String studentId = rs.getString("student_id");
        boolean status = rs.getBoolean("status");
        Date borrowDate = rs.getDate("borrow_date");
        Date returnDate = rs.getDate("return_date");

        BorrowCard borrowCard = new BorrowCard();
        borrowCard.setBorrowId(borrowId);
        borrowCard.setBookId(bookId);
        borrowCard.setStudentId(studentId);
        borrowCard.setStatus(status);
        borrowCard.setBorrowDate(borrowDate.toLocalDate());
        borrowCard.setReturnDate(returnDate.toLocalDate());

        return borrowCard;
    }
}
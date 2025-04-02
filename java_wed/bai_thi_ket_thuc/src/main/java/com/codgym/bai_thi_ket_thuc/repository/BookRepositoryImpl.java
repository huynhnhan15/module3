package com.codgym.bai_thi_ket_thuc.repository;

import com.codgym.bai_thi_ket_thuc.model.Book;
import com.codgym.bai_thi_ket_thuc.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM book";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM book WHERE book_id = ?";
    private static final String INSERT_BOOK = "INSERT INTO book VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_BOOK = "UPDATE book SET title = ?, author = ?, description = ?, quantity = ? WHERE book_id = ?";
    private static final String DELETE_BOOK = "DELETE FROM book WHERE book_id = ?";
    private static final String UPDATE_BOOK_QUANTITY = "UPDATE book SET quantity = quantity - 1 WHERE book_id = ? AND quantity > 0";

    @Override
    public List<Book> findAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                books.add(new Book(bookId, title, author, description, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return books;
    }

    @Override
    public Book findById(String id) throws SQLException {
        Book book = null;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                book = new Book(id, title, author, description, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return book;
    }

    @Override
    public void save(Book book) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK);
            preparedStatement.setString(1, book.getBookId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getDescription());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
    }

    @Override
    public void update(Book book) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getDescription());
            preparedStatement.setInt(4, book.getQuantity());
            preparedStatement.setString(5, book.getBookId());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
    }

    @Override
    public boolean decreaseQuantity(String bookId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        boolean success = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_QUANTITY);
            preparedStatement.setString(1, bookId);
            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
        return success;
    }
}
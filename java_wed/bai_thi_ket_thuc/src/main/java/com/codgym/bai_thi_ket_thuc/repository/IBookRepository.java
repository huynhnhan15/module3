package com.codgym.bai_thi_ket_thuc.repository;

import com.codgym.bai_thi_ket_thuc.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface    IBookRepository {
    List<Book> findAll() throws SQLException;
    Book findById(String id) throws SQLException;
    void save(Book book) throws SQLException;
    void update(Book book) throws SQLException;
    void delete(String id) throws SQLException;
    boolean decreaseQuantity(String bookId) throws SQLException;
}

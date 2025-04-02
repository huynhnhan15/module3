package com.codgym.bai_thi_ket_thuc.service;

import com.codgym.bai_thi_ket_thuc.model.Book;
import com.codgym.bai_thi_ket_thuc.repository.IBookRepository;
import com.codgym.bai_thi_ket_thuc.repository.BookRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> findAll() throws SQLException {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) throws SQLException {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) throws SQLException {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) throws SQLException {
        bookRepository.update(book);
    }

    @Override
    public void delete(String id) throws SQLException {
        bookRepository.delete(id);
    }

    @Override
    public boolean decreaseQuantity(String bookId) throws SQLException {
        return bookRepository.decreaseQuantity(bookId);
    }
}
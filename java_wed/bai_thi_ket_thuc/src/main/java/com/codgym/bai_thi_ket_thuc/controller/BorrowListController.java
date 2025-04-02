package com.codgym.bai_thi_ket_thuc.controller;

import com.codgym.bai_thi_ket_thuc.model.Book;
import com.codgym.bai_thi_ket_thuc.model.BorrowCard;
import com.codgym.bai_thi_ket_thuc.model.Student;
import com.codgym.bai_thi_ket_thuc.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BorrowListController", urlPatterns = {"/borrow-list"})
public class BorrowListController extends HttpServlet {
    private IBorrowCardService borrowCardService = new BorrowCardServiceImpl();
    private IBookService bookService = new BookServiceImpl();
    private IStudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<BorrowCard> borrowCards = null;
        try {
            borrowCards = borrowCardService.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<BorrowCard> enrichedBorrowCards = new ArrayList<>();

        for (BorrowCard card : borrowCards) {
            Book book = null;
            try {
                book = bookService.findById(card.getBookId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Student student = null;
            try {
                student = studentService.findById(card.getStudentId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            card.setBook(book);
            card.setStudent(student);

            enrichedBorrowCards.add(card);
        }

        request.setAttribute("borrowCards", enrichedBorrowCards);
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow-list.jsp");
        dispatcher.forward(request, response);
    }
}
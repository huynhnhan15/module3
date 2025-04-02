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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "BorrowController", urlPatterns = {"/borrow"})
public class BorrowController extends HttpServlet {
    private IBookService bookService = new BookServiceImpl();
    private IStudentService studentService = new StudentServiceImpl();
    private IBorrowCardService borrowCardService = new BorrowCardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                try {
                    showBorrowForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                response.sendRedirect("books");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                try {
                    createBorrowCard(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                response.sendRedirect("books");
                break;
        }
    }

    private void showBorrowForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String bookId = request.getParameter("bookId");
        Book book = bookService.findById(bookId);

        if (book == null || book.getQuantity() <= 0) {
            request.setAttribute("errorMessage", "Sách không có sẵn để mượn!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        List<Student> students = studentService.findAll();
        String borrowId = borrowCardService.generateBorrowId();
        LocalDate borrowDate = LocalDate.now();

        // Format the borrowDate as a String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedBorrowDate = borrowDate.format(formatter);

        request.setAttribute("book", book);
        request.setAttribute("students", students);
        request.setAttribute("borrowId", borrowId);
        request.setAttribute("borrowDate", formattedBorrowDate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createBorrowCard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // Get parameters from form
        String borrowId = request.getParameter("borrowId");
        String bookId = request.getParameter("bookId");
        String studentId = request.getParameter("studentId");
        String returnDateStr = request.getParameter("returnDate");

        Book book = bookService.findById(bookId);

        if (book == null || book.getQuantity() <= 0) {
            request.setAttribute("errorMessage", "Sách không có sẵn để mượn!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Validate borrowId format (MS-XXXX)
        if (!borrowId.matches("MS-\\d{4}")) {
            request.setAttribute("errorMessage", "Mã mượn sách phải có định dạng MS-XXXX!");
            showBorrowForm(request, response);
            return;
        }

        // Parse dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate borrowDate = LocalDate.now();
        LocalDate returnDate = LocalDate.parse(returnDateStr, formatter);

        // Validate return date is after borrow date
        if (returnDate.isBefore(borrowDate)) {
            request.setAttribute("errorMessage", "Ngày trả sách phải sau ngày mượn sách!");
            showBorrowForm(request, response);
            return;
        }

        // Create borrow card
        BorrowCard borrowCard = new BorrowCard();
        borrowCard.setBorrowId(borrowId);
        borrowCard.setBookId(bookId);
        borrowCard.setStudentId(studentId);
        borrowCard.setStatus(true); // borrowing
        borrowCard.setBorrowDate(borrowDate);
        borrowCard.setReturnDate(returnDate);

        // Save borrow card and decrease book quantity
        boolean saveSuccess = borrowCardService.save(borrowCard);

        if (saveSuccess) {
            bookService.decreaseQuantity(bookId);
            response.sendRedirect("books");
        } else {
            request.setAttribute("errorMessage", "Có lỗi xảy ra khi mượn sách!");
            showBorrowForm(request, response);
        }
    }
}

package com.example.library.controller;

import com.example.library.repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "bookDeleteOkServlet", value = "/book-delete-ok")
public class BookDeleteOkServlet extends HttpServlet {

    BookRepository bookRepository = new BookRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            bookRepository.deleteBook(Long.parseLong(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        HttpServletResponse response = (HttpServletResponse) resp;
        response.sendRedirect("/checkBookList?mode=1&sort=null&searchInput=null");

    }
}

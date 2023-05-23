package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "bookUpdateOkServlet", value = "/book-update-ok")
public class BookUpdateOkServlet extends HttpServlet {

    BookRepository bookRepository = new BookRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String author= req.getParameter("author");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");
        String genre = req.getParameter("genre");
        String publisher = req.getParameter("publisher");

        Book updateBook = new Book(name, author, Integer.parseInt(price), Integer.parseInt(amount), genre, publisher);

        try {
            bookRepository.updateBook(Long.parseLong(id), updateBook);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        HttpServletResponse response = (HttpServletResponse) resp;
        response.sendRedirect("/"); // 리다이렉트할 경로를 적절히 수정해주세요
    }
}

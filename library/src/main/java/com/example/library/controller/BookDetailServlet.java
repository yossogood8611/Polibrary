package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "bookDetailServlet", value = "/book-detail")
public class BookDetailServlet extends HttpServlet {

    BookRepository bookRepository = new BookRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Book findBook = null;
        try {
            findBook = bookRepository.selectById(Long.parseLong(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 책 정보를 테이블로 출력
        out.println("<html>");
        out.println("<head>");
        out.println("<title>책 정보</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr><td>책 이름:</td><td>" + findBook.getName() + "</td></tr>");
        out.println("<tr><td>작가:</td><td>" + findBook.getAuthor() + "</td></tr>");
        out.println("<tr><td>가격:</td><td>" + findBook.getPrice() + "</td></tr>");
        out.println("<tr><td>수량:</td><td>" + findBook.getAmount() + "</td></tr>");
        out.println("<tr><td>장르:</td><td>" + findBook.getGenre() + "</td></tr>");
        out.println("<tr><td>출판사:</td><td>" + findBook.getPublisher() + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }
}

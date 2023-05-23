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

        out.println("<html>");
        out.println("<head>");
        out.println("<title>책 정보</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>책 정보</h1>");
        out.println("<form action=/book-update-ok method=post>");
        out.println("<label for=id>책 id:</label>");
        out.println("<input type=text id=id name=id value=" + findBook.getId() + "><br><br>");
        out.println("<label for=name>책 이름:</label>");
        out.println("<input type=text id=name name=name value=" + findBook.getName() + "><br><br>");
        out.println("<label for=author>작가:</label>");
        out.println("<input type=text id=author name=author value=" + findBook.getAuthor() + "><br><br>");
        out.println("<label for=price>가격:</label>");
        out.println("<input type=text id=price name=price value=" + findBook.getPrice() + "><br><br>");
        out.println("<label for=amount>수량:</label>");
        out.println("<input type=text id=amount name=amount value=" + findBook.getAmount() + "><br><br>");
        out.println("<label for=genre>장르:</label>");
        out.println("<input type=text id=genre name=genre value=" + findBook.getGenre() + "><br><br>");
        out.println("<label for=publisher>출판사:</label>");
        out.println("<input type=text id=publisher name=publisher value=" + findBook.getPublisher() + "><br><br>");
        out.println("<button type=submit>업데이트</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }
}

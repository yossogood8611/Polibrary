package com.example.library;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }





    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        BookRepository bookRepository = new BookRepository();

        Book book = new Book("책3", "저자3", 3000, 3, "장르3", "출판사3");
        try {
            bookRepository.saveBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
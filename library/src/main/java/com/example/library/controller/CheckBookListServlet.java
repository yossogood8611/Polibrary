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
import java.util.ArrayList;

@WebServlet("/checkBookList")
public class CheckBookListServlet extends HttpServlet {

    BookRepository bookRepository = new BookRepository();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String mode = request.getParameter("mode");
        String name = request.getParameter("search1");
        String author = request.getParameter("search2");
        String order = request.getParameter("order");

        ArrayList<Book> bookList = null;
        try {
            if (name != null && !name.equals("") && author != null && !author.equals("")) {
                bookList = bookRepository.selectByBookNameAndAuthor(name, author);
            } else if (name != null && !name.equals("")) {
                bookList = bookRepository.selectByBookName(name);
            } else if (author != null && !author.equals("")) {
                bookList = bookRepository.selectByAuthor(author);
            } else {
                //bookList = bookRepository.selectList(null); // Book 목록 가져오기
                if ("asc".equalsIgnoreCase(order)) {
                    bookList = bookRepository.selectList("ASC"); // Book 목록 가져오기 (오름차순)
                } else if ("desc".equalsIgnoreCase(order)) {
                    bookList = bookRepository.selectList("DESC"); // Book 목록 가져오기 (내림차순)
                } else {
                    bookList = bookRepository.selectList(null); // Book 목록 가져오기 (기본 정렬)
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Book 데이터를 테이블로 출력하는 HTML 코드 작성
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book List</title>");
        out.println("<style>");
        out.println("table {");
        out.println("  width: 100%;");
        out.println("  border-collapse: collapse;");
        out.println("}");

        out.println("th, td {");
        out.println("  padding: 10px;");
        out.println("  text-align: left;");
        out.println("  border-bottom: 1px solid #ddd;");
        out.println("}");

        out.println("th {");
        out.println("  background-color: #f2f2f2;");
        out.println("}");

        out.println("a {");
        out.println("    text-decoration: none;");
        out.println("    color: inherit;");
        out.println("}");
        out.println("a:hover {");
        out.println("    color: inherit;");
        out.println("}");


        out.println("</style>");
        out.println("</head>");
        out.println("<script>");
        out.println("function toggleMenu() {");
        out.println("  var menuButton = document.querySelector('.menu-button');");
        out.println("  var sidebar = document.querySelector('.sidebar');");
        out.println("  menuButton.classList.toggle('open');");
        out.println("  sidebar.classList.toggle('open');");
        out.println("}");
        out.println("</script>");

        out.println("<body>");

        // 헤더 포함
        request.getRequestDispatcher("header.jsp").include(request, response);
        // 사이드바 포함
        if ("1".equals(mode)) {
            request.getRequestDispatcher("managerSideBar.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("userSideBar.jsp").include(request, response);
        }


        out.println("<h1>도서 리스트</h1>");
        out.println("<div class='row'>");
        out.println("<div>");

        out.println("<form action=checkBookList method=GET>");
        out.println("<input type=hidden name=mode value=1>");
        out.println("<input type=text name=search1 placeholder='책 이름'>");
        out.println("<input type=text name=search2 placeholder=저자>");
        out.println("<input type=submit value=검색>");
        out.println("</form>");
        out.println("</div>");

        out.println("<div>");
        out.println("  <a href='/checkBookList?mode=1&search1=&search2=&order=asc'><button type='button'>오름차순</button></a>");
        out.println("  <a href='/checkBookList?mode=1&search1=&search2=&order=desc'><button type='button'>내림차순</button></a>");
        out.println("</div>");

        out.println("</div>");






        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>제목</th>");
        out.println("<th>저자</th>");
        out.println("<th>가격</th>");
        out.println("<th>수량</th>");
        out.println("<th>장르</th>");
        out.println("<th>출판사</th>");
        out.println("</tr>");

        for (Book book : bookList) {
            out.println("<tr>");
            out.println("<td><a href=book-detail?id=" + book.getId() + ">" + book.getId() + "</a></td>");
            out.println("<td>" + book.getName() + "</td>");
            out.println("<td>" + book.getAuthor() + "</td>");
            out.println("<td>" + book.getPrice() + "</td>");
            out.println("<td>" + book.getAmount() + "</td>");
            out.println("<td>" + book.getGenre() + "</td>");
            out.println("<td>" + book.getPublisher() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}

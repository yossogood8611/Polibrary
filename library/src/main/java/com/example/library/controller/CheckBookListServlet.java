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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String mode = request.getParameter("mode");
        String searchInput = request.getParameter("searchInput");
        String sortMode = request.getParameter("sort");
        String searchMode = request.getParameter("searchMode");

        String contextPath = request.getContextPath();
        String searchBookNameURL = contextPath + "/checkBookList?mode=" + mode + "&sort=null&searchInput="+ searchInput + "&searchMode=" + searchMode ;
        String searchAuthorURL = contextPath + "/checkBookList?mode=" + mode + "&sort=null&searchInput="+ searchInput + "&searchMode=" + searchMode;
        String ascendingURL = contextPath + "/checkBookList?mode=" + mode + "&sort=ASC&searchInput=" + searchInput + "&searchMode=" + searchMode;
        String descendingURL = contextPath + "/checkBookList?mode=" + mode + "&sort=DESC&searchInput=" + searchInput + "&searchMode=" + searchMode;

        System.out.println(mode + " " + searchInput + " " + sortMode +" "+ searchMode);
        // 데이터 가져오기
        BookRepository bookRepository = new BookRepository();
        try {
            ArrayList<Book> bookList = bookRepository.selectList(sortMode);

            if (searchInput != null && !searchInput.isEmpty()) {
                if("1".equals(searchMode))
                bookList = bookRepository.selectByBookName(searchInput);
            } else if("2".equals(searchMode)){
                bookList = bookRepository.selectByAuthor(searchInput);
            }else{
                bookList = bookRepository.selectList(sortMode);
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

            out.println(".row {");
            out.println("  display: flex;");
            out.println("  flex-direction : row;");
            out.println("  justify-content: space-between;");
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
            out.println("function setSearchInput() {");
            out.println("  var searchInput = document.getElementById('searchInput').value;");
            out.println("  var searchInputParam = encodeURIComponent(searchInput);");
            out.println("");
            out.println("  this.searchInput = searchInputParam;");
            out.println("}");
            out.println("function setSearchMode(mode) {");
            out.println("  this.searchMode = mode;");
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

            out.println("<h1>Book List</h1>");
            out.println("<div class=\"row\">");
            out.println("<div>");
            out.println("<form>");
            out.println("<input type=\"text\" name=\"searchInput\" id=\"searchInput\" placeholder=\"검색어 입력\">");
            out.println("  <a href=\"" + searchBookNameURL + "\"><button onClick=\"setSearchMode(1); setSearchInput();\" type=\"submit\">제목으로 검색하기</button></a>");
            out.println("  <a href=\"" + searchAuthorURL + "\"><button onClick=\"setSearchMode(2); setSearchInput();\" type=\"submit\">저자로 검색하기</button></a>");
            out.println("</form>");
            out.println("</div>");

            out.println("<div>");
            out.println("  <a href=\"" + ascendingURL + "\"><button onClick=\"setSearchMode(0)\" type=\"button\">오름차순</button></a>");
            out.println("  <a href=\"" + descendingURL + "\"><button onClick=\"setSearchMode(0)\" type=\"button\">내림차순</button></a>");
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
                out.println("<td>" + book.getId() + "</td>");
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

        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }

        out.close();
    }
}

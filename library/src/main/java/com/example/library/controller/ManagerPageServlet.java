package com.example.library.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager-page")
public class ManagerPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HTML 페이지 생성
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Main Page</title>");
        out.println("<style>");
        out.println(".header {");
        out.println("  display: flex;");
        out.println("  align-items: center;");
        out.println("  padding: 10px;");
        out.println("  border-bottom: 1.2px solid gray;");
        out.println("}");

        out.println(".logo {");
        out.println("  font-weight: bold;");
        out.println("  font-size: 24px;");
        out.println("  margin-left: 10px;");
        out.println("}");

        out.println(".menu-button {");
        out.println("  margin-left: auto;");
        out.println("  cursor: pointer;");
        out.println("}");

        out.println(".menu-button-item {");
        out.println("  display: block;");
        out.println("  width: 20px;");
        out.println("  height: 4px;");
        out.println("  margin-bottom: 3px;");
        out.println("  background-color: #333;");
        out.println("  transition: transform 0.3s, opacity 0.3s;");
        out.println("}");

        out.println(".menu-button.open .menu-button-item:nth-child(1) {");
        out.println("  transform: rotate(45deg) translate(3px, 6px);");
        out.println("}");

        out.println(".menu-button.open .menu-button-item:nth-child(2) {");
        out.println("  opacity: 0;");
        out.println("}");

        out.println(".menu-button.open .menu-button-item:nth-child(3) {");
        out.println("  transform: rotate(-45deg) translate(4px, -6px);");
        out.println("}");

        out.println(".sidebar {");
        out.println("  position: fixed;");
        out.println("  top: 58px;");
        out.println("  right: -200px;");
        out.println("  width: 200px;");
        out.println("  height: 100vh;");
        out.println("  background-color: #f1f1f1;");
        out.println("  transition: right 0.3s;");
        out.println("}");

        out.println(".sidebar.open {");
        out.println("  right: 0;");
        out.println("}");

        out.println(".sidebar ul {");
        out.println("  padding: 0;");
        out.println("  margin: 20px;");
        out.println("}");

        out.println(".sidebar li {");
        out.println("  list-style-type: none;");
        out.println("  margin-bottom: 10px;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"header\">");
        out.println("<div class=\"logo\">Polibrary</div>");
        out.println("<div class=\"menu-button\" onclick=\"toggleMenu()\">");
        out.println("<div class=\"menu-button-item\"></div>");
        out.println("<div class=\"menu-button-item\"></div>");
        out.println("<div class=\"menu-button-item\"></div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"sidebar\">");
        out.println("<ul>");
        out.println("<li>도서 조회</li>");
        out.println("<li>도서 구매/판매</li>");
        out.println("<li>도서 대여/반납</li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("<h1>Main Page Content</h1>");
        out.println("<script>");
        out.println("function toggleMenu() {");
        out.println("  var menuButton = document.querySelector('.menu-button');");
        out.println("  var sidebar = document.querySelector('.sidebar');");
        out.println("  menuButton.classList.toggle('open');");
        out.println("  sidebar.classList.toggle('open');");
        out.println("}");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}


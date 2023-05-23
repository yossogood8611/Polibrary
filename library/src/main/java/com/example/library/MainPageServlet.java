package com.example.library;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/main-page")
public class MainPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HTML 페이지 생성
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Main Page</title>");
        out.println("<style>");
        out.println(".header {");
        out.println("  display: flex;");
        out.println("  align-items: center;");
        out.println("  padding: 10px;");
        out.println("  background-color: #f1f1f1;");
        out.println("}");

        out.println(".logo {");
        out.println("  font-weight: bold;");
        out.println("  font-size: 24px;");
        out.println("  margin-left: 10px;");
        out.println("}");

        out.println(".menu-button {");
        out.println("  margin-left: auto;");
        out.println("}");

        out.println(".menu-button-item {");
        out.println("  display: block;");
        out.println("  width: 20px;");
        out.println("  height: 4px;");
        out.println("  margin-bottom: 3px;");
        out.println("  background-color: #333;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"header\">");
        out.println("<div class=\"logo\">Polibrary</div>");
        out.println("<div class=\"menu-button\">");
        out.println("<div class=\"menu-button-item\"></div>");
        out.println("<div class=\"menu-button-item\"></div>");
        out.println("<div class=\"menu-button-item\"></div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<h1>Header Page Content</h1>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}

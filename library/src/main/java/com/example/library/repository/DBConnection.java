package com.example.library.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final static DBConnection connection = new DBConnection();

    private DBConnection() {
    }

    //싱글톤
    public static DBConnection getInstance(){
        return connection;
    }

    private final String server = "localhost:3306"; // MySQL 서버 주소
    private final String database = "bookdb"; // MySQL DATABASE 이름
    private final String user_name = "root"; //  MySQL 서버 아이디
    private final String password = "1234"; // MySQL 서버 비밀번호

    Connection con = null;

    public Connection getConnection() {
        // 1.드라이버 로딩
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        // 2.연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
            System.out.println("정상적으로 연결되었습니다.");
            return con;
        } catch(
                SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
            e.printStackTrace();
        }

        // 3.해제
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}

        return null;
    }

}

package com.example.library.repository;

import com.example.library.domain.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    DBConnection dbConnection = DBConnection.getInstance();
    Connection connection = dbConnection.getConnection();

    //책 입고(저장)
    public void saveBook(Book book) throws SQLException {
        String sql =
                "INSERT INTO book (name, author, price, amount, genre, publisher) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = connection.prepareStatement(sql);

        // INSERT 쿼리에 파라미터 설정
        pstmt.setString(1, book.getName());
        pstmt.setString(2,  book.getAuthor());
        pstmt.setInt(3, book.getPrice()); //가격
        pstmt.setInt(4, book.getAmount());//수량
        pstmt.setString(5, book.getGenre());
        pstmt.setString(6, book.getPublisher());

        pstmt.executeUpdate();

        System.out.println("저장 완료");
    }

    //책 단건 조회
    public Book selectById(Long bookId) throws SQLException {
        String sql = "SELECT * FROM book WHERE Id = " + bookId;

        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);

        //SQL 결과 처리
        while(rs.next()) {
            Long id = rs.getLong("Id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            int price = rs.getInt("price");
            int amount = rs.getInt("amount");
            String genre = rs.getString("genre");
            String publisher = rs.getString("publisher");

            return new Book(id, name, author, price, amount, genre, publisher);
        }

        return null;
    }

    //책 전체 조회
    //ASC, DESC, null
    public ArrayList<Book> selectList(String orderBy) throws SQLException {
        String sql = "SELECT * FROM book";

        if (orderBy != null && orderBy.equals("")) {
            sql += " ORDER BY name " + orderBy; // name 필드를 기준으로 정렬
        }

        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);

        ArrayList<Book> list = new ArrayList<>(); //결과데이터를 담을 리스트

        //SQL 결과 처리
        while(rs.next()) {
            Long id = rs.getLong("Id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            int price = rs.getInt("price");
            int amount = rs.getInt("amount");
            String genre = rs.getString("genre");
            String publisher = rs.getString("publisher");

            Book findBook = new Book(id, name, author, price, amount, genre, publisher);

            list.add(findBook);
        }
        return list;
    }

    //책 조건(책제목) 조회
    public ArrayList<Book> selectByBookName(String keyword) throws SQLException {
        String sql = "SELECT * FROM book WHERE name LIKE " + "'%" + keyword + "%'";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);

        ArrayList<Book> list = new ArrayList<>(); //결과데이터를 담을 리스트

        //SQL 결과 처리
        while(rs.next()) {
            Long id = rs.getLong("Id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            int price = rs.getInt("price");
            int amount = rs.getInt("amount");
            String genre = rs.getString("genre");
            String publisher = rs.getString("publisher");

            Book findBook = new Book(id, name, author, price, amount, genre, publisher);

            list.add(findBook);
        }

        return list;
    }

    //책 조건(저자) 조회
    public ArrayList<Book> selectByAuthor(String keyword) throws SQLException {
        String sql = "SELECT * FROM book WHERE author LIKE " + "'%" + keyword + "%'";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);

        ArrayList<Book> list = new ArrayList<>(); //결과데이터를 담을 리스트

        //SQL 결과 처리
        while(rs.next()) {
            Long id = rs.getLong("Id");
            String name = rs.getString("name");
            String author = rs.getString("author");
            int price = rs.getInt("price");
            int amount = rs.getInt("amount");
            String genre = rs.getString("genre");
            String publisher = rs.getString("publisher");

            Book findBook = new Book(id, name, author, price, amount, genre, publisher);

            list.add(findBook);
        }

        return list;
    }


    // 책 제목, 저자 조건으로 조회
    public ArrayList<Book> selectByBookNameAndAuthor(String bookName, String author) throws SQLException {
        String sql = "SELECT * FROM book WHERE ";
        boolean isConditionAdded = false;

        if (bookName != null && !bookName.isEmpty()) {
            sql += "name LIKE '%" + bookName + "%'";
            isConditionAdded = true;
        }

        if (author != null && !author.isEmpty()) {
            if (isConditionAdded) {
                sql += " AND ";
            }
            sql += "author LIKE '%" + author + "%'";
        }

        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<Book> list = new ArrayList<>(); // 결과 데이터를 담을 리스트

        // SQL 결과 처리
        while (rs.next()) {
            Long id = rs.getLong("Id");
            String name = rs.getString("name");
            String bookAuthor = rs.getString("author");
            int price = rs.getInt("price");
            int amount = rs.getInt("amount");
            String genre = rs.getString("genre");
            String publisher = rs.getString("publisher");

            Book findBook = new Book(id, name, bookAuthor, price, amount, genre, publisher);

            list.add(findBook);
        }

        return list;
    }




    //도서 수량+1
    public void plusAmount(Long bookId) throws SQLException {
        String sql = "UPDATE book SET amount = amount+1 WHERE Id = " + bookId;

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    //도서 수량-1
    public void minusAmount(Long bookId) throws SQLException {
        String sql = "UPDATE book SET amount = amount-1 WHERE Id = " + bookId;

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    //도서 정보 업데이트
    public void updateBook(Long bookId, Book book) throws SQLException {
        String sql = "UPDATE book SET ";

        // SET 절 구성
        List<String> setExpressions = new ArrayList<>();

        if (book.getName() != null) {
            setExpressions.add("name = ?");
        }
        if (book.getAuthor() != null) {
            setExpressions.add("author = ?");
        }
        if (book.getPrice() != null) {
            setExpressions.add("price = ?");
        }
        if (book.getAmount() != null) {
            setExpressions.add("amount = ?");
        }
        if (book.getGenre() != null) {
            setExpressions.add("genre = ?");
        }
        if (book.getPublisher() != null) {
            setExpressions.add("publisher = ?");
        }

        sql += String.join(", ", setExpressions);
        sql += " WHERE Id = ?";

        int parameterIndex = 1;

        PreparedStatement pstmt = connection.prepareStatement(sql);
        if (book.getName() != null) {
            pstmt.setString(parameterIndex++, book.getName());
        }
        if (book.getAuthor() != null) {
            pstmt.setString(parameterIndex++, book.getAuthor());
        }
        if (book.getPrice() != null) {
            pstmt.setInt(parameterIndex++, book.getPrice());
        }
        if (book.getAmount() != null) {
            pstmt.setInt(parameterIndex++, book.getAmount());
        }
        if (book.getGenre() != null) {
            pstmt.setString(parameterIndex++, book.getGenre());
        }
        if (book.getPublisher() != null) {
            pstmt.setString(parameterIndex++, book.getPublisher());
        }
        pstmt.setLong(parameterIndex, bookId);


        pstmt.executeUpdate();

        System.out.println("업데이트 완료");
    }

    // 도서 삭제
    public void deleteBook(Long bookId) throws SQLException {
        String sql = "DELETE FROM book WHERE Id = ?";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, bookId);

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("도서 삭제 완료");
        } else {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        }
    }

}

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="sidebar">
    <ul>
        <li><a href="checkBookList">도서 조회</a></li>
        <li>도서 대여/반납</li>
    </ul>
</div>
<style>
    .sidebar {
        position: fixed;
        top: 58px;
        right: -200px;
        width: 200px;
        height: 100vh;
        background-color: #f1f1f1;
        transition: right 0.3s;
    }

    .sidebar.open {
        right: 0;
    }

    .sidebar ul {
        padding: 0;
        margin: 20px;
    }

    .sidebar li {
        list-style-type: none;
        margin-bottom: 10px;
    }

</style>

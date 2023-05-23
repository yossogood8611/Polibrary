<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="sidebar">
    <ul>
        <li><a href="${pageContext.request.contextPath}/checkBookList?mode=1&sort=null&searchInput=null&searchMode=0">도서 조회</a></li>
        <li><a href="insert.html?mode=1">도서 입고</a></li>
        <li><a href="book-update?mode=1">도서 수정</a></li>
        <li><a href="book-delete?mode=1">도서 폐기</a></li>
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

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="header">
    <div class="logo"><a href="/">Polibrary</a></div>
    <div class="menu-button" onclick="toggleMenu()">
        <div class="menu-button-item"></div>
        <div class="menu-button-item"></div>
        <div class="menu-button-item"></div>
    </div>
</div>

<style>
    .header {
    display: flex;
    align-items: center;
    padding: 10px;
    border-bottom: 1.2px solid gray;
    }

    .logo {
    font-weight: bold;
    font-size: 24px;
    margin-left: 10px;
    }

    .menu-button {
    margin-left: auto;
    cursor: pointer;
    }

    .menu-button-item {
    display: block;
    width: 20px;
    height: 4px;
    margin-bottom: 3px;
    background-color: #333;
    transition: transform 0.3s, opacity 0.3s;
    }

    .menu-button.open .menu-button-item:nth-child(1) {
    transform: rotate(45deg) translate(3px, 6px);
    }

    .menu-button.open .menu-button-item:nth-child(2) {
    opacity: 0;
    }

    .menu-button.open .menu-button-item:nth-child(3) {
    transform: rotate(-45deg) translate(4px, -6px);
    }
</style>

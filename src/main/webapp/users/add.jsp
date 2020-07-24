<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>
    <!--Dodaj użytkowników -->
    <div class="d-flex p-2 bd-highlight">Dodaj użytkownika</div>
    <form action="/user/add" method="post">
<%--        <div class="form-group form-control-lg">--%>
<%--        <label>Nazwa użytkownika</label>--%>
<%--        <input type="text" name="imie" placeholder="Wpisz imię i nazwisko">--%>
<%--        <label>Email</label>--%>
<%--        <input type="email" name="mail" placeholder="Podaj maila">--%>
<%--        <label>Hasło</label>--%>
<%--        <input type="text" name="haslo" placeholder="Podaj haslo">--%>
<%--        <button type="submit">Wyślij</button>--%>
<%--        </div>--%>
    <label>Nazwa użytkownika</label>
    <input class="form-control" type="text" name="imie" placeholder="Podaj imię">
    <label>Email</label>
    <input class="form-control" type="text" name = "mail" placeholder="Podaj maila">
    <label>Hasło</label>
    <input class="form-control" type="text" name="haslo" placeholder="Podaj hasło">

        <button type="submit" class="btn-primary">Wyślij</button>
    </form>


    <%@ include file="/footer.jsp" %>

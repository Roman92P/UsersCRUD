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
    <!--Sczegóły użytkownika -->

    <div class="container-fluid">
        <h3>Szczegóły użytkownika</h3>
    </div>
    <div class=" container-fluid">
        <div class="p-2 mb-2 bg-white text-dark">
            <div class="table" >
                <table class="table">

                    <tbody>
                    <tr>
                        <th scope="row">ID</th>
                        <td>${userToShow.id}</td>

                    </tr>
                    <tr>
                        <th scope="row">USER NAME</th>
                        <td>${userToShow.userName}</td>
                    </tr>
                    <tr>
                        <th scope="row">USER EMAIL</th>
                        <td>${userToShow.email}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!--Koniec listy użytkowników-->

    <%@ include file="/footer.jsp" %>

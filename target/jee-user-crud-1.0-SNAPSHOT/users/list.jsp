
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp" %>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
                    <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
                </div>
                <!--Lista użytkowników -->

                <div class="container-fluid">
                    <h3>Lista Użytkowników</h3>
                </div>
                <div class=" container-fluid" >
                    <div class="p-2 mb-2 bg-white text-dark">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">id</th>
                                <th scope="col">Name</th>
                                <th scope="col">email</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach  step="1" varStatus="loopCounter"
                                       items="${listaUser}" var="user">
                                <tr>
                                    <td>
                                        <c:out value="${user.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.userName}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.email}" />
                                    </td>
                                    <td>
                                        <a href="/user/delete?userId=${user.id}">Remove</a>
                                        <a href="/user/edit?userId=${user.id}">Edit</a>
                                        <a href="/user/show?userId=${user.id}">Show</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!--Koniec listy użytkowników-->

<%@ include file="/footer.jsp" %>

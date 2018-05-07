<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>



</head>
<body>
<div class="container">

    <div class="container">
        <div class="header clearfix">
            <nav>
                <ul class="nav nav-pills float-right">

                    <li class="nav-item">
                        <a class="nav-link " href="/user"> Home </a>
                    </li>

                    <c:if test="${user.premium == true}">
                        <li class="nav-item">
                            <a class="nav-link " href="/premium"> Premium </a>
                        </li>
                    </c:if>

                    <c:if test="${user.admin == true}">
                        <li class="nav-item">
                            <a class="nav-link active" href="/admin"> Admin <span class="sr-only">(current)</span> </a>
                        </li>
                    </c:if>

                    <li class="nav-item">
                        <a class="nav-link" href="/log"> Wyloguj </a>
                    </li>

                </ul>
            </nav>
            <h3> Użytkownicy poratlu </h3>
        </div>

    </div>

    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>

    <form action="/admin" method="post" id="userForm" role="form">
        <input type="hidden" id="idUser" name="idUser">
        <input type="hidden" id="action" name="action">

        <table class="table table-striped">
            <thead>
            <tr>
                <td>#</td>
                <td>Name</td>
                <td>Last name</td>
                <td>Nick Name</td>
                <td>Password</td>
                <td>E-mail</td>
                <td>Użytkownik Premium</td>

                <td></td>
            </tr>
            </thead>
            <c:forEach var="user" items="${userList}">

                <tr class="${classSucess}">
                    <td> ${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.premium}</td>

                    <td>


                        <c:if test ="${user.premium == false}">

                            <button  onclick="document.getElementById('action').value = 'true';
                                    document.getElementById('idUser').value = '${user.id}';
                                    document.getElementById('userForm').submit();"
                                     type="button" class="btn btn-secondary btn-sm"  >Ustaw Premium</button>
                        </c:if>

                        <c:if test ="${user.premium == true}">
                        <button  onclick="document.getElementById('action').value = 'false';
                                document.getElementById('idUser').value = '${user.id}';
                                document.getElementById('userForm').submit();"
                                 type="button" class="btn btn-primary btn-sm"  >Usuń premium</button>

                        </c:if>



                    </td>
                </tr>
            </c:forEach>
        </table>


    </form>





</div>




</body>
</html>

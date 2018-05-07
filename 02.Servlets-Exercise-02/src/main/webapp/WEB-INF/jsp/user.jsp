<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 02.04.2018
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

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
<style type="text/css">
    .jumbotron {
        background-image: url('http://backgroundcheckall.com/wp-content/uploads/2017/12/background-hexagon-2.png');
    }
</style>

<body>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills float-right">

                <li class="nav-item">
                    <a class="nav-link active" href="/user"> Home <span class="sr-only">(current)</span></a>
                </li>

                <c:if test="${user.premium == true}">
                    <li class="nav-item">
                        <a class="nav-link " href="/premium"> Premium </a>
                    </li>
                </c:if>

                <c:if test="${user.admin == true}">
                    <li class="nav-item">
                        <a class="nav-link " href="/admin"> Admin </a>
                    </li>
                </c:if>

                <li class="nav-item">
                    <a class="nav-link" href="/log"> Wyloguj </a>
                </li>

            </ul>
        </nav>
        <h3 class="text-muted">${user.name} ${user.surname}</h3>
    </div>

    <div class="jumbotron">
        <h1 class="display-3">Witaj </h1>
        <p class="lead">Strona twojego profilu</p>

    </div>

    <div class="row marketing">

        <div class="col-lg-4">
            <h4>Strona w rozudowie </h4>
            <p>Rozwijamy się dla Ciebie</p>

        </div>

    </div>


</div> <!-- /container -->


</body>


</html>





<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 24.03.2018
  Time: 23:24
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





<body>

<c:if test="${not empty message}">
    <div class="alert alert-success">
            ${message}
    </div>
</c:if>

<div class="d-flex align-items-center flex-column justify-content-center h-100 bg-light text-black" id="header">
    <h1 class="display-4">Dzień dobry.</h1>
    <form action="/login" method="post" id="loginForm" role="form">
        <div class="form-group">
            <input class="form-control form-control-lg" id="email" name="email" placeholder="Email" type="text" required="true">
        </div>

        <div class="form-group">
            <input class="form-control form-control-lg" id="password" name="password" placeholder="Password" type="password" required="true">
        </div>

        <div class="form-group">
            <button class="btn btn-info btn-sm btn-block">Zaloguj</button>
        </div>
    </form>

    <div class="form-group">
        <a href="/form" />
        <button  class="btn btn-info btn-sm btn-block">Rejestracja </button>
    </div>



</div>


</body>
</html>

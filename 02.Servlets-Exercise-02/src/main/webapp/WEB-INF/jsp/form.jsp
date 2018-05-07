<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 24.03.2018
  Time: 21:26
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

<body class="bg-light">

<div class="container">
    <div class="py-5 text-center">

        <h2>Rejestracja Nowego Użytkownika</h2>

    </div>

    <c:forEach items="${messages}" var="article">


        <div class="alert alert-danger">
            <strong>Danger!</strong> <c:out value="${article}"/>
        </div>

    </c:forEach>


    <div class="form-group col-xs-4">


        <form class="needs-validation" action="/form" method="post" id="userForm" role="form" novalidate>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="firstName">Imię </label>
                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required="true">
                    <div class="invalid-feedback">
                        Valid first name is required.
                    </div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="lastName">Nazwisko </label>
                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required="true">
                    <div class="invalid-feedback">
                        Valid last name is required.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="username">Nazwa użytkownika</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">@</span>
                    </div>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username" required="true">
                    <div class="invalid-feedback" style="width: 100%;">
                        Your username is required.
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="password_confirm">Hasło</label>
                    <input type="password" class="form-control" id="password_confirm" placeholder="Haslo" required="true">
                </div>

                <div class="col-md-6 mb-3">
                    <label for="password">Hasło-Potwierdź</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Haslo" required="true">
                </div>
            </div>


            <div class="mb-3">
                <label for="email">Adres e-mail </label>
                <input type="email" class="form-control" id="email" name="email" placeholder="you@przyklad.pl" required="true">
                <div class="invalid-feedback">
                    Please enter a valid email address for shipping updates.
                </div>
            </div>


            <br><br>

            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
        </form>
    </div>


</div>


</body>
</html>

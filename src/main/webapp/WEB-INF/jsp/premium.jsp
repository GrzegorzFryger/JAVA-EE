<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 03.04.2018
  Time: 01:05
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

<div class="container">
    <div class="col-lg-12 ">
        <div class="header clearfix">
            <nav>
                <ul class="nav nav-pills float-right">

                    <li class="nav-item">
                        <a class="nav-link " href="/user"> Home </a>
                    </li>


                    <c:if test="${user.premium == true}">
                        <li class="nav-item">
                            <a class="nav-link active " href="/premium"> Premium <span class="sr-only">(current)</span> </a>
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
    </div>

    <br>
    <br>

</div> <!-- /container -->

<div class="container">

    <div class="jumbotron d-flex align-items-center">

        <div class="col-lg-12 ">
            <div class="col-md-auto">


                <iframe width="960" height="447" src="https://www.youtube.com/embed/G1IbRujko-A" frameborder="0"
                        allow="autoplay; encrypted-media" allowfullscreen></iframe>
            </div>

        </div>
    </div>


</div>


</body>


</html>


<%@ page import="model.TypeOfInstallments" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 16.03.2018
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
</head>
<body>



<div class="container">

    <c:forEach items="${messages}" var="article">


        <div class="alert alert-danger">
            <strong>Danger!</strong> <c:out value="${article}"/>
        </div>

    </c:forEach>

    <form action="FormServlet" method="post"  role="form" data-toggle="validator" >


        <h2>Form For Credit</h2>
        <div class="form-group col-xs-4">
            <label for="amountofcredit" class="control-label col-xs-4">Wnioskowana kwota kredytu:</label>
            <input type="text" name="amountofcredit" id="amountofcredit" class="form-control"  required="true"/>

            <label for="numberofinstallment" class="control-label col-xs-4">Ilosc rat:</label>
            <input type="text" name="numberofinstallment" id="numberofinstallment" class="form-control"  required="true"/>

            <label for="interest" class="control-label col-xs-4">Oprocentowanie : </label>
            <input type="text"  name="interest" id="interest" class="form-control"  required="true"/>

            <label for="fixedfree" class="control-label col-xs-4">Oplata stala:</label>
            <input type="text" name="fixedfree" id="fixedfree" class="form-control"  required="true"/>



            <div class="form-group">
                <label for="typeofinstallments"> Wybierz z Rodzaj rat :</label>
                <select class="form-control" id="typeofinstallments" id="typeofinstallments" name="typeofinstallments">

                    <option value="DECREASING">Malejace</option>
                    <option value="FIXED">Stale</option>

                </select>






            <br></br>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>


        </div>
    </form>
</div>


</body>
</html>

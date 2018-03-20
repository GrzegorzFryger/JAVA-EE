<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 20.03.2018
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
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
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Numer Raty</th>
        <th scope="col">Kwota Kapitalu</th>
        <th scope="col">Kwota Odsetek</th>
        <th scope="col">Oplataty stale</th>
        <th scope="col">Calkowita kwota raty</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${schedule}">
    <tr>

        <th scope="row"><c:out value="${item.instalmentNumber}"/></th>
        <td><c:out value="${item.amountCapital}"/></td>
        <td><c:out value="${item.amountInterest}"/></td>
        <td><c:out value="${item.fixedFees}"/></td>
        <td><c:out value="${item.totalAmountInstallmentl}"/></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
    <br> <br>

        <a href="<%= request.getContextPath() + "/download" %>" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Primary link</a>


    <br><br>

</div>
</body>
</html>
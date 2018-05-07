<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 22.04.2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="logic.LoanService" %>
<%@ page import="domain.LoanApplication" %>

<%
    Date date = new Date();

%>



<jsp:useBean id="adress" scope="session" class="domain.Address" ></jsp:useBean>
<jsp:useBean id="loanpaplication" scope="session" class="domain.LoanApplication"></jsp:useBean>
<jsp:useBean id="person" class="domain.Person" scope="session" ></jsp:useBean>
<jsp:useBean id="loanparameters" class="domain.LoanParameters" scope="session"></jsp:useBean>
<jsp:useBean id="number" scope="session" class="logic.LoanNumberGenerator"></jsp:useBean>
<jsp:useBean id="loanservice" scope="application" class="logic.LoanService"></jsp:useBean>


<jsp:setProperty name="adress" property="city" param="city"></jsp:setProperty>
<jsp:setProperty name="adress" property="houseNumber" param="housenumber"></jsp:setProperty>
<jsp:setProperty name="adress" property="localNumber" param="localnumber"></jsp:setProperty>
<jsp:setProperty name="adress" property="street" param="street"></jsp:setProperty>
<jsp:setProperty name="adress" property="zipCode" param="zipcode"></jsp:setProperty>
<jsp:setProperty name="adress" property="phoneNumber" param="phonenumber"></jsp:setProperty>


<jsp:setProperty name="loanpaplication" property="person" value="${person}"></jsp:setProperty>
<jsp:setProperty name="loanpaplication" property="address" value="${adress}"></jsp:setProperty>
<jsp:setProperty name="loanpaplication" property="number" value="${number.numer}"></jsp:setProperty>
<jsp:setProperty name="loanpaplication" property="parameters" value="${loanparameters}"></jsp:setProperty>
<jsp:setProperty name="loanpaplication" property="date" value="<%= date %>"></jsp:setProperty>






<html>



<head>

    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>

<% loanservice.add(loanpaplication); %>


<%
    for(LoanApplication l: loanservice.getAll()){
%>
<li>Wniosek: <%=l.getNumber()
        + "imie " + l.getPerson().getFirstName()
        +" Osoba: " + l.getPerson().getSurname()
        +" Kwota: " + l.getParameters().getAmount()%></li>
<%
    }
%>

<h3><%=loanservice.getAll().size()%></h3>

</body>
</html>

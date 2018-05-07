<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 19.04.2018
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id=" uzytkownik" scope="session"  class="logic.LoanNumberGenerator"></jsp:useBean>
<jsp:useBean id="loanparameters" scope="session" class="domain.LoanParameters"></jsp:useBean>



<html>
<jsp:include page="head.jsp"></jsp:include>
<body>








    <div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">

        <div class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">


            <div class="my-3 py-3">

                <h3>Numer Wniosku : </h3>

                <h2 class="display-5">
                    <jsp:getProperty name=" uzytkownik" property="numer"/>
                </h2>


            </div>

            <div class="my-3 py-3">

        <form action="person.jsp">
            <div class="form-group">
                <label for="amount">Kwota pożyczki</label>
                <input type="text" class="form-control" id="amount" name="amount">
            </div>
            <div class="form-group">
                <label for="installmentCount">Ilość rat</label>
                <input type="text" class="form-control" id="installmentcount" name="installmentcount">
            </div>

            <input type="submit" value="nastepny krok" >
        </form>

            </div>

        </div>

    </div>


    </div>


</body>
</html>

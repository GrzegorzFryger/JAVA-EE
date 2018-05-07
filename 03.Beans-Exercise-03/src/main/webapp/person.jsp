<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 21.04.2018
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="loanparameters" scope="session" class="domain.LoanParameters"></jsp:useBean>

<jsp:setProperty name="loanparameters" property="amount" param="amount"></jsp:setProperty>
<jsp:setProperty name="loanparameters" property="installmentCount" param="installmentcount"></jsp:setProperty>

<html>
<jsp:include page="head.jsp"></jsp:include>
<body>

<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">

        <div class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
            <div class="my-3 py-3">

                <form action="adress.jsp">
                    <div class="form-group">
                        <label for="name">Imie</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>

                    <div class="form-group">
                        <label for="surname">Nazwisko</label>
                        <input type="text" class="form-control" id="surname" name="surname">
                    </div>

                    <div class="form-group">
                        <label for="pesel">Numer Pesel</label>
                        <input type="text" class="form-control" id="pesel" name="pesel">
                    </div>


                    <input type="submit" value="nastepny krok">
                </form>

            </div>

        </div>
    </div>

    </div>


</div>

</body>
</html>

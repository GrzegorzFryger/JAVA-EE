<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 22.04.2018
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="person" class="domain.Person" scope="session"  >


<jsp:setProperty name="person" property="firstName" param="name"></jsp:setProperty>
<jsp:setProperty name="person" property="surname" param="surname"></jsp:setProperty>
<jsp:setProperty name="person" property="pesel" param="pesel"></jsp:setProperty>

</jsp:useBean>

<html>
<jsp:include page="head.jsp"></jsp:include>
<body>

<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">

        <div class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
            <div class="my-3 py-3">

                <form action="loanform.jsp">

                    <div class="form-group">
                        <label for="city">Miasto</label>
                        <input type="text" class="form-control" id="city" name="city">
                    </div>

                    <div class="form-group">
                        <label for="zipcode">Kod pocztwoy</label>
                        <input type="text" class="form-control" id="zipcode" name="zipcode">
                    </div>

                    <div class="form-group">
                        <label for="street">Nazwa Ulicy</label>
                        <input type="text" class="form-control" id="street" name="street">
                    </div>


                    <div class="form-group">
                        <label for="housenumber">Numer Domu</label>
                        <input type="text" class="form-control" id="housenumber" name="housenumber">
                    </div>


                    <div class="form-group">
                        <label for="localnumber">Numer Mieszkania</label>
                        <input type="text" class="form-control" id="localnumber" name="localnumber">
                    </div>


                    <div class="form-group">
                        <label for="phonenumber">Numer Telefonu</label>
                        <input type="text" class="form-control" id="phonenumber" name="phonenumber">
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
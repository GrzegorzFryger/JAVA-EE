<%--
  Created by IntelliJ IDEA.
  User: Grzegorz
  Date: 03.06.2018
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
<head>
    <head>
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,300' rel='stylesheet' type='text/css'>


        <style>
            <%@ include file="WEB-INF/css/weather.css"%>
        </style>

    </head>


<body>



<script>
    var error = "${error}";
    if(error != "")
    {
        alert("${error}");
    }

</script>

<div class="card">
    <span class="city">${weather.cityName}</span>

    <div>
        <img src="http://openweathermap.org/img/w/${weather.condition.icon}.png">
    </div>

    <span class="temp">${weather.temp.averangeTemp}&#176;</span>
    <span>
             <ul class="variations">
                 <li>${weather.condition.main}</li>
                 <li>${weather.cloudiness} %</li>
                 <li><span class="speed">${weather.windSpeed}<span class="kmh"> km/h</span></span></li>
            </ul>

            </span>

    <span class="pressure">${weather.pressure}<span class="mph"> hPs</span></span>



    <form class="menu">

        <input  class="input" type="text" name="city" placeholder=" Wpisz miasto" >

    </form>


</div>






</body>
</html>
</html>

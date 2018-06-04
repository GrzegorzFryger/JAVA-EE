package pjwstk.fryger.boundary;


import javafx.beans.binding.When;
import pjwstk.fryger.client.AbstractClient.Param;
import pjwstk.fryger.client.CurentWeather;
import pjwstk.fryger.entity.Weather;
import pjwstk.fryger.services.JsonWeatherParser;
import pjwstk.fryger.services.WeatherDeserializer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.bind.JsonbConfig;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("weather")
public class WeatherController {


     @Inject
     private Models models;

    @Inject private CurentWeather curentWeather;
    @Inject private JsonWeatherParser parser;
    @Inject private WeatherDeserializer deserializer;


    @PostConstruct
    private void init()
    {
        this.parser.setConfig( new JsonbConfig().withDeserializers(deserializer ));
    }


    @GET
    @Controller
    public String weatherView(@DefaultValue("Gdańsk")@QueryParam("city")  String city) {


        Weather weather =  parser.deserialize(curentWeather.sentResponse(Param.Q,city));

        if(weather != null)
        {
            models.put("weather",weather);


        }
        else
        {
            weather =  parser.deserialize(curentWeather.sentResponse(Param.Q,"Gdańsk"));
            models.put("weather",weather);
            models.put("error", "not found");
        }




        return "/weather.jsp";



    }

}

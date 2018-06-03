package pjwstk.fryger.boundary;


import pjwstk.fryger.client.AbstractClient.Param;
import pjwstk.fryger.client.CurentWeather;
import pjwstk.fryger.entity.Weather;
import pjwstk.fryger.services.JsonWeatherParser;
import pjwstk.fryger.services.WeatherDeserializer;

import javax.inject.Inject;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("ping")
public class WeatherController {


    @Inject CurentWeather curentWeather;

    @Inject JsonWeatherParser parser;

    @Inject WeatherDeserializer deserializer;




    @GET
    public Weather ping() {



        parser.setConfig( new JsonbConfig().withDeserializers(deserializer ));






        return parser.deserialize(curentWeather.sentResponse(Param.ID,"3092472"));
    }

}

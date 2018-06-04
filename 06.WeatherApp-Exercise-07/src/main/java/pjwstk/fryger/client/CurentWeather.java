package pjwstk.fryger.client;

import pjwstk.fryger.entity.Weather;

import javax.ws.rs.client.WebTarget;

public class CurentWeather extends AbstractClient<Weather> {


    public CurentWeather()
    {

        super();

    }

    @Override
    protected WebTarget setPath(WebTarget webTarget1) {

        return webTarget1.path("weather");
    }

    @Override
    protected WebTarget setQueryParm(WebTarget webTarget1, Param param, String valueParam) {



        return webTarget1.queryParam(param.toString(),valueParam)
                .queryParam("units","metric");
    }




}

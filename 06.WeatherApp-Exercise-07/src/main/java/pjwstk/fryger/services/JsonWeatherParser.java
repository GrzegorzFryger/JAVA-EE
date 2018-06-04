package pjwstk.fryger.services;

import pjwstk.fryger.entity.Weather;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.ws.rs.client.WebTarget;

public class JsonWeatherParser
{


    private JsonbConfig config;
    private Jsonb jsonb;


    public JsonWeatherParser()
    {
        this.jsonb = JsonbBuilder.create();
    }

    public JsonWeatherParser(JsonbConfig config) {
        this.config = config;
        this.jsonb = JsonbBuilder.create();
    }



    public JsonbConfig getConfig() {
        return config;
    }

    public void setConfig(JsonbConfig config) {

        this.jsonb = JsonbBuilder.create(config);
        this.config = config;
    }

    public Weather deserialize(String json)
    {
        Weather temp = null;

        try {
            temp = jsonb.fromJson(json,Weather.class);
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        return temp;
    }

    public String serialize(Weather weather)
    {
        return jsonb.toJson(weather);
    }
}

package pjwstk.fryger.services;

import pjwstk.fryger.entity.Coord;
import pjwstk.fryger.entity.Temperature;
import pjwstk.fryger.entity.Weather;
import pjwstk.fryger.entity.Wind;


import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

public class WeatherDeserializer implements JsonbDeserializer<Weather> {


    @Override
    public  Weather deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {

        Weather temp = new Weather();
        Temperature temperature = new Temperature();
        Wind wind = new Wind();


        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();

            if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("coord")) {

                temp.setCoord(ctx.deserialize(Coord.class, parser));

            }
            else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("name") )
            {

                parser.next();
                temp.setName(parser.getString());
            }

            else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("clouds") )
            {

                parser.next();

                while (parser.next() !=JsonParser.Event.END_OBJECT ) {

                    if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("all"))
                    {
                        parser.next();
                        temp.setClouds(parser.getString());
                    }

                }
            }

            else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("wind") )
            {

                parser.next();

                while (parser.next() !=JsonParser.Event.END_OBJECT ) {

                    if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("speed"))
                    {
                        parser.next();
                        wind.setSpeed(Float.valueOf(parser.getString()));
                    }
                     else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("deg"))
                    {
                        parser.next();
                        wind.setWindDirection(Float.valueOf(parser.getString()));
                    }

                }

                temp.setWind(wind);
            }



            else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("main") )
            {
                parser.next();

                while (parser.next() !=JsonParser.Event.END_OBJECT ) {


                    if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("temp")) {
                        parser.next();
                        temperature.setAverangeTemp(Float.valueOf(parser.getString()));
                        temp.setTemp(temperature);

                    }

                    else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("pressure")) {
                        parser.next();

                        temp.setPressure(Integer.valueOf(parser.getString()));

                    }

                    else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("temp_min")) {
                        parser.next();
                        temperature.setMinTemp(Float.valueOf(parser.getString()));
                        temp.setTemp(temperature);

                    }


                    else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("temp_max")) {
                        parser.next();
                        temperature.setMaxTemp(Float.valueOf(parser.getString()));
                        temp.setTemp(temperature);

                    }


                }


            }
        }

        return temp;
    }
}



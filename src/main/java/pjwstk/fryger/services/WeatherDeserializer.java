package pjwstk.fryger.services;

import pjwstk.fryger.entity.*;


import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

public class WeatherDeserializer implements JsonbDeserializer<Weather> {


    @Override
    public Weather deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {

        Weather temp = new Weather();
        Temperature temperature = new Temperature();
        ConditionWeather condition = new ConditionWeather();


        while (parser.hasNext()) {

            JsonParser.Event event = parser.next();

            if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("weather")) {

                parser.next();
                parser.next();

                while (parser.next() != JsonParser.Event.END_OBJECT) {

                    if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("main")) {
                        parser.next();
                       condition.setMain(parser.getString());

                    }else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("description")) {

                        parser.next();
                        condition.setDescription(parser.getString());
                    }
                    else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("icon")) {

                        parser.next();
                        condition.setIcon(parser.getString());
                    }

                }
                temp.setCondition(condition);

            } else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("id")) {

                parser.next();
                temp.setId(parser.getString());
            } else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("name")) {

                parser.next();
                temp.setCityName(parser.getString());
            } else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("clouds")) {

                parser.next();

                while (parser.next() != JsonParser.Event.END_OBJECT) {

                    if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("all")) {
                        parser.next();
                        temp.setCloudiness(parser.getString());
                    }

                }
            } else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("wind")) {

                parser.next();

                while (parser.next() != JsonParser.Event.END_OBJECT) {

                    if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("speed")) {
                        parser.next();
                        temp.setWindSpeed(Float.valueOf(parser.getString()));
                    }

                }


            } else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("main")) {
                parser.next();

                while (parser.next() != JsonParser.Event.END_OBJECT) {


                    if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("temp")) {
                        parser.next();
                        temperature.setAverangeTemp(Float.valueOf(parser.getString()));
                        temp.setTemp(temperature);

                    } else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("pressure")) {
                        parser.next();

                        temp.setPressure(Float.valueOf(parser.getString()));

                    } else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("temp_min")) {
                        parser.next();
                        temperature.setMinTemp(Float.valueOf(parser.getString()));
                        temp.setTemp(temperature);

                    } else if (event == JsonParser.Event.KEY_NAME && parser.getString().equals("temp_max")) {
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




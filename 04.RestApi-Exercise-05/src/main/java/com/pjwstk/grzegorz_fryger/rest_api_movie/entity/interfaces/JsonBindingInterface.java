package com.pjwstk.grzegorz_fryger.rest_api_movie.entity.interfaces;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.json.bind.config.PropertyOrderStrategy;
import javax.json.bind.config.PropertyVisibilityStrategy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface JsonBindingInterface {

     default String toJson()
    {
        JsonbConfig jsonbConfig = new JsonbConfig().withPropertyVisibilityStrategy(new PropertyVisibilityStrategy() {
            @Override
            public boolean isVisible(Field field) {
                return false;
            }

            @Override
            public boolean isVisible(Method method) {
                return true;
            }
        });




        return JsonbBuilder.newBuilder().withConfig(jsonbConfig).build().toJson(this);

    }
}

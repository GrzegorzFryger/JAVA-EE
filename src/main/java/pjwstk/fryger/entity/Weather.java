package pjwstk.fryger.entity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;


public class Weather implements Serializable
{


    private String id;
    private String cityName;
    private ConditionWeather condition;
    private Temperature temp;
    private String cloudiness;
    private float windSpeed;
    private float  pressure;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ConditionWeather getCondition() {
        return condition;
    }

    public void setCondition(ConditionWeather condition) {
        this.condition = condition;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public String getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(String cloudiness) {
        this.cloudiness = cloudiness;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}

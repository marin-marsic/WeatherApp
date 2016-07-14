package eu.fiveminutes.android.weatherapp.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static org.junit.Assert.*;

import org.junit.Test;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;


public class JSONWeatherParserImplTest {

    public static final String JSON_DATA = "{" +
                                                "\"city\":{" +
                                                    "\"id\":3186886," +
                                                    "\"name\":\"Zagreb\"," +
                                                    "\"coord\":{" +
                                                        "\"lon\":15.97798," +
                                                        "\"lat\":45.814442}," +
                                                    "\"country\":\"HR\"," +
                                                    "\"population\":0}," +
                                                "\"cod\":\"200\"," +
                                                "\"message\":0.0109," +
                                                "\"cnt\":7," +
                                                "\"list\":[" +
                                                    "{ " +
                                                        "\"dt\":1468407600," +
                                                        "\"temp\":{" +
                                                            "\"day\":28.59," +
                                                            "\"min\":18.96," +
                                                            "\"max\":28.59," +
                                                            "\"night\":18.96," +
                                                            "\"eve\":22.57," +
                                                            "\"morn\":25.97}," +
                                                        "\"pressure\":996.17," +
                                                        "\"humidity\":76," +
                                                        "\"weather\":[" +
                                                            "{" +
                                                                "\"id\":502," +
                                                                "\"main\":\"Rain\"," +
                                                                "\"description\":\"heavy intensity rain\"," +
                                                                "\"icon\":\"10d\"}]," +
                                                        "\"speed\":1.86," +
                                                        "\"deg\":122," +
                                                        "\"clouds\":24," +
                                                        "\"rain\":17.94}]}";

    @Test
    public void testGetWeather() throws Exception {
        Gson gson = new GsonBuilder().create();
        WeatherResponse response = gson.fromJson(JSON_DATA, WeatherResponse.class);

        assertEquals("200", response.code);
        assertEquals("Zagreb", response.city.name);
        assertEquals("Rain", response.days.get(0).descriptionList.get(0).shortDescription);

    }
}
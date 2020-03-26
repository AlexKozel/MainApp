package com.example.MainApp;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static com.jayway.restassured.RestAssured.get;

public class ControllerTest {

    @Test
    public void getEmployeeByIdTest() throws JSONException {
        Response response = get("http://localhost:8080/1");

        JSONArray jsonArray = new JSONArray(response.asString());
        String name = jsonArray.getJSONObject(0).getString("firstName");
        Assert.assertEquals(name, "Sam");
    }

    @Test
    public void findAllTest(){}

    @Test
    public void saveUserTest(){}

    @Test
    public void updateTest(){}

    @Test
    public void deleteByIdTest(){}
}

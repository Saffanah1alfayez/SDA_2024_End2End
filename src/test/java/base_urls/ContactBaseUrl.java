package base_urls;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static utilities.Authentication.generateToken;

public class ContactBaseUrl {

 public static  RequestSpecification spec;

    @Before
    public static void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://documenter.getpostman.com/view/4012288/TzK2bEa8")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization" , "Bearer " +generateToken())
                .build();
    }

}

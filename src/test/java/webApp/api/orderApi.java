package webApp.api;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class orderApi {

    private String orderId;
    public RequestSpecification requestConfiguration() {
        RestAssured.baseURI = "https://practice-react.sdetunicorns.com/api/test/order";
        RequestSpecification request = given().config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC))).header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzFhNmQ3ZDk4NjE4OGQ0ZGNlNTA0MWIiLCJpYXQiOjE3MzAwNTA1MDZ9.QMb4b8zLLq-iopxCFYrKWmk3Pmu3hYhC6mBBWiYO7OU");
        return request;
    }


    public void listOrder() {
        Response response = requestConfiguration().when().get();
        System.out.println(response.body().toString());
        orderId= response.body().jsonPath().getString("[0]._id");
        System.out.println(orderId);
    }

    public  String getOrderId(){
        return orderId;
    }


}
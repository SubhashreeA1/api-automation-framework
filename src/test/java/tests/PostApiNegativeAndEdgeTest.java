package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import base.BaseTest;
import org.testng.annotations.Test;


public class PostApiNegativeAndEdgeTest extends BaseTest {

    @Test
    public void createPostPositiveTest() {

        String payload = "{ \"title\": \"API Automation\", \"body\": \"REST Assured\", \"userId\": 1 }";

        given()
                .log().body()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/posts")
                .then()
                .log().body()
                .statusCode(201)
                .body("title", equalTo("API Automation"))
                .body("userId", equalTo(1))
                .body("id", notNullValue());

    }
    @Test
    public void createPostWithoutPayload() {

        given()
                .header("Content-Type", "application/json")
                .when()
                .post("/posts")
                .then()
                .statusCode(201); // JSONPlaceholder accepts empty body
    }
    @Test
    public void invalidEndpointTest() {

        given()
                .when()
                .get("/invalidEndpoint")
                .then()
                .statusCode(404);
    }




}


package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreatePostTest extends BaseTest {

    @DataProvider(name = "postData")
    public Object[][] getPostData() {
        return new Object[][] {
                { "Post One", "Body One", 1 },
                { "Post Two", "Body Two", 2 },
                { "Post Three", "Body Three", 3 }
        };
    }

    @Test(dataProvider = "postData")
    public void createPostDataDrivenTest(String title, String body, int userId) {

        ExtentTest test = extent.createTest("Create Post - " + title);

        String payload = "{ \"title\": \"" + title + "\", " +
                "\"body\": \"" + body + "\", " +
                "\"userId\": " + userId + " }";

        given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo(title));

        test.pass("Post created successfully with title: " + title);
    }
}


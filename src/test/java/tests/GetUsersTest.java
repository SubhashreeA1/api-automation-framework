package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetUsersTest extends BaseTest {

    @Test
    public void validateGetUsersAPI() {

        ExtentTest test = extent.createTest("Validate GET Users API");

        given()
                .log().all()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", not(empty()))
                .body("size()", greaterThan(5))
                .body("[0].id", notNullValue())
                .body("[0].email", containsString("@"))
                .header("Content-Type", containsString("application/json"));

        test.pass("GET Users API validated successfully");
    }
}

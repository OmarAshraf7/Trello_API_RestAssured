package TrelloRestAPIsTestcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CardTest {
    @Test(priority = 0)
    public void ShouldBeAbleToCreateACard(){
        HashMap<String,String > quiries = new HashMap<>();
        quiries.put("name",EnviromentVariables.cardName);
        quiries.put("idList",EnviromentVariables.listID);
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);

        Response res =
        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .post(EnviromentVariables.cardEndPoint)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails()
                .extract().response();

        EnviromentVariables.cardID = res.path("id");
    }

    @Test(priority = 1)
    public void ShouldBeAbleToUpdateACard(){
        HashMap<String,String> quiries = new HashMap<>();
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);
        quiries.put("name",EnviromentVariables.newCardName);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .put(EnviromentVariables.cardEndPoint+EnviromentVariables.cardID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }

    @Test(priority = 2)
    public void ShouldBeAbleToGetACard(){
        HashMap<String,String> quiries = new HashMap<>();
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .get(EnviromentVariables.cardEndPoint+EnviromentVariables.cardID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }

    @Test(priority = 3)
    public void ShouldBeAbleToDeleteACard(){
        HashMap<String,String> quiries = new HashMap<>();
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .delete(EnviromentVariables.cardEndPoint+EnviromentVariables.cardID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }
}


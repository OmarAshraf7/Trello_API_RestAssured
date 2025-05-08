package TrelloRestAPIsTestcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ChecklistTest {
    @Test
    public void ShouldBeAbleToCreateAChecklist(){
        HashMap<String,String> quiries = new HashMap<>();
        quiries.put("idCard",EnviromentVariables.cardID);
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);
        quiries.put("name",EnviromentVariables.cheklistName);

        Response res =
        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .post(EnviromentVariables.checklistEndPoint)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails()
                .extract().response();

        EnviromentVariables.cheklistID = res.path("id");
    }
    @Test
    public void ShouldBeAbleToUpdateAChecklist(){
        HashMap<String,String> quiries = new HashMap<>();
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);
        quiries.put("name",EnviromentVariables.newCheklistName);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .put(EnviromentVariables.checklistEndPoint+EnviromentVariables.cheklistID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }

    @Test
    public void ShouldBeAbleToGetAChecklist(){
        HashMap<String,String> quiries = new HashMap<>();
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .get(EnviromentVariables.checklistEndPoint+EnviromentVariables.cheklistID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }

    @Test
    public void ShouldBeAbleToDeleteAChecklist(){
        HashMap<String,String> quiries = new HashMap<>();
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .delete(EnviromentVariables.checklistEndPoint+EnviromentVariables.cheklistID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }
}

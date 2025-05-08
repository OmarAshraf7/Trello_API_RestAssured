package TrelloRestAPIsTestcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ListTest {
    @Test
    public void ShouldBeAbleToCreateAList(){
        //Query Params Setup
        HashMap<String ,String > quiries = new HashMap<>();
        quiries.put("name",EnviromentVariables.listName);
        quiries.put("idBoard",EnviromentVariables.boardID);
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);

        //Response Extracting
        Response res=
        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .post(EnviromentVariables.listEndPoint)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails()
                .extract().response();

        EnviromentVariables.listID = res.path("id");
    }

    @Test
    public void ShouldBeAbleToUpdateAList(){
        //Query Params Setup
        HashMap<String ,String > quiries = new HashMap<>();
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);
        quiries.put("name",EnviromentVariables.newListName);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .put(EnviromentVariables.listEndPoint + EnviromentVariables.listID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }

    @Test
    public void ShouldBeAbleToGetAList(){
        //Query Params Setup
        HashMap<String ,String > quiries = new HashMap<>();
        quiries.put("key",EnviromentVariables.key);
        quiries.put("token",EnviromentVariables.token);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(quiries)
                .contentType(ContentType.JSON)
        .when()
                .get(EnviromentVariables.listEndPoint+EnviromentVariables.listID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }
}

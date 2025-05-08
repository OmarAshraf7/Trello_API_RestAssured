package TrelloRestAPIsTestcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class BoardTest {
    @Test(priority = 0)
    public void ShouldBeAbleToCreateABoard(){
        //Query Params Setup
        HashMap <String,String> queries = new HashMap<>();
        queries.put("name",EnviromentVariables.boardName);
        queries.put("key",EnviromentVariables.key);
        queries.put("token",EnviromentVariables.token);

        //Response Extracting
        Response res =
        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(queries)
                .contentType(ContentType.JSON)
        .when()
                .post(EnviromentVariables.boardEndPoint)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails()
                .extract().response();

        //Extracting the BoardID from the Response
        EnviromentVariables.boardID = res.path("id");
    }

    @Test(priority = 1)
    public void ShouldBeAbleToUpdateABoard(){
        //Query Params Setup
        HashMap <String,String> queries = new HashMap<>();
        queries.put("key",EnviromentVariables.key);
        queries.put("token",EnviromentVariables.token);
        queries.put("name",EnviromentVariables.newBoardName);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(queries)
                .contentType(ContentType.JSON)
        .when()
                .put(EnviromentVariables.boardEndPoint+EnviromentVariables.boardID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }

    @Test(priority = 2)
    public void ShouldBeAbleToGetABoard(){
        //Query Params Setup
        HashMap <String,String> queries = new HashMap<>();
        queries.put("key",EnviromentVariables.key);
        queries.put("token",EnviromentVariables.token);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(queries)
        .when()
                .get(EnviromentVariables.boardEndPoint+EnviromentVariables.boardID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }

    @Test(priority = 3)
    public void ShouldBeAbleToDeleteABoard(){
        //Query Params Setup
        HashMap <String,String> queries = new HashMap<>();
        queries.put("key",EnviromentVariables.key);
        queries.put("token",EnviromentVariables.token);

        given()
                .baseUri(EnviromentVariables.baseURL)
                .queryParams(queries)
        .when()
                .delete(EnviromentVariables.boardEndPoint+EnviromentVariables.boardID)
        .then()
                .assertThat().statusCode(200)
                .log().ifValidationFails();
    }

}

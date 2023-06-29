import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class APITests {
    @Test
    void apiTest1(){
        String url = "http://localhost:8080/api";
        given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    void apiTest2(){
        String url = "http://localhost:8080/api";
        given()
                .when()
                .get(url+"/v1/TA_PROJECT/filter/filters")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    void apiTest3(){
        String url = "http://localhost:8080/api";
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODgxMDU2MjUsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiZjA1MTI4ZTktYzk4MC00YzUwLWEwZDktNGZlYzhjNDk4NzliIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.4_d26jI3NdT_bs4ROrKXcOD722zWn8QNFXj9cEUfaFU")
                .header("Content-Type", "application/json");

        Response res = httpRequest.body("{  \"elements\": [    {      \"conditions\": [        {          \"condition\": \"string\",          \"filteringField\": \"string\",          \"value\": \"string\"        }      ],      \"description\": \"string\",      \"id\": \"string\",      \"name\": \"string\",      \"orders\": [        {          \"isAsc\": true,          \"sortingColumn\": \"string\"        }      ],      \"share\": true,      \"type\": \"launch\"    }  ]}")
                .when().put(url+"/v1/TA_PROJECT/filter");

        System.out.println("The response code - " +res.getStatusCode() + "\n"+res.getBody());
        assertEquals(res.getStatusCode(),500);
    }
    @Test
    void apiTest4(){
        String url = "http://localhost:8080/api";
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODgxMDU2MjUsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiZjA1MTI4ZTktYzk4MC00YzUwLWEwZDktNGZlYzhjNDk4NzliIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.4_d26jI3NdT_bs4ROrKXcOD722zWn8QNFXj9cEUfaFU")
                .header("Content-Type", "application/json");


        Response res = httpRequest.body("{\n" +
                        "  \"conditions\": [\n" +
                        "    {\n" +
                        "      \"condition\": \"cnt\",\n" +
                        "      \"filteringField\": \"name\",\n" +
                        "      \"value\": \"demo\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"description\": \"string\",\n" +
                        "  \"name\": \"string\",\n" +
                        "  \"orders\": [\n" +
                        "    {\n" +
                        "      \"isAsc\": false,\n" +
                        "      \"sortingColumn\": \"number\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"share\": true,\n" +
                        "  \"type\": \"launch\"\n" +
                        "}")
                .when().put(url+"/v1/ta_project/filter/18");


        System.out.println("The response code - " +res.getStatusCode());
        assertEquals(res.getStatusCode(),200);
    }

    @Test
    void apiTest5(){
        String url = "http://localhost:8080/api";
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODgxMDU2MjUsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiZjA1MTI4ZTktYzk4MC00YzUwLWEwZDktNGZlYzhjNDk4NzliIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.4_d26jI3NdT_bs4ROrKXcOD722zWn8QNFXj9cEUfaFU")
                .header("Content-Type", "application/json");


        Response res = httpRequest.body("{\n" +
                        "  \"conditions\": [\n" +
                        "    {\n" +
                        "      \"condition\": \"cnt\",\n" +
                        "      \"filteringField\": \"name\",\n" +
                        "      \"value\": \"demo\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"description\": \"string\",\n" +
                        "  \"name\": \"New Filter 3\",\n" +
                        "  \"orders\": [\n" +
                        "    {\n" +
                        "      \"isAsc\": true,\n" +
                        "      \"sortingColumn\": \"startTime\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"share\": true,\n" +
                        "  \"type\": \"launch\"\n" +
                        "}")
                .when().post(url+"/v1/ta_project/filter");

        System.out.println("The response code - " +res.getStatusCode());
        assertEquals(res.getStatusCode(),201);
    }
    @Test
    void apiTest6(){
        String url = "http://localhost:8080/api";
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODgxMDU2MjUsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiZjA1MTI4ZTktYzk4MC00YzUwLWEwZDktNGZlYzhjNDk4NzliIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.4_d26jI3NdT_bs4ROrKXcOD722zWn8QNFXj9cEUfaFU")
                .header("Content-Type", "application/json");

        Response res = httpRequest
                .when().delete(url+"/v1/ta_project/filter/19");

        System.out.println("The response code - " +res.getStatusCode());
        assertEquals(res.getStatusCode(),200);
    }
    @Test
    void apiTest7(){
        String url = "http://localhost:8080/api";
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODgxMDU2MjUsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiZjA1MTI4ZTktYzk4MC00YzUwLWEwZDktNGZlYzhjNDk4NzliIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.4_d26jI3NdT_bs4ROrKXcOD722zWn8QNFXj9cEUfaFU")
                .header("Content-Type", "application/json");

        Response res = httpRequest
                .delete(url+"/v1/ta_project/filter/99");

        System.out.println("The response code - " +res.getStatusCode());
        assertEquals(res.getStatusCode(),404);
    }
}

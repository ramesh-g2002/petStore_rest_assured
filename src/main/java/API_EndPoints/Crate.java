package API_EndPoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import API_Payload.UserPayload;
import POJOS.UserPage;
public class Crate {
public static void main(String[] args) {
RestAssured.baseURI="https://petstore3.swagger.io/api/v3";

UserPage u=new UserPage();
u.setId(2);
u.setUsername("Raj");
u.setFirstName("Raj");
u.setLastName("Kumar");
u.setEmail("Raj@gmail.com");
u.setPassword("1672");
u.setPhone("9873198266");
u.setUserStatus(5);
Response response = given().log().all().accept(ContentType.JSON)
.header("Content-Type","application/json")
.body(u).when().post("/user");
System.out.println(response.statusCode());

}
}

package API_EndPoints;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import API_Payload.UserPayload;
import POJOS.UserPage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class UserEndPoints {
	
	  UserPayload data=new UserPayload();
	  
	public  Response createUser(UserPage payload)
	{
		 Response response = given().log().all().accept(ContentType.JSON)
				.contentType(ContentType.JSON).body(payload)
		.when().post(Routes.post_url);
		return response;
	}
	public Response getUser(String un)
	{
		  Response response = given().log().all()
				  .accept(ContentType.JSON)
		.pathParam("username", un)
		.when().get(Routes.get_url);
		  System.out.println(response.statusCode());
		  return response;
		
	}
	
	
	public Response updateUser(String un,UserPage payload)
	{
		
		  Response response = given().log().all().accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username",un)
				.body(payload)
				.when().put(Routes.update_url);
				return response;
	}
	public Response deleteUser(String un)
	{
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", un)
				.when()
				.delete(Routes.delete_url);
				return response;
	}
	

}

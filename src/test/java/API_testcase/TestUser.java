package API_testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import API_EndPoints.UserEndPoints;
import API_Payload.UserPayload;
import POJOS.UserPage;
import io.restassured.response.Response;

public class TestUser {
UserEndPoints user=new UserEndPoints();
	Faker f;
	UserPage u;
	@BeforeClass
	public void generateData()
	{
		f=new Faker();
		u=new UserPage();
		u.setId(f.idNumber().hashCode());
		u.setUsername(f.name().username());
		u.setFirstName(f.name().firstName());
		u.setLastName(f.name().lastName());
		u.setEmail(f.internet().emailAddress());
		u.setPassword(f.internet().password());
		u.setPhone(f.phoneNumber().cellPhone());
		u.setUserStatus(0);
		
	}
	
	@Test(priority = 1)
	public void testcreateUser()
	{
		Response res = user.createUser(u);
		System.out.println("createUser..");
		res.then().log().all();
	}
	@Test(priority = 2)
	public void testGetUser()
	{
		System.out.println("________________________________________________________________");
		Response res = user.getUser(this.u.getUsername());
		System.out.println("getUser.."+this.u.getUsername());
		res.then().log().all();
		assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority = 3)
	public void testputUser()
	{
		System.out.println("________________________________________________________________");
		u.setUsername(f.name().username());
		Response res = user.updateUser(this.u.getUsername(), u);
		System.out.println("updateUser.."+this.u.getUsername());
		res.then().log().all();
		System.out.println("________________________________________________________________");
		Response updateres = user.getUser(this.u.getUsername());
		System.out.println("update response................................!!!!!");
		updateres.then().log().all();
	}
	@Test(priority = 4)
	public void testDeleteUser()
	{
		System.out.println("________________________________________________________________");
		Response res = user.deleteUser(this.u.getUsername());
		System.out.println("deleteUser..");
		res.then().log().all();
	}
	
}

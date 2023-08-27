package API_Payload;

import com.github.javafaker.Faker;

import POJOS.UserPage;

public class UserPayload {
	public static UserPage CreateUser()
	{
		Faker f=new Faker();
		UserPage u=new UserPage();
		u.setId(f.idNumber().hashCode());
		u.setUsername(f.name().username());
		u.setFirstName(f.name().firstName());
		u.setLastName(f.name().lastName());
		u.setEmail(f.internet().emailAddress());
		u.setPassword(f.internet().password());
		u.setPhone(f.phoneNumber().cellPhone());
		u.setUserStatus(0);
		return u;
	}

}

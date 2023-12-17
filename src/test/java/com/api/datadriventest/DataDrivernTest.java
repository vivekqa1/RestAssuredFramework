package com.api.datadriventest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.helpers.UserServiceHelper;
import com.api.model.User;
import com.api.utilities.DataProviders;

import io.restassured.response.Response;

public class DataDrivernTest {

	@Test(priority = 1, dataProvider = "UserData", dataProviderClass = DataProviders.class)
	public void testPostUser(String UserID, String UserName, String FirstName, String LastName, String Email,
			String Passwrod, String Phone) {

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Passwrod);
		userPayload.setPhone(Phone);
		userPayload.setUserStatus(0);

		Response response = UserServiceHelper.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String UserName) {

		Response response = UserServiceHelper.deleteUser(UserName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}

package com.api.test.property;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.helpers.UserServiceHelperFromProperties;
import com.api.model.User;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStatus(0);

		logger = LogManager.getLogger(this.getClass());
		logger.debug("This is for test");
		logger.info("This is an Info Message!");
		logger.error("And here comes the Error Message!");

	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("*************** Creating user *******************************");
		Response response = UserServiceHelperFromProperties.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************** User is created. *******************************");
	}

	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("*************** Reading user info *******************************");
		Response response = UserServiceHelperFromProperties.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***************  user info is display *******************************");
	}

	@Test(priority = 3)
	public void testUpdateUserByName() {

		logger.info("*************** User is updating *******************************");

		// update data

		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());

		Response response = UserServiceHelperFromProperties.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		// checking data after update

		Response responseafterupdate = UserServiceHelperFromProperties.getUser(this.userPayload.getUsername());
		responseafterupdate.then().log().all();
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);

		logger.info("*************** User is updated *******************************");
	}

	@Test(priority = 4)
	public void testDeleteUserByName() {

		logger.info("*************** Deleting user *******************************");

		Response response = UserServiceHelperFromProperties.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		logger.info("*************** User Deleted *******************************");
	}

}

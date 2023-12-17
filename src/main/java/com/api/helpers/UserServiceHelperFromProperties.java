package com.api.helpers;

import java.util.ResourceBundle;

import com.api.model.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserServiceHelperFromProperties {


	static ResourceBundle getURL()
	{
		ResourceBundle resourceBundle = ResourceBundle.getBundle("endpoints");
		return resourceBundle;
	}
	

	public static Response createUser(User payload) {

		Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.when().post(getURL().getString("post_url"));

		return response;
	}

	public static Response getUser(String userName) {

		Response response = RestAssured.given().pathParam("username", userName).when()
				.get(getURL().getString("get_url"));

		return response;
	}

	public static Response updateUser(String userName, User payload) {

		Response response = RestAssured.given().pathParam("username", userName).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload).when().put(getURL().getString("update_url"));

		return response;
	}

	public static Response deleteUser(String userName) {

		Response response = RestAssured.given().pathParam("username", userName).when()
				.delete(getURL().getString("delete_url"));

		return response;
	}

}

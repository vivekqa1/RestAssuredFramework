package com.api.helpers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import com.api.constants.Endpoints;
import com.api.model.User;
import com.api.utilities.ConfigManager;

public class UserServiceHelper {

	public static final String BASE_URL = ConfigManager.getInstance().getString("base_url");

//	public UserServiceHelper() {
//		RestAssured.baseURI = BASE_URL;
//	}

	public static Response createUser(User payload) {

		Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.when().post(BASE_URL + Endpoints.Create_User);

		return response;
	}

	public static Response getUser(String userName) {

		Response response = RestAssured.given().pathParam("username", userName).when()
				.get(BASE_URL + Endpoints.Get_User);

		return response;
	}

	public static Response updateUser(String userName, User payload) {

		Response response = RestAssured.given().pathParam("username", userName).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload).when().put(BASE_URL + Endpoints.Update_User);

		return response;
	}

	public static Response deleteUser(String userName) {

		Response response = RestAssured.given().pathParam("username", userName).when()
				.delete(BASE_URL + Endpoints.Delete_User);

		return response;
	}

}

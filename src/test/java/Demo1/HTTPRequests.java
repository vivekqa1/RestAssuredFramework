package Demo1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

//given() -  pre - requesit - content type, cookies, add auth, add param, set headers and info...
//when() - get, post, put, delete
//then() -  response validation , body , status, status code, etract response, extract headers cookies & response body...

// Static package need to import -  

//GET: https://reqres.in/api/users/2

//POST: https://reqres.in/api/users

//PUT: https://reqres.in/api/users/593

//DELETE: https://reqres.in/api/user/userid

public class HTTPRequests {

	int id;
	
	 @Test(priority=1)
	public void getUsers() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
		

	}

	@Test(priority=2)
	public void createNewUser() {

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "tester2");
		hm.put("job", "QA");

		id = given().contentType("application/json").body(hm)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

				//.then().statusCode(201).body("name", equalTo("tester")).log().all();

	}
	
	@Test(priority=3, dependsOnMethods = {"createNewUser"})
	public void updateUser() {

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("job", "Sr. QA");

		given().contentType("application/json").body(hm)

				.when().put("https://reqres.in/api/users/"+id)

				.then().statusCode(200).body("job", equalTo("Sr. QA")).log().all();

	}
	
	@Test(priority=4, dependsOnMethods = {"createNewUser"})
	public void deleteUser() {


		given()

				.when().delete("https://reqres.in/api/users/"+id)

				.then().statusCode(204).log().all();

	}

}

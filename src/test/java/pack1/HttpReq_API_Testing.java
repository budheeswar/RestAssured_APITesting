package pack1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpReq_API_Testing {
	int id;

	@Test(priority = 1)
	public void getUsers() {
		when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log().all();

	}

	@Test(priority = 2)
	public void createUser() {

		HashMap<String, String> data = new HashMap<>();
		data.put("name", "Buddeeswar");
		data.put("job", "Tester");

		id = given().contentType("application/json").body(data).when().post("https://reqres.in/api/users").jsonPath()
				.getInt("id");
		// .then()
		// .statusCode(201)

	}

	@Test(priority = 3, dependsOnMethods = { "createUser" })
	public void updateUser() {

		HashMap<String, String> data = new HashMap<>();
		data.put("name", "Rb");
		data.put("job", "Tester");

		given().contentType("application/json").body(data).when().put("https://reqres.in/api/users/" + id)
               .then().statusCode(200);

	}

	@Test
	public void deleteUser() {
		when().delete("https://reqres.in/api/users/" + id).then().statusCode(204);

	}
}

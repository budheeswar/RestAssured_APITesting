package pack2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class PathAndQueryParameter {

	public void pathAndQueryParamExample() {
		given().pathParam("myPath", "api")
		       .pathParam("path2", "users")
		       .queryParam("page", 2)
		       .queryParam("id", 5)
		.when()
				.get("URL goes here").
		then()
			.statusCode(200);
	}

}

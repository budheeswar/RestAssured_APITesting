package pack2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

public class DiffWaysCreatingPOSTReq {

	// Using HASHMAP, JSON, POJO CLASS[PREFERED], EXTERNAL JSON.

	void usingHashmap() {
		HashMap<String, String> data = new HashMap<>();
		data.put("Name", "Rb");
		data.put("Role", "Tester");
		// now pass this data as request in given()
		
		given().contentType("application/json")
		.body(data)
		.when().post("URL goes here");
		// so On....
	}
	void usingJSON() {
		
		JSONObject data =new JSONObject();
		data.put("Name", "RB");
		data.put("Role", "Tester");
		
		given().contentType("application/json")
		.when().body(data.toString());   // Convert JSON Object to string and pass in body method
		//So on... 
		
	}
	void usingPOJO() {
		// create a pojo class with getters and setters 
		// create object for that POJO class and set values and pass as parameter in body method
		
	}
	void usingExternalJSONFile() throws FileNotFoundException {
		File f = new File("<External JSON FIle PAth>");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		// in given() method use .body(data.toString());
		// and pass data as request
	}
	

}

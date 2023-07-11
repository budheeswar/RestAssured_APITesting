package pack2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class HandlingCookiesAndHeaders {
	@Test
	public void handlingCookies() {
		Response res = when().get("https://google.com");
		
		//Single cookie
		String cookie1 = res.getCookie("AEC");
		System.out.println(cookie1);
		
		//multiple cookies
		Map<String, String> cookies = res.getCookies();
		for(String ck: cookies.keySet()) {
			String cv = res.getCookie(ck);
			System.out.println(ck+" value "+cv);
		}
		
				
	}
	@Test
	public void handlingHeaders() {
		
		Response res = when().get("https://google.com");
		
		//Single Header
		String header1 = res.getHeader("content-type");
		System.out.println(header1);
		
		for(Header hd: res.getHeaders()) {
			System.out.println(hd.getName()+" ="+hd.getValue());
		}
	}
	@Test
	void logMethods() {
		given().when().get("https://youtube.com").then()
							 .log().body()
							 .log().headers()
							 .log().cookies()
							 .log().all();
	}
	
	

}

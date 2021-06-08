package com.spacex.api;

import org.openqa.selenium.html5.ApplicationCache;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class GetLatestSpaceX 
{
	
	@Test
	public void getSpaceXLatest()
	{
		RestAssured.baseURI="https://api.spacexdata.com/";
		String response = 
				RestAssured.given().log().all()
		.when().get("v4/launches/latest")
		.then().log().all().assertThat().statusCode(200) //STATUS CODE VERIFICATION
		.body("id", equalTo("5fe3af6db3467846b3242160"))
		.body("links.youtube_id", equalTo("bgtDRR2F2wA"))
		.header("Content-Type", "application/json; charset=utf-8")    //CONTENT-TYPE VERIFICATION
		.extract().response().asString();
		
	}
}

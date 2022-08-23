package com.juaracoding.posttest21;

import static org.hamcrest.CoreMatchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestPost {

	@Test
	public void TestPost21() {
		JSONObject request = new JSONObject();
		request.put("name", "John Connor");
		request.put("category", "SQA Engineer");
		request.put("price", 1000000);
		System.out.println(request.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("https://mern-backend-8881.herokuapp.com/products").then()
				.statusCode(200).log().all();
	}

}

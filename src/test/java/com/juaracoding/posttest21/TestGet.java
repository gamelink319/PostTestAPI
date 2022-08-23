package com.juaracoding.posttest21;

import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGet {

	String endpoint = "https://mern-backend-8881.herokuapp.com/products";

	@Test
	public void TestStatusCode() {
		Response response = RestAssured.get(endpoint);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());

		int actual = response.getStatusCode();
		assertEquals(actual, 200);
	}

	@Test
	public void TestValidSatu() {
		given().get(endpoint).then().statusCode(200).body("name[29]", equalTo("John Connor"));
	}

	@Test
	public void TestValidDua() {
		given().get(endpoint).then().statusCode(200).body("category[29]", equalTo("SQA Engineer"));
	}

	@Test
	public void TestValidTiga() {
		given().get(endpoint).then().statusCode(200).body("price[29]", equalTo(1000000));
	}
}

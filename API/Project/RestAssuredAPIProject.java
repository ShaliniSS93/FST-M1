package RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredAPIProject {
	int id;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	
@BeforeClass
public void setUp() {

    requestSpec = new RequestSpecBuilder().addHeader("Authorization","token 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")
        .setContentType(ContentType.JSON)
        .setBaseUri("https://api.github.com")
        .build();
	
responseSpec = new ResponseSpecBuilder()
    .expectContentType("application/json")
   .build();
}
@Test(priority=1)
public void PostRequest() {
	String reqBody= "{\"title\": \"TestAPIKey\", \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDaOOXf+tXlXrRfV5L2YdnJDyu1G0PWNaV5+2gozArcXCYHt5b8z8BXu0uA6FC3AdwdwOZjV4zjf5skPZqcA/QdKGlzUbp324ISiQe5n1Q5+hVRd3V/Qg/IGMrOsDVJ7VGbO8P8AklAWsz2ZVdVcDagd+7ONvQldvDUjKfxZCZT6M2sbwZ4kxwxZkXp3kvnb/44GaDX+adxoWLn+RN1bE+BVi22dgV1na6r1FS/zkhpBoSJ1qrtWHCfrAt6BNCG/Pi1wffognPpaaNKVwneg31zuNP+aKaKz6bTkrLhWamzUQ9IZk/EqJYbwQaMg8MzbOLBsS6NdK+6/7sIT8BhVWXMjKFVGby/xtveD07bJDwJYt1WvNpm45dVgvu4aJEjyK+ObLJ2nM5Aquto67ZPMxlXjQV+Za0eNF0U259difVYp1EVd4Xak3n6+mlhYMvcTttDDr8yhefxsd5xKrChgxDCwBY8PVvtjt2vI7wUqymb+Ib4A1wn02/B8odu9CZ2rGs=\"}";

	Response response = given().spec(requestSpec)
             .body(reqBody) 
             .post("/user/keys");
	response.then().spec(responseSpec);
	String body= response.getBody().asPrettyString();
	System.out.println(body);
	id=response.then().extract().path("id");
	Assert.assertEquals(response.getStatusCode(), 201);
}
@Test(priority=2)
public void GetRequest() {
	Response response=given().spec(requestSpec)
			.get("/user/keys");


	 System.out.println(response.getBody().asPrettyString());
	 Reporter.log(response.getBody().asPrettyString());
	Assert.assertEquals(response.getStatusCode(), 200);
}
@Test(priority=3)
public void DeleteRequest() {
	Response response=given().spec(requestSpec)
			.when().pathParam("keyId", id)
			.delete("/user/keys/{keyId}");


	 System.out.println(response.getBody().asPrettyString());
	 Reporter.log(response.getBody().asPrettyString());
	Assert.assertEquals(response.getStatusCode(), 204);
}
}

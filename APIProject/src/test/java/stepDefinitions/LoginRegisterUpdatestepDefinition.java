package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import pojo.LoginRegisterUpdate;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
//import static org.hamcrest.Matchers.*;

//import java.nio.file.Files;
//import java.nio.file.Paths;

public class LoginRegisterUpdatestepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@Given("^Login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_and(String emailaddress, String password) throws IOException {

		res = given().spec(requestSpecification()).body(data.loginPayload(emailaddress, password));

	}

	@When("^users calls \"([^\"]*)\" with \"([^\"]*)\" https request$")
	public void users_calls_with_post_https_request(String resource, String method) throws Throwable {

		APIResources resourcsApi = APIResources.valueOf(resource);
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourcsApi.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get(resourcsApi.getResource());
		else if (method.equalsIgnoreCase("PUT"))
			response = res.when().put(resourcsApi.getResource());

	}

	@Then("^the API call is success with status code (\\d+)$")
	public void the_API_call_is_success_with_status_code(int Expectedvalue) throws Throwable {

		assertEquals(response.getStatusCode(), Expectedvalue);

	}

	@Then("^\"([^\"]*)\" should be \"([^\"]*)\"$")
	public void should_be(String keyvalue, String Expectedvalue) throws Throwable {

		assertEquals(getJsonPath(response, keyvalue), Expectedvalue);

	}
	
	@Given("^update the user \"([^\"]*)\" and \"([^\"]*)\"$")
	public void update_the_user_and(String name, String job) throws Throwable {
		
		res = given().spec(requestSpecification()).body(data.updateInfoPayload(name, job));
	   
	}


}

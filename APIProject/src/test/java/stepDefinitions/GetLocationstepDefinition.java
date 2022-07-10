package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetLocationstepDefinition extends Utils {

	RequestSpecification req;
	ResponseSpecification resspec;
	Response getresponse;

	@When("^users calls the \"([^\"]*)\" with \"([^\"]*)\" https request$")
	public void users_calls_the_with_https_request(String resource, String method) throws Throwable {

		req = given().spec(getlocationrequestSpecification());
		APIResources getlocresourcsApi = APIResources.valueOf(resource);
		getresponse = req.when().get(getlocresourcsApi.getResource());
		System.out.println(getresponse.asString());

	}

	@Then("^the API call success with status code (\\d+)$")
	public void the_API_call_success_with_status_code(int Expectedvalue) throws Throwable {

		assertEquals(getresponse.getStatusCode(), Expectedvalue);

	}

	@Then("^\"([^\"]*)\" must be \"([^\"]*)\"$")
	public void must_be(String keyvalue, String Expectedvalue) throws Throwable {

		assertEquals(getJsonPath(getresponse, keyvalue), Expectedvalue);

	}

}

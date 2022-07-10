package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {

		if (req == null) {

			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(getGlobalValue("baseurl"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public RequestSpecification getlocationrequestSpecification() throws IOException {

		if (req == null) {

			HashMap<String, String> querymap = new HashMap<String, String>();
			querymap.put("query", "new york");
			querymap.put("locale", "en_US");
			querymap.put("currency", "USD");

			HashMap<String, String> headermap = new HashMap<String, String>();
			headermap.put("X-RapidAPI-Host", "hotels4.p.rapidapi.com");
			headermap.put("X-RapidAPI-Key", "ae150db1cdmshd22b0a20e4ec274p1d7910jsn0f97377ad143");

			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(getGlobalValue("getlocationbaseurl"))
					.addQueryParams(querymap).addHeaders(headermap).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public static String getGlobalValue(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\SeleniumminiProject\\APIMiniProject\\APIProject\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);

		return prop.getProperty(key);

	}

	public String getJsonPath(Response response, String key) {

		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();

	}

}

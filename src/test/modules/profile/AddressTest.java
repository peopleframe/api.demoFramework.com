package test.modules.profile;

import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import test.java.TestBase;

/**
 * This class is used to verify address api GET, PUT request types
 * 
 * @author shaik
 *
 */
public class AddressTest extends TestBase {

	private static String response;
	private static String JsonBody;
	private static String JsonExpression;
	private static Map<String, Object> JsonElement;

	@Test
	public void verify_AddressApi() {
		BasicConfigurator.configure();

		try {
			setExcelData();
			//urlPath = buildUrlPath();

			switch (requestType) {
			case GET:
				response = apiRequestHandler.callApi(requestType,
						urlPath, body, statusCode);
				APP_LOGS.debug("Responsee:: " + response);
				System.out.println(response);

				break;

			case PUT:
//				response = apiRequestHandler.callApi(apiRequestHandler.getFinalCookie(actualCookie), requestType,
//						urlPath, body, statusCode);
//				APP_LOGS.debug("Responsee:: " + response);
				break;

			default:
				APP_LOGS.debug("Enter the requestType ::");
				break;
			}

		} catch (Exception exception) {
			APP_LOGS.error("Exception occured in Api_automatio_Test :: " + exception.getMessage());
		}
	}

	@AfterTest
	public void getJsonElement() {

		/*JsonBody = response;
		JsonExpression = "$.data";
		JsonElement = JsonPath.read(JsonBody, JsonExpression);
		System.out.println(JsonElement);*/

	}

}

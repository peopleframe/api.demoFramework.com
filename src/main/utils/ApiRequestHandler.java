package main.utils;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is used to Invoke API
 * 
 * @author shaik
 *
 */

public class ApiRequestHandler {
	
	private static final String GET = "GET";
	private static final  String POST = "POST";
	private static final String PUT = "PUT";
	private static final String DELETE = "DELETE";

	private static  String cookie;

	private RequestSpecification request = RestAssured.given();
	private Response response;

	public ApiRequestHandler() {
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
	}

	/**
	 * This method is used to generate cookie value
	 * 
	 * @param employeeId
	 *            Employee Id
	 * @param password
	 *            Password
	 * @return Cookie
	 */
	public  String getCookieFromSignOnApi(String employeeId, String password) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("emplid", employeeId);
			jsonObject.put("userpassword", password);

			//cookie = callApi(null, POST, PropertiesUtil.SignOnUrl, jsonObject.toString(), "200");
		} catch (Exception exception) {
			System.out.println("Exception occured in getCookieFromSignOnApi :: " + exception.getMessage());
		}
		return cookie;
	}

	/**
	 * This method is used to return final cookie
	 * 
	 * @param cookie
	 *            Cookie
	 * @return Final Cookie
	 */
	public String getFinalCookie(String cookie) {
		String finalCookie = null;
		try {
			finalCookie = "TriNetAuthCookie" + PropertiesUtil.Environment + "=" + cookie;
		} catch (Exception exception) {
			System.out.println("Exception occured in getFinalCookie :: " + exception.getMessage());
		}
		return finalCookie;

	}

	/**
	 * This method is used to call the API
	 * 
	 * @param signOnCookie
	 *            Cookie
	 * @param requestType
	 *            Request Type
	 * @param fullUrl
	 *            Full url
	 * @param requestBody
	 *            Request Body
	 * @param expectedSatusCode
	 *            Expected Status Code
	 * @return Response
	 */
	public String callApi(String requestType, String fullUrl, String requestBody,
			String expectedSatusCode) {
		try {

			switch (requestType.toUpperCase()) {
			case GET:
				//request.header("Cookie", signOnCookie);
				response = request.get(fullUrl);
				Assert.assertEquals(Integer.parseInt(expectedSatusCode), response.statusCode());
				break;

			case PUT:
				//request.header("Cookie", signOnCookie);
				request.body(requestBody);
				response = request.put(fullUrl);
				Assert.assertEquals(Integer.parseInt(expectedSatusCode), response.statusCode());
				break;

			case POST:
				if (StringUtils.isNotEmpty(cookie)) {
					//request.header("Cookie", signOnCookie);
				}
				request.body(requestBody);
				response = request.post(fullUrl);
				Assert.assertEquals(Integer.parseInt(expectedSatusCode), response.statusCode());
				break;

			case DELETE:
				//request.header("Cookie", signOnCookie);
				response = request.delete(fullUrl);
				Assert.assertEquals(Integer.parseInt(expectedSatusCode), response.statusCode());
				break;

			default:
				System.out.println("Please provide valid request type :: " + requestType);
				break;
			}

		} catch (Exception exception) {
			System.out.println("Exception occured in callApi :: " + exception.getMessage());
		}
		return response.asString();
	}
}




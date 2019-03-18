package test.java;

import org.testng.annotations.Test;

import main.utils.ApiRequestHandler;
import main.utils.PropertiesUtil;

/**
 * @author shaik
 *
 */
public class DELETERequestVerification extends TestBase {
	
	/**
	 * 
	 * This method is used to test the API DELETE Request
	 * 
	 */
	@Test
	public void Api_automatio_Test_Delete() {
		
		ApiRequestHandler apiRequestHandler= new ApiRequestHandler();
		try {
		actualCookie = apiRequestHandler.getCookieFromSignOnApi("00001140180", "1234");
		employeeId = "00001140180";
		companyId="6P1";
    	urlPath = PropertiesUtil.BaseUrl+"api-profile/v1/profile/{companyId}/{employeeId}/emergency-contacts/test/2";
		replaceParams = "{companyId},{employeeId}";
		
		urlPath = buildUrlPath();
		
		
		String reponse = apiRequestHandler.callApi(apiRequestHandler.getFinalCookie(actualCookie),"DELETE", urlPath, null);
		System.out.println("Responsee:: "+ reponse );
		}
		catch (Exception exception) {
			System.out.println("Exception occured in Api_automatio_Test_Delete :: " + exception.getMessage());
		}
		
		
		
	}

}

package test.java;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.Test;

import main.utils.ApiRequestHandler;
import main.utils.PropertiesUtil;

public class PUTRequestVerification extends TestBase{
	
	/**
	 * this method is used test the API PUT request
	 * 
	 */
	@Test
	 public void Automation_test_PUT() {
		BasicConfigurator.configure();
		ApiRequestHandler apiRequestHandler= new ApiRequestHandler();
		try {
		actualCookie=apiRequestHandler.getCookieFromSignOnApi("00001140180", "1234");
		
		employeeId = "00001140180";
		companyId="6P1";
		
		firstName="Sri";
		middleName="Satya";
		lastName="Ram";
		effectiveDate=randomDataUtil.generateTomorrowDate("yyyy-MM-dd");
		
		body="{ \"approvalStatus\": \"F\", \"effectiveDate\": \"{effectiveDate}\", \"employeeId\": \"{employeeId}\", \"endDate\": \"2099-12-31\", \"firstName\": \"{firstName}\", \"formOfAddress\": \"Mrs\", \"middleName\": \"{middleName}\", \"nameFormat\": \"US\", \"nameType\": \"PRF\", \"personTitle\": null, \"reasonChangeCode\": null, \"uniqueId\": 12, \"prevEffectiveDate\": null, \"lastName\": \"{lastName}\", \"suffix\": \"II\", \"name\": null }";
		urlPath=PropertiesUtil.BaseUrl+"api-profile/v1/identity/{companyId}/{employeeId}/names";
		replaceParams="{companyId},{employeeId},{firstName},{lastName},{middleName},{effectiveDate}";
		
		body=buildPayloadBody();
		urlPath=buildUrlPath();
		String reponse = apiRequestHandler.callApi(apiRequestHandler.getFinalCookie(actualCookie),"PUT", urlPath,body);
		APP_LOGS.debug("Responsee:: "+ reponse );
		}
		catch (Exception exception) {
			APP_LOGS.error("Exception occured in Automation_test_PUT :: " + exception.getMessage());
		}
		
	}
	
	/**
	 * this method is used to generate nextDate
	 * 
	 */
	/*@Test
	public void dateTest()
	{
		try {
			 Date=randomDataUtil.generateTomorrowDate("2018-02-05");
		}
		catch (Exception exception) {
			System.out.println("Exception occured in dateTest :: " + exception.getMessage());
		}
	}*/

}

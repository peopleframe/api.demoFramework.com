package test.java;

import org.testng.annotations.Test;

import main.utils.ApiRequestHandler;
import main.utils.PropertiesUtil;


public class POSTRequestVerification extends TestBase{
	
	private String actualCookie = null;
	
	
	/**
	 * 
	 * This method is used to test the API POST Request
	 * 
	 */
	@Test
	 public void Automation_test_POST() {
		
		ApiRequestHandler apiRequestHandler= new ApiRequestHandler();
		try {
		actualCookie=apiRequestHandler.getCookieFromSignOnApi("00001140180", "1234");
		
		employeeId = "00001140180";
		companyId="6P1";
		
		
		body="{ \"accountList\": [ { \"employeeId\": \"{employeeId}\", \"effectiveDate\": \"2018-02-09\", \"accountName\": \"Account Name\", \"accountType\": \"Checking\", \"routingNumber\": \"122105278\", \"bankId\": null, \"branchId\": null, \"accountNumber\": \"6724301068\", \"priority\": 700, \"netBalance\": true, \"fsaAccount\": false, \"apAccount\": false, \"amount\": null, \"percent\": null, \"uniqueId\": 1, \"amountType\": \"netBalance\", \"account_number\": \"Checking****1068\", \"remAmount\": 1468.76, \"payCheck\": 1468.76, \"actualAmount\": \"Full Amount\", \"data\": { \"exempt\": \"Y\" } } ] }";
		urlPath=PropertiesUtil.BaseUrl+"api-money/v1/direct-deposit/{companyId}/{employeeId}/accounts";
		replaceParams="{companyId},{employeeId}";
		
		body=buildPayloadBody();
		urlPath=buildUrlPath();
		
		String reponse = apiRequestHandler.callApi(apiRequestHandler.getFinalCookie(actualCookie),"POST", urlPath,body);
		System.out.println("Responsee:: "+ reponse );
		}
		catch (Exception exception) {
			System.out.println("Exception occured in Automation_test_POST :: " + exception.getMessage());
		}
		
	}

	

}

package test.java;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.Test;

public class GETRequestVerification extends TestBase {

	/**
	 * This method is used to test the API GET statement/request
	 * 
	 */
	@Test
	public void Api_automatio_Test() {
		BasicConfigurator.configure();
		try {
			
		    setExcelData();
		    
		    urlPath = buildUrlPath();
			
			String reponse = apiRequestHandler.callApi(requestType,
					urlPath, body, statusCode);
			APP_LOGS.debug("Responsee:: " + reponse);
			System.out.println(reponse);
		} catch (Exception exception) {
			APP_LOGS.error("Exception occured in Api_automatio_Test :: " + exception.getMessage());
		}
	}

}

package test.java;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import main.utils.ApiRequestHandler;
import main.utils.Common;
import main.utils.Constants;
import main.utils.PropertiesUtil;
import main.utils.RandomDataUtil;
import main.utils.ReadExcelUtil;

/**
 * This is the api base class for all the test scripts
 * 
 * @author shaik
 *
 */
public abstract class TestBase {

	protected PropertiesUtil propertiesUtil;
	protected RandomDataUtil randomDataUtil;
	protected Common common;
	protected Constants constants;
	protected ReadExcelUtil readExcelUtil;
	protected ApiRequestHandler apiRequestHandler;

	protected Hashtable<String, String> testData = new Hashtable<String, String>();

	public static Logger APP_LOGS = Logger.getLogger("devpinoyLogger");

	protected String actualCookie = null;
	
	protected static final String GET = "GET";
	protected static final String PUT = "PUT";
	
	protected String employeeId;
	protected String companyId;
	protected String password;
	protected String urlPath;
	protected String body;
	protected String statusCode;
	protected String requestType;
	protected String replaceParams;

	protected String firstName;
	protected String lastName;
	protected String middleName;
	protected String accountName;
	protected String effectiveDate;

	/**
	 * 
	 * This method is used to setup the
	 * 
	 */
	@BeforeClass
	public void setUp() {
		common = new Common();
		constants = new Constants();
		readExcelUtil = new ReadExcelUtil();
		randomDataUtil = new RandomDataUtil();
		propertiesUtil = new PropertiesUtil();
		apiRequestHandler = new ApiRequestHandler();
		propertiesUtil.initProperties();

	}

	/**
	 * Set Excel Data
	 */
	public void setExcelData() {
		try {
			readExcelUtil.getExcelFile(
					"C:\\Users\\Swathi\\Downloads\\API-RestAssure\\TestData\\TestData.xlsx", "Sheet2");
			testData = readExcelUtil.getMultipleCellData();

			employeeId = testData.get("employeeId");
			companyId = testData.get("company");
			password = testData.get("password");
			urlPath = PropertiesUtil.testURL + testData.get("url");
			replaceParams = testData.get("replaceParams");
			requestType = testData.get("requestType");
			body = testData.get("body");
			statusCode = testData.get("statusCode");

			actualCookie = apiRequestHandler.getCookieFromSignOnApi(employeeId, password);
		} catch (Exception exception) {
			APP_LOGS.debug(exception);
		}
	}

	/**
	 * This method is used to replace params dynamically in URL
	 * 
	 * @return finalUrlPath
	 */
	public String buildUrlPath() {
		String finalUrlPath = null;
		String[] replaceParamsList = replaceParams.split(",");
		try {
			if (replaceParamsList.length > 0) {
				for (String replaceParam : replaceParamsList) {
					if (!urlPath.contains(replaceParam)) {
						finalUrlPath = urlPath;
					} else {
						finalUrlPath = buildAndReplaceParams(replaceParam, urlPath);
						urlPath = finalUrlPath;
					}
				}
			} else {
				finalUrlPath = urlPath;
			}
		} catch (Exception exception) {
			// System.out.println(exception);
			APP_LOGS.debug(exception);
		}
		return finalUrlPath;
	}

	/**
	 * This method is used to replace params dynamically in payload
	 * 
	 * @return finalPayload
	 */
	public String buildPayloadBody() {
		String finalPayload = null;
		String[] replaceParamsList = replaceParams.split(",");
		try {
			if (replaceParamsList.length > 0) {
				for (String replaceParam : replaceParamsList) {
					if (!body.contains(replaceParam)) {
						finalPayload = body;
					} else {
						finalPayload = buildAndReplaceParams(replaceParam, body);
						body = finalPayload;
					}
				}
			} else {
				finalPayload = body;
			}
		} catch (Exception exception) {
			// System.out.println(exception);
			APP_LOGS.error(exception);
		}
		return finalPayload;
	}

	/**
	 * 
	 * This method is used to build and replace params in both payload and URL
	 * 
	 * @param replaceParam
	 * @param actualString
	 * @return finalValue
	 */
	public String buildAndReplaceParams(String replaceParam, String actualString) {
		String finalValue = null;
		try {
			switch (replaceParam) {
			case Constants.EMPLOYEE_ID:
				finalValue = Common.replaceParams(actualString, Constants.EMPLOYEE_ID, employeeId);
				break;
			case Constants.COMPANY_ID:
				finalValue = Common.replaceParams(actualString, Constants.COMPANY_ID, companyId);
				break;
			case Constants.FIRST_NAME:
				finalValue = Common.replaceParams(actualString, Constants.FIRST_NAME, firstName);
				break;
			case Constants.LAST_NAME:
				finalValue = Common.replaceParams(actualString, Constants.LAST_NAME, lastName);
				break;
			case Constants.MIDDLE_NAME:
				finalValue = Common.replaceParams(actualString, Constants.MIDDLE_NAME, middleName);
				break;
			case Constants.ACCOUNT_NAME:
				finalValue = Common.replaceParams(actualString, Constants.LAST_NAME, accountName);
				break;
			case Constants.EFFECTIVE_DATE:
				finalValue = Common.replaceParams(actualString, Constants.EFFECTIVE_DATE, effectiveDate);
				break;

			default:
				// System.out.println("Please supply valid replace param");
				APP_LOGS.debug("Please supply valid replace param");
				break;
			}
		} catch (Exception exception) {
			// System.out.println(exception);
			APP_LOGS.error("Exception Occured in buildAndReplaceParams ::" + exception);
		}
		return finalValue;
	}
}

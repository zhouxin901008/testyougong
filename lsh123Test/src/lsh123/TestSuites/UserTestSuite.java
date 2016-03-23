package lsh123.TestSuites;

import junit.framework.TestSuite;
import lsh123.test.*;

public class UserTestSuite {

	/**
	 * @param args
	 */
	public static TestSuite getTestSuite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(RegisterTest.class);
		suite.addTestSuite(LoginTest.class);
		suite.addTestSuite(ForgetPasswordTest.class);
		return suite;

	}

}
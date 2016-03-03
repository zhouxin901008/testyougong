package lsh123.TestSuites;

import com.zutubi.android.junitreport.JUnitReportTestRunner;

import lsh123.TestSuites.UserTestSuite;
import junit.framework.TestSuite;

public class Runner1 extends JUnitReportTestRunner {
	/**
	 * @param args
	 */
	@Override
	public TestSuite getAllTests() {
		TestSuite suite = new TestSuite();
		//suite.addTest(UserTestSuite.getTestSuite());
		suite.addTest(CommoditiesTestSuite.getTestSuite());
		return suite;

	}

}
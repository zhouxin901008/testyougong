package lsh123.TestSuites;

import junit.framework.TestSuite;
import lsh123.test.*;

public class CommoditiesTestSuite {
	public static TestSuite getTestSuite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(IndexTest.class);
		suite.addTestSuite(CommodityTest.class);
		return suite;

	}

}

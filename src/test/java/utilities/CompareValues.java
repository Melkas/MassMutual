package utilities;

import java.text.ParseException;

import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class CompareValues {

	public static SoftAssert softAssertion;

	public static boolean compareValueEquality(String expected, String actual, String message) {

		if (expected.equals(actual)) {
			return true;
		} else {
			System.out.println(message);
			return false;

		}

	}

	public static boolean isGreater(String str) {

		double number = ParsCurrency.getDouble(str);
		if (number > 0) {
			return true;
		} else {
		
			return false;
		}

	}
}

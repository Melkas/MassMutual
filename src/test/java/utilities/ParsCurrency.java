package utilities;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParsCurrency {

	public static double getDouble(String value) {

		Locale locale = Locale.US;
		double number = 0;

		try {
			number = NumberFormat.getCurrencyInstance(locale).parse(value).doubleValue();

		} catch (ParseException e) {
			e.getMessage();
	
		}
		return number;
	}
	

}

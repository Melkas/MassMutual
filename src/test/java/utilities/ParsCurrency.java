package utilities;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParsCurrency {
	
	public static double getDouble (String value) throws ParseException {
	   
		   
			 Locale locale = Locale.US;
			 Number number = NumberFormat.getCurrencyInstance(locale).parse(value);
			 
			 return number.doubleValue();
				  
	}
	

		
}
	
	


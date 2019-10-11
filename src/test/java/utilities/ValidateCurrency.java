package utilities;


public class ValidateCurrency {
	
	public static boolean valCurrency (String value) {
		
		char firstchar = value.charAt(0);
		if (firstchar !='$') {
			 return false;
		}
		else {
			value= value.substring(1); 
		}     
		System.out.println(value);
		if(value.matches("([0-9]{1,3}\\,)*[0-9]{1,3}\\.[0-9]{2}")) {
			return true;			
		} 
	    else {
	    	return false;
	    } 
	}
}

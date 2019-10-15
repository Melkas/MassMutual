package utilities;

public class ValidateCurrency {

	public static boolean valCurrency(String value) {

		char firstchar = value.charAt(0);
		char secondchar = value.charAt(1);

		if (firstchar != '$'  && firstchar !='-') {
			return false;
		} else if (firstchar == '-' && secondchar != '$') {
			return false;

		} else if (firstchar == '-' && secondchar == '$') {
			value = value.substring(2);
		} else if (firstchar == '$') {
			value = value.substring(1);
		}

		if (value.matches("([0-9]{1,3}\\,)*[0-9]{1,3}\\.[0-9]{2}")) {
			return true;
		} else {
			return false;
		}
	}
}

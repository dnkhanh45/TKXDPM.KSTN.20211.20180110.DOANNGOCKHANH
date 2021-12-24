package utils;

import java.text.NumberFormat;
import java.util.Locale;


public class CurrencyFormatter {
    public static String getCurrencyFormat(int num) {
		Locale vietname = new Locale("vi", "VN");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(vietname);
		return defaultFormat.format(num);
	}
}

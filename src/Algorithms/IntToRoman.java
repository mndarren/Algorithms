package Algorithms;

/**
 * 
 * @apiSpec Integer to Roman (1 - 3999)
 * @author Darren Zhao Xie
 * @date Apr 4, 2020 Created
 *
 */
public class IntToRoman {
	
	private static final int[] values = {
	    1000, 900, 500, 400,
	    100, 90, 50, 40,
	    10, 9, 5, 4,
	    1
	};

	private static final String[] symbol = {
	    "M", "CM", "D", "CD",
	    "C", "XC", "L", "XL",
	    "X", "IX", "V", "IV",
	    "I"
	};
	
	// integer converted to Roman
	public String intToRoman(int num) {
		int i = 0, n = num;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			while (n / values[i] > 0) {
				sb.append(symbol[i]);
				n -= values[i];
			}
			i++;
		}
		return sb.toString();
	}

}

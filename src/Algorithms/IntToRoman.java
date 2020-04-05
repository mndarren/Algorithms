package Algorithms;

import java.util.Map;
import java.util.HashMap;

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
	
	private static final Map<String, Integer> map = new HashMap<String, Integer>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("M", 1000);
			put("D", 500);
			put("C", 100);
			put("L", 50);
			put("X", 10);
			put("V", 5);
			put("I", 1);
		}
	};
	
	// integer converted to Roman, Time ~ O(N), Space ~ O(1)
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
	
	// Roman converted to integer
	public int romanToInt(String s) {
		int num = 0, prev = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int curr = map.get(s.substring(i, i + 1));
	        num += (curr > prev) ? (curr - 2 * prev) : curr;    // use subtractive rule
	        prev = curr;
	    }
	    return num;
	}

}

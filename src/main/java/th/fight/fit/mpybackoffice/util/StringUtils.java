package th.fight.fit.mpybackoffice.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringUtils {

	public static String leftPad(String str, char charReplace, int totalLength) {
		if (str != null) {
			int strSize = totalLength - str.length();

			String value = pad(charReplace, strSize);
			value = value + str;

			return value;
		}
		return null;
	}

	public static String rightPad(String str, char charReplace, int totalLength) {
		if (str != null) {
			int strSize = totalLength - str.length();

			String value = pad(charReplace, strSize);
			value = str + value;

			return value;
		}
		return null;
	}

	public static String pad(char p_ch, int p_len) {
		if (p_len > 0) {
			char c[] = new char[p_len];
			for (int i = 0; i < p_len; i++) {
				c[i] = p_ch;
			}
			return String.valueOf(c);
		} else {
			return "";
		}
	}


	public static boolean isNotEmptyOrNull(String str) {

		if ( null == str || "".equals(str.trim()) || str.trim().length()==0 || "null".equalsIgnoreCase(str)) {
            return false;
        } else {
            return true;
        }

	}

	public static boolean isEmptyOrNull(String str) {
		return (str == null || "".equals(str.trim()) || str.trim().length() == 0) ? true : false;
	}


	public static synchronized List<String> convertArrayToList(String[] array) throws Exception {
    	return new ArrayList<String>(Arrays.asList(array));
    }

    public static synchronized  String[] convertListToArray(List<String> listT) throws Exception {
    	return (String[])listT.toArray(new String[listT.size()]);
    }

    public static String genRandomNumberString(int len){
		char[] chars = "1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < len; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}
    
}
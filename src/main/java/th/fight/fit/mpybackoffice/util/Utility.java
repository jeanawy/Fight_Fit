// ******************************COPYRIGHT NOTICE*******************************
// All rights reserved.  This material is confidential and proprietary to Modernform
// Enterprise Computing Plc. (MFEC) and no part of this material should be reproduced,
// published in any form by any means, electronic or mechanical including photocopy
// or any information storage or retrieval system nor should the material be disclosed
// to third parties without the express written authorization of
// Modernform Enterprise Computing Plc. (MFEC).

/**
 *
 */
package th.fight.fit.mpybackoffice.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;

/**
 * The Utility class is a general utility.
 * @author anuchard.a
 *
 */
public class Utility {


    public static boolean isListNotNullAndEmpty(List<?> lstObj) {
    	if (lstObj == null){
			// If an other Object is not null return true
			return false;
		}
    	if( lstObj.size() == 0 ){
    		return false;
		}
    	return true;
    }

    public static boolean isEmptyOrNull(Object obj) {
		if (obj == null){
			// If an other Object is not null return true
			return true;
		}
		if (obj instanceof String) {
			if (obj.toString().trim().length() == 0)
				return true;
		}else if (obj instanceof Integer) {
			if (obj.toString().trim().length() == 0)
				return true;
		} else if (obj instanceof Long) {
			if (obj.toString().trim().length() == 0)
				return true;
		} else if (obj instanceof Double) {
			if (obj.toString().trim().length() == 0)
				return true;
		}else if (obj instanceof BigDecimal) {
			if (obj.toString().trim().length() == 0)
				return true;
		}

		return false;
	}


    public static String printStackTraceToDB(Throwable e){
    	StringBuffer str = new StringBuffer();
    	if(e != null){
    		StackTraceElement elements[] = e.getStackTrace();
    		String eMsg = e.toString();
			if (eMsg.length() > 1500) eMsg = eMsg.substring(0, 1500);
    		if (elements != null && elements.length != 0){
				str.append(eMsg);
				str.append(" at ");
				str.append(elements[0].getClassName()+"("+ elements[0].getMethodName()+":"+elements[0].getLineNumber()+")");
    		}else{
				str.append(eMsg);
			}

    		if (e.getCause()!=null){
        		//StackTraceElement elements[] = e.getCause().getStackTrace();
        		String eCauseMsg = e.getCause().toString();
    			if (eCauseMsg.length() > 1500) eCauseMsg = eCauseMsg.substring(0, 1500);
        		if (elements != null && elements.length != 0){
    				str.append(eCauseMsg);
    				str.append(" at ");
    				str.append(elements[0].getClassName()+"("+ elements[0].getMethodName()+":"+elements[0].getLineNumber()+")");

        		}else{
        			str.append(eCauseMsg);
        		}
        	}
    	}

    	return str.toString();
    }

    public static String printStackTraceToLog(Throwable e){
		StringBuffer str = new StringBuffer();
		if(e != null){
			StackTraceElement elements[] = e.getStackTrace();
			if (elements != null && elements.length != 0){
				str.append(e.toString());
				for (int i=0, n=elements.length; i<n; i++) {
					if(i!=0)
						str.append(",");
					str.append(" at ");
					str.append(elements[i].getClassName()+" ("+ elements[i].getMethodName()+":"+elements[i].getLineNumber()+")");
				}
			}else{
				str.append(e.toString());
			}

			if (e.getCause()!=null){
				StackTraceElement elements2[] = e.getCause().getStackTrace();
				if (elements2 != null && elements2.length != 0){
						str.append(" Caused by: ");
						str.append(e.getCause().toString());
						str.append(" at ");
						for (int i=0; i<elements2.length; i++) {
							if(i!=0)
								str.append(",");
							str.append(" at ");
							str.append(elements2[i].getClassName()+"("+ elements2[i].getMethodName()+":"+elements2[i].getLineNumber()+")");
						}
				}else{
					str.append(e.getCause().toString());
				}
			}
		}
    	return str.toString();
    }



    /**
	* Returns a encodes String object representing the specified string.
 	*
	* @param s a String.
	* @return a encodes String if the argument is null then return "".
	*/
    public static String getISOStr(String s)
    {
        String output = s;
        if(output == null) return "";
        try
        {
            output = new String(s.getBytes("TIS-620"));
        }
        catch(UnsupportedEncodingException e)
        {
            output = s;
        }
        return output;
    }


    /**
	* Returns a encodes String object representing the specified string.
 	*
	* @param s a String.
	* @return a encodes String if the argument is null then return "".
	*/
    public static String getUTF8Str(String s)
    {
        String output = s;
        if(output == null) return "";
        try
        {
            output = new String(s.getBytes("UTF-8"));
        }
        catch(UnsupportedEncodingException e)
        {
            output = s;
        }
        return output;
    }


    //change thai language
    public static String changeThailanguage(String input){
	    String output = input;
		if(output == null) return "";
		try{
			output = new String(input.getBytes("ISO-8859-1"),"TIS-620");
		}
		catch(UnsupportedEncodingException e){
		    output = input;
		}

		return output;
    }

    public static String convertToThailanguageUTF8(String word) throws Exception{
		if( null!=word && !"".equalsIgnoreCase(word) ){
			return new String(word.getBytes("ISO-8859-1"),"UTF-8");
		}else{
			return null;
		}
	}

    public static void splitStringToArrayList(String strToSplit, String delimitor, List<String> listString) throws Exception {
		//List list = new ArrayList();
		String[] arrStr = null;
		try{
			arrStr = strToSplit.split(delimitor);
			int arrStrLength = arrStr.length;
			for(int i=0; i<arrStrLength; i++) {
				listString.add(arrStr[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		arrStr = null;
	}

    public static Locale getLocale(String language){
    	if(ProjectConstant.LANGUAGE_EN.equalsIgnoreCase(language))
    		return Locale.ENGLISH;
    	else if(ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(language))
    		return new Locale("th", "TH");
    	else
    		return new Locale(language);
    	
    }

    public static boolean equalString(String str1, String str2){
    	boolean equal = false;

    	if(StringUtils.isEmptyOrNull(str1))
    		str1 = null;
    	
    	if(StringUtils.isEmptyOrNull(str2))
    		str2 = null;
    	
    	if(str1 == null){
    		if(str2 == null)
    			equal = true;
    		
    	}else if(str1.equals(str2)){
    		equal = true;
    		
    	}

    	return equal;
    }
    
    public static boolean equalBigInteger(BigInteger bigInt1, BigInteger bigInt2){
    	boolean equal = false;
    	
    	if(bigInt1 == null){
    		if(bigInt2 == null)
    			equal = true;
    		
    	}else if(bigInt1.equals(bigInt2)){
    		equal = true;
    		
    	}
    	
    	return equal;
    	
    }
    
    public static boolean equalDate(Date date1, Date date2){
    	boolean equal = false;
    	
    	if(date1 == null){
    		if(date2 == null)
    			equal = true;
    		
    	}else if(date1.compareTo(date2) == 0){
    		equal = true;
    		
    	}
    	
    	return equal;
    }
 
    
    /*
     * Paramterized method to sort Map e.g. HashMap or Hashtable in Java
     * throw NullPointerException if Map contains null key
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortByKeys(Map<K,V> map){
        List<K> keys = new LinkedList<K>(map.keySet());
        Collections.sort(keys);
      
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
        for(K key: keys){
            sortedMap.put(key, map.get(key));
        }
      
        return sortedMap;
    }
    
    
    /*
     * Java method to sort Map in Java by value e.g. HashMap or Hashtable
     * throw NullPointerException if Map contains null values
     * It also sort values even if they are duplicates
     */
    @SuppressWarnings("rawtypes")
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
      
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

            @SuppressWarnings("unchecked")
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
      
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
      
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
      
        return sortedMap;
    }

}


package th.fight.fit.mpybackoffice.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;

public class DateUtil {

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String TIME_PATTERN = "HH:mm";
    public static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm";
    public static final String DATETIME_PATTERN_SECOND = "dd/MM/yyyy HH:mm:ss";
    public static final String DATETIME_PATTERNFORDB2 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATETIME_PATTERNFORDB2_2 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERNFORDB2 = "yyyy-MM-dd";
//    public static final String DATE_PATTERN_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public static final Locale DEFAULT_LOCALE = new Locale("th", "TH");
    public static final Locale ENGLISH_LOCALE = new Locale("en", "EN");

    public static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_PATTERN);

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN, DEFAULT_LOCALE);

        return format.format(date);
    }

    public static String formatDateForTime(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(TIME_PATTERN, ENGLISH_LOCALE);
        return format.format(date);
    }

    public static String formatDate(Date date, Locale locale) {
        if (date == null) {
            return null;
        }

        if (locale == null) {
            locale = DEFAULT_LOCALE;
        }

        SimpleDateFormat format = null;

        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(locale.getLanguage())) {
            format = new SimpleDateFormat(DATE_PATTERN, DEFAULT_LOCALE);
        } else {
            format = new SimpleDateFormat(DATE_PATTERN, locale);
        }

        return format.format(date);
    }

    public static String formatDateTime(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERN, DEFAULT_LOCALE);

        return format.format(date);
    }

    public static String formatDateTimeEN(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERN, ENGLISH_LOCALE);

        return format.format(date);
    }

    public static String formatDateTimeSecond(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERN_SECOND, DEFAULT_LOCALE);

        return format.format(date);
    }

    public static String formatDateTimeForDB2(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERNFORDB2, ENGLISH_LOCALE);
        return format.format(date);
    }

    public static String formatDateTimeForDB2_2(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(DATETIME_PATTERNFORDB2_2, ENGLISH_LOCALE);
        return format.format(date);
    }

    public static String formatDateForDB2(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERNFORDB2, ENGLISH_LOCALE);
        return format.format(date);
    }

    public static String formatDateTime(Date date, Locale locale) {
        if (date == null) {
            return null;
        }

        if (locale == null) {
            locale = DEFAULT_LOCALE;
        }

        SimpleDateFormat format = null;

        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(locale.getLanguage())) {
            format = new SimpleDateFormat(DATETIME_PATTERN, DEFAULT_LOCALE);
        } else {
            format = new SimpleDateFormat(DATETIME_PATTERN, locale);
        }

        return format.format(date);
    }

    public static String formatDateTimeSecond(Date date, Locale locale) {
        if (date == null) {
            return null;
        }

        if (locale == null) {
            locale = DEFAULT_LOCALE;
        }

        SimpleDateFormat format = null;

        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(locale.getLanguage())) {
            format = new SimpleDateFormat(DATETIME_PATTERN_SECOND, DEFAULT_LOCALE);
        } else {
            format = new SimpleDateFormat(DATETIME_PATTERN_SECOND, locale);
        }

        return format.format(date);
    }

    public static String formatDateForHeader(Date date, Locale locale) {
        if (date == null) {
            return null;
        }

        if (locale == null) {
            locale = DEFAULT_LOCALE;
        }

        SimpleDateFormat format = null;

        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(locale.getLanguage())) {
            format = new SimpleDateFormat(DATE_PATTERN, DEFAULT_LOCALE);
        } else {
            format = new SimpleDateFormat(DATE_PATTERN, locale);
        }

        String dateStr = format.format(date);

        String day = dateStr.split("[/]")[0];
        String month = null;
        String monthNumber = dateStr.split("[/]")[1];
        String year = dateStr.split("[/]")[2];

        if (ProjectConstant.LANGUAGE_TH.equalsIgnoreCase(locale.getLanguage())) {
            if ("01".equals(monthNumber)) {
                month = "\u0E21.\u0E04.";
            } else if ("02".equals(monthNumber)) {
                month = "\u0E01.\u0E1E.";
            } else if ("03".equals(monthNumber)) {
                month = "\u0E21\u0E35.\u0E04.";
            } else if ("04".equals(monthNumber)) {
                month = "\u0E40\u0E21.\u0E22";
            } else if ("05".equals(monthNumber)) {
                month = "\u0E1E.\u0E04.";
            } else if ("06".equals(monthNumber)) {
                month = "\u0E21\u0E34.\u0E22.";
            } else if ("07".equals(monthNumber)) {
                month = "\u0E01.\u0E04.";
            } else if ("08".equals(monthNumber)) {
                month = "\u0E2A.\u0E04.";
            } else if ("09".equals(monthNumber)) {
                month = "\u0E01.\u0E22.";
            } else if ("10".equals(monthNumber)) {
                month = "\u0E15.\u0E04.";
            } else if ("11".equals(monthNumber)) {
                month = "\u0E1E.\u0E22.";
            } else if ("12".equals(monthNumber)) {
                month = "\u0E18.\u0E04.";
            }

        } else {
            if ("01".equals(monthNumber)) {
                month = "Jan";
            } else if ("02".equals(monthNumber)) {
                month = "Feb";
            } else if ("03".equals(monthNumber)) {
                month = "Mar";
            } else if ("04".equals(monthNumber)) {
                month = "Apr";
            } else if ("05".equals(monthNumber)) {
                month = "May";
            } else if ("06".equals(monthNumber)) {
                month = "Jun";
            } else if ("07".equals(monthNumber)) {
                month = "Jul";
            } else if ("08".equals(monthNumber)) {
                month = "Aug";
            } else if ("09".equals(monthNumber)) {
                month = "Sep";
            } else if ("10".equals(monthNumber)) {
                month = "Oct";
            } else if ("11".equals(monthNumber)) {
                month = "Nov";
            } else if ("12".equals(monthNumber)) {
                month = "Dec";
            }

        }

        return Integer.parseInt(day) + " " + month + " " + year;
    }

    public static String formatTime(Date date) {
        if (date == null) {
            return null;
        }

        return timeFormat.format(date);

    }

//    public static Date parseForTimeZone(String dateBE) throws Exception {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_TIMEZONE, DEFAULT_LOCALE);
//
//        return dateFormat.parse(dateBE);
//
//    }
    public static XMLGregorianCalendar parseToXMLGregorianCalendar(Date dateBE) throws Exception {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN, DEFAULT_LOCALE);

        XMLGregorianCalendar xmlDate = null;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dateBE);

        return xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

    }
    public static Date parseForBEMinEN(String dateBE) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_PATTERN, ENGLISH_LOCALE);

        return dateFormat.parse(dateBE);

    }

    public static Date parseForBE(String dateBE) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN, DEFAULT_LOCALE);

        return dateFormat.parse(dateBE);

    }

    public static Date parseForBEMin(String dateBE) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_PATTERN, DEFAULT_LOCALE);

        return dateFormat.parse(dateBE);

    }

    public static Date parseForAD(String dateAD) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN, ENGLISH_LOCALE);

        return dateFormat.parse(dateAD);

    }

    public static Date parseForADMin(String dateAD) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_PATTERN, ENGLISH_LOCALE);

        return dateFormat.parse(dateAD);

    }

    public static boolean isParseForAD(String dateAD) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN, ENGLISH_LOCALE);
        boolean isParseForADFlag;
        try {
            dateFormat.parse(dateAD);
            isParseForADFlag = true;
        } catch (Exception e) {
            isParseForADFlag = false;
        }
        return isParseForADFlag;

    }

    public static Date parseDateTimeForAD(String dateAD) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERNFORDB2, ENGLISH_LOCALE);

        return dateFormat.parse(dateAD);

    }

    public static Date parseForAD(String dateAD, String format) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, ENGLISH_LOCALE);

        return dateFormat.parse(dateAD);

    }

    public static int compareDateTime(String date1Str, String date2Str) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_PATTERN, ENGLISH_LOCALE);
        Date date1 = dateFormat.parse(date1Str);
        Date date2 = dateFormat.parse(date2Str);

        return date1.compareTo(date2);
    }

    public static int compareDateOnly(String date1Str, String date2Str) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN, ENGLISH_LOCALE);
        Date date1 = dateFormat.parse(date1Str);
        Date date2 = dateFormat.parse(date2Str);

        return date1.compareTo(date2);
    }

    /*public static void main(String[] args) throws Exception {
		System.out.println(formatDateForHeader(new Date(), new Locale("th","TH")));
		System.out.println(formatDateForHeader(new Date(), new Locale("en","EN")));
		
		String beDateStr = "22/05/2558";
		System.out.println(parseForBE(beDateStr));
		
		String adDateStr = "22/05/2015";
		System.out.println(parseForAD(adDateStr));
		
	}*/
    public static String formatMonth(String monthNumber, String language) {

        String month = "";
        if (language.equals(ProjectConstant.LANGUAGE_TH)) {
            if ("01".equals(monthNumber) || "1".equals(monthNumber)) {
                month = "\u0E21\u0E01\u0E23\u0E32\u0E04\u0E21";
            } else if ("02".equals(monthNumber) || "2".equals(monthNumber)) {
                month = "\u0E01\u0E38\u0E21\u0E20\u0E32\u0E1E\u0E31\u0E19\u0E18\u0E4C";
            } else if ("03".equals(monthNumber) || "3".equals(monthNumber)) {
                month = "\u0E21\u0E35\u0E19\u0E32\u0E04\u0E21";
            } else if ("04".equals(monthNumber) || "4".equals(monthNumber)) {
                month = "\u0E40\u0E21\u0E29\u0E32\u0E22\u0E19";
            } else if ("05".equals(monthNumber) || "5".equals(monthNumber)) {
                month = "\u0E1E\u0E24\u0E29\u0E20\u0E32\u0E04\u0E21";
            } else if ("06".equals(monthNumber) || "6".equals(monthNumber)) {
                month = "\u0E21\u0E34\u0E16\u0E38\u0E19\u0E32\u0E22\u0E19";
            } else if ("07".equals(monthNumber) || "7".equals(monthNumber)) {
                month = "\u0E01\u0E23\u0E01\u0E0E\u0E32\u0E04\u0E21";
            } else if ("08".equals(monthNumber) || "8".equals(monthNumber)) {
                month = "\u0E2A\u0E34\u0E07\u0E2B\u0E32\u0E04\u0E21";
            } else if ("09".equals(monthNumber) || "9".equals(monthNumber)) {
                month = "\u0E01\u0E31\u0E19\u0E22\u0E32\u0E22\u0E19";
            } else if ("10".equals(monthNumber) || "10".equals(monthNumber)) {
                month = "\u0E15\u0E38\u0E25\u0E32\u0E04\u0E21";
            } else if ("11".equals(monthNumber) || "11".equals(monthNumber)) {
                month = "\u0E1E\u0E24\u0E28\u0E08\u0E34\u0E01\u0E32\u0E22\u0E19";
            } else if ("12".equals(monthNumber) || "12".equals(monthNumber)) {
                month = "\u0E18\u0E31\u0E19\u0E27\u0E32\u0E04\u0E21";
            }
        } else {
            if ("01".equals(monthNumber) || "1".equals(monthNumber)) {
                month = "January";
            } else if ("02".equals(monthNumber) || "2".equals(monthNumber)) {
                month = "February";
            } else if ("03".equals(monthNumber) || "3".equals(monthNumber)) {
                month = "March";
            } else if ("04".equals(monthNumber) || "4".equals(monthNumber)) {
                month = "April";
            } else if ("05".equals(monthNumber) || "5".equals(monthNumber)) {
                month = "May";
            } else if ("06".equals(monthNumber) || "6".equals(monthNumber)) {
                month = "June";
            } else if ("07".equals(monthNumber) || "7".equals(monthNumber)) {
                month = "July";
            } else if ("08".equals(monthNumber) || "8".equals(monthNumber)) {
                month = "August";
            } else if ("09".equals(monthNumber) || "9".equals(monthNumber)) {
                month = "September";
            } else if ("10".equals(monthNumber) || "10".equals(monthNumber)) {
                month = "October";
            } else if ("11".equals(monthNumber) || "11".equals(monthNumber)) {
                month = "November";
            } else if ("12".equals(monthNumber) || "12".equals(monthNumber)) {
                month = "December";
            }
        }

        return month;
    }

    public static void main(String[] args) throws Exception {

        Date date = new Date();
//        XMLGregorianCalendar xmlDate = null;
//        GregorianCalendar gc = new GregorianCalendar();
//
//        gc.setTime(date);
//
//        try {
//            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("XMLGregorianCalendar : " + parseToXMLGregorianCalendar(date));
//        Date currentDate = new Date();
////        System.out.println(formatDateForHeader(new Date(), new Locale("th", "TH")));
////        System.out.println(formatDateForHeader(new Date(), new Locale("en", "EN")));
////
//        String beDateStr = "2017-10-09 15:10:10.000";
//        Date beDate = parseForTimeZone(beDateStr);
//        System.out.println("Date : " + beDate);
////        System.out.println("beDate : " + DATE_PATTERN_YYYYMMDDHHMMSS(beDate, DEFAULT_LOCALE));
//
////        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmm", ENGLISH_LOCALE);
////
////        System.out.println("Date format : " + format.format(currentDate));
//        String test = "helloworld";
//        System.out.println("String last 3 char");

    }
}

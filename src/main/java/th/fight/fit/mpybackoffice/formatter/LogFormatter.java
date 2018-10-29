package th.fight.fit.mpybackoffice.formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.exception.BusinessProcessException;

public class LogFormatter {

	private static final String INPUT = "INPUT";
    private static final String OUTPUT = "OUTPUT";
    private static final String COMMON = "COMMON";
    private static final String BEGIN = "BEGIN";
    private static final String END = "END";
    private static final String START_CALL_SERVICE = "START CALL ";
    private static final String END_CALL_SERVICE = "END CALL ";
    private static final String sFlag = "<";
    private static final String eFlag = ">";
    private static final String separateFlag = "####################";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    public static String input(String refID, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(INPUT);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String input(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(INPUT);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String output(String refID, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(OUTPUT);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String output(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(OUTPUT);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }
    
    public static String common(String refID, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(COMMON);
        sb.append(eFlag);
        sb.append(" ");

        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String info(String refID, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");

        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }
    
    public static String info(String refID, String username, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(", ");
        sb.append("username=");
        sb.append(username == null ? "" : username);
        sb.append(eFlag);
        sb.append(" ");

        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String info( Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String common(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(COMMON);
        sb.append(eFlag);
        sb.append(" ");

        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String error(String refID, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");

        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        
        //Print stack trace log
        printStackTrace(refID, obj);
        
        return sb.toString();
    }

    public static String error(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(obj == null ? "" : obj.toString());
        sb.append(eFlag);
        
        //Print stack trace log
        printStackTrace(obj);
        
        return sb.toString();
    }

    public static String separate(String refID, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(separateFlag);
        sb.append(" ");
        sb.append(obj == null ? "" : obj.toString());
        sb.append(" ");
        sb.append(separateFlag);
        sb.append(eFlag);
        return sb.toString();
    }

    public static String separate(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(separateFlag);
        sb.append(" ");
        sb.append(obj == null ? "" : obj.toString());
        sb.append(" ");
        sb.append(separateFlag);
        sb.append(eFlag);
        return sb.toString();
    }

    public static String beginModule(String refID, String moduleName) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(separateFlag);
        sb.append(" [");
        sb.append(BEGIN);
        sb.append("] ");
        sb.append(" ");
        sb.append(moduleName == null ? "" : moduleName);
        sb.append(" ");
        sb.append(separateFlag);
        sb.append(eFlag);
        return sb.toString();
    }

    public static String beginModule(String moduleName) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(separateFlag);
        sb.append(" [");
        sb.append(BEGIN);
        sb.append("] ");
        sb.append(" ");
        sb.append(moduleName == null ? "" : moduleName);
        sb.append(" ");
        sb.append(separateFlag);
        sb.append(eFlag);
        return sb.toString();
    }

    public static String endModule(String refID, String moduleName) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(separateFlag);
        sb.append(" [");
        sb.append(END);
        sb.append("] ");
        sb.append(moduleName == null ? "" : moduleName);
        sb.append(" ");
        sb.append(separateFlag);
        sb.append(eFlag);
        return sb.toString();
    }

    public static String endModule(String moduleName) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(separateFlag);
        sb.append(" [");
        sb.append(END);
        sb.append("] ");
        sb.append(moduleName == null ? "" : moduleName);
        sb.append(" ");
        sb.append(separateFlag);
        sb.append(eFlag);
        return sb.toString();
    }

    public static String startCallService(String refID, String serviceName, Object input) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(START_CALL_SERVICE);
        sb.append(serviceName);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(INPUT);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(input == null ? "" : input.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String startCallService(String serviceName, Object input) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(START_CALL_SERVICE);
        sb.append(serviceName);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(INPUT);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(input == null ? "" : input.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String endCallService(String refID, String serviceName, Object output) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(END_CALL_SERVICE);
        sb.append(serviceName);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(OUTPUT);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(output == null ? "" : output.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String endCallService(String serviceName, Object output) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        sb.append(END_CALL_SERVICE);
        sb.append(serviceName);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(OUTPUT);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append(output == null ? "" : output.toString());
        sb.append(eFlag);
        return sb.toString();
    }

    public static String accessLog(Date startDate, Date endDate, String refID, String result, Object input, Object output) {
        StringBuilder sb = new StringBuilder();

        // result
        sb.append(sFlag);
        sb.append(result == null ? "" : result);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(", ");
        //Time
        sb.append(dateFormat.format(startDate));
        sb.append(", ");
        sb.append(dateFormat.format(endDate));
        sb.append(", ");
        sb.append((endDate.getTime() - startDate.getTime()));
        sb.append(eFlag);
        sb.append(" ");

        // Resquest
        sb.append(sFlag);
        sb.append(input == null ? "" : input.toString());
        sb.append(eFlag);
        sb.append(" ");
        // Response
        sb.append(sFlag);
        sb.append(output == null ? "" : output.toString());
        sb.append(eFlag);

        return sb.toString();
    }
    
    public static String accessLog(Date startDate, Date endDate, String refID, String username, String result, Object input, Object output) {
        StringBuilder sb = new StringBuilder();

        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(", ");
        sb.append("username=");
        sb.append(username == null ? "" : username);
        sb.append(", ");
        //Time
        sb.append(dateFormat.format(startDate));
        sb.append(", ");
        sb.append(dateFormat.format(endDate));
        sb.append(", ");
        sb.append((endDate.getTime() - startDate.getTime()));
        sb.append(eFlag);
        sb.append(" ");

        // Resquest
        sb.append(sFlag);
        sb.append(input == null ? "" : input.toString());
        sb.append(eFlag);
        sb.append(" ");
        // Response
        sb.append(sFlag);
        sb.append(output == null ? "" : output.toString());
        sb.append(eFlag);
        sb.append(" ");
        
        // result
        sb.append(sFlag);
        sb.append(result == null ? "" : result);
        sb.append(eFlag);
        
        return sb.toString();
    }
    
    public static String accessLog(Date startDate, Date endDate, long serviceTime,String refID, String result) {
        StringBuilder sb = new StringBuilder();

        // result
        sb.append(sFlag);
        sb.append(result == null ? "" : result);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(", ");
        //Time
        sb.append(dateFormat.format(startDate));
        sb.append(", ");
        sb.append(dateFormat.format(endDate));
        sb.append(", ");
        sb.append(serviceTime);
        sb.append(" (ms)");
        sb.append(eFlag);

        return sb.toString();
    }

    public static String businessLog(String[] refID, Date startDate, Date endDate) {
        StringBuilder sb = new StringBuilder();

        // result
        sb.append(sFlag);
        // Reference ID
        sb.append(refID == null ? "" : StringUtils.join(refID, ", "));
        sb.append(eFlag);
        sb.append(" ");

        //Time
        sb.append(sFlag);
        sb.append(dateFormat.format(startDate));
        sb.append(", ");
        sb.append(dateFormat.format(endDate));
        sb.append(", ");
        sb.append((endDate.getTime() - startDate.getTime()));
        sb.append(eFlag);
        sb.append(" ");

        return sb.toString();
    }
    
    public static String callServiceTime(String refID, Date startDate,Date endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append("Call service time is :");
        sb.append(endDate.getTime() - startDate.getTime());
        sb.append(" (ms)");
        sb.append(eFlag);
        return sb.toString();
    }

    public static String callServiceTime(String refID, String username, Date startDate,Date endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append(sFlag);
        // Reference ID
        sb.append("refID=");
        sb.append(refID == null ? "" : refID);
        sb.append(",");
        sb.append("username=");
        sb.append(username);
        sb.append(eFlag);
        sb.append(" ");
        sb.append(sFlag);
        sb.append("Call service time is :");
        sb.append(endDate.getTime() - startDate.getTime());
        sb.append(" (ms)");
        sb.append(eFlag);
        return sb.toString();
    }
    
    public static String logFmtEmail (String email) {
        String [] emailArr = null;
        String fmtEmail = null;
        try {
            if (email == null || "".equals(email)) {
                return "";
            }

            emailArr = email.split("[@.]");

            if (emailArr.length > 1) {
                fmtEmail = emailArr[0].substring(0, (emailArr[0].length() - 1)) + "*@" + emailArr[1] + "." + emailArr[2];
            }

        } catch (Exception e) {
            errorLogger.error(LogFormatter.error(e));
        }
        return fmtEmail;
    }

    public static String logFmtMobileNo (String mobileNo) {
        String fmtMobileNo = null;
        try {
            if (mobileNo == null || "".equals(mobileNo)) {
                return "";
            }

            fmtMobileNo = mobileNo.substring(0, (mobileNo.length() - 2)) + "**";

        } catch (Exception e) {
            errorLogger.error(LogFormatter.error(e));
        }
        return fmtMobileNo;
    }
    
    public static String printStackTraceToLog(Throwable e) {
        StringBuilder str = new StringBuilder();
        if (e != null) {
            StackTraceElement elements[] = e.getStackTrace();
            if (elements != null && elements.length > 0) {
                str.append(e.toString());
                for (int i = 0, n = elements.length; i < n; i++) {
                    str.append(" at ");
                    str.append(elements[i].getClassName() + " (" + elements[i].getMethodName() + ":" + elements[i].getLineNumber() + ")\n");
                }
            } else {
                str.append(e.toString());
            }

            if (e.getCause() != null) {
                StackTraceElement elements2[] = e.getCause().getStackTrace();
                if (elements2 != null && elements2.length != 0) {
                    str.append(" Caused by: ");
                    str.append(e.getCause().toString());
                    str.append(" at ");
                    for (int i = 0; i < elements2.length; i++) {
                        str.append(" at ");
                        str.append(elements2[i].getClassName() + "(" + elements2[i].getMethodName() + ":" + elements2[i].getLineNumber() + ")\n");
                    }
                } else {
                    str.append(e.getCause().toString());
                }
            }
        }
        return str.toString();
    }

    public static String printStackTraceToLog(String refID,Throwable e) {
        StringBuilder str = new StringBuilder();
        if (e != null) {
            StackTraceElement elements[] = e.getStackTrace();
            if (elements != null && elements.length > 0) {
                str.append("<refID=").append(refID).append(">");
                str.append(e.toString());
                for (int i = 0, n = elements.length; i < n; i++) {
                    str.append(" at ");
                    str.append(elements[i].getClassName() + " (" + elements[i].getMethodName() + ":" + elements[i].getLineNumber() + ")\n");
                }
            } else {
                str.append(e.toString());
            }

            if (e.getCause() != null) {
                StackTraceElement elements2[] = e.getCause().getStackTrace();
                if (elements2 != null && elements2.length != 0) {
                    str.append(" Caused by: ");
                    str.append(e.getCause().toString());
                    str.append(" at ");
                    for (int i = 0; i < elements2.length; i++) {
                        str.append(" at ");
                        str.append(elements2[i].getClassName() + "(" + elements2[i].getMethodName() + ":" + elements2[i].getLineNumber() + ")\n");
                    }
                } else {
                    str.append(e.getCause().toString());
                }
            }
        }
        return str.toString();
    }
    
    private static void printStackTrace (Object obj) {
        Exception ex = null;
        try {
            if (obj != null && !(obj instanceof String)) {
                ex = (Exception) obj;

                if (!(ex instanceof BusinessProcessException)) {
                    errorLogger.error(printStackTraceToLog(ex));
                }
            }  
        } catch (Exception e) {
            errorLogger.error(LogFormatter.error(e));
        }
    }
    
    private static void printStackTrace (String refID, Object obj) {
        Exception ex = null;
        try {
            if (obj != null && !(obj instanceof String)) {
                ex = (Exception) obj;

                if (!(ex instanceof BusinessProcessException)) {
                    errorLogger.error(printStackTraceToLog(refID, ex));
                }
            }        
        } catch (Exception e) {
            errorLogger.error(LogFormatter.error(e));
        }
    }
	
}

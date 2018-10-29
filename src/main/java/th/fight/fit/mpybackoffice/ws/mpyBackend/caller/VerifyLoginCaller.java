/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.ws.mpyBackend.caller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.util.StringUtils;
import th.fight.fit.mpybackoffice.util.Utility;
import th.fight.fit.mpybackoffice.ws.mpyBackend.vo.VerifyLoginRequestVO;
import th.fight.fit.mpybackoffice.ws.mpyBackend.vo.VerifyLoginResponseVO;

/**
 *
 * @author Anuwat_K
 */
@Component
public class VerifyLoginCaller {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private final String CALL_SERVICE_VERIFY_LOGIN_HEADER = "verifyLoginHeader";
    private final String CALL_SERVICE_VERIFY_LOGIN = "verifyLogin";

    @Autowired
    private MessageSource messageSource;

    public VerifyLoginResponseVO verifyLogin(VerifyLoginRequestVO requestBody) throws Exception {
        VerifyLoginResponseVO resultData = new VerifyLoginResponseVO();
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            Gson gson = new Gson();
//            String requestHeaderMsg = gson.toJson(requestHeader, FinancialServiceBaseRequestHeaderVO.class);
            String messageRequest = gson.toJson(requestBody, VerifyLoginRequestVO.class);
            systemLogger.info(LogFormatter.startCallService(null, CALL_SERVICE_VERIFY_LOGIN, messageRequest));
            String urlStr = messageSource.getMessage(ProjectConstant.WS_CALL_MPY_BACKEND_VERIFY_LOGIN_URL, null, null);

            result = callService(urlStr, messageRequest, ProjectConstant.REQUEST_METHOD_TYPE_POST);
            systemLogger.info(LogFormatter.info("- verifyLogin Response=" + result.get("body")));

            if (result.get("body") != null) {
                systemLogger.info(LogFormatter.endCallService(null, CALL_SERVICE_VERIFY_LOGIN, result.get("body").toString()));

                JsonElement jsonElement = gson.fromJson(result.get("body").toString(), JsonElement.class);
                JsonObject originalObj = jsonElement.getAsJsonObject();
                systemLogger.info("- originalObj " + originalObj.toString());
                resultData = gson.fromJson(originalObj, VerifyLoginResponseVO.class);
            }

        } catch (Exception e) {
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            e.printStackTrace();
            throw e;
        }
        return resultData;
    }

    private Map<String, Object> callService(String urlStr, String messageRequest, String methodType) {
        String connectionTimeout = messageSource.getMessage(ProjectConstant.WS_CONNECTION_TIMEOUT, null, null);
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(methodType);
            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setRequestProperty("rqUserId", fsbrhvo.getRqUserId());

            systemLogger.info(LogFormatter.info("- URLConnection Property : " + conn.toString()));

            if (StringUtils.isNotEmptyOrNull(connectionTimeout)) {
                conn.setConnectTimeout(Integer.parseInt(connectionTimeout));
            }

            conn.setDoOutput(true);
            conn.setUseCaches(false);

            if (methodType.equalsIgnoreCase("POST")) {
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                dos.write(messageRequest.getBytes(ProjectConstant.CHARSET_UTF_8));
                dos.flush();
            }

            //get Header
//            headerObj.setRsAppId(conn.getHeaderField("rsAppId"));
            //get content
            InputStream inputStram = conn.getInputStream();
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStram, "UTF-8"));
            StringBuffer resultStr = new StringBuffer();

            String line = null;
            while ((line = bufferReader.readLine()) != null) {
                resultStr.append(line);
            }

            bufferReader.close();

//            result.put("header", headerObj);
            result.put("body", resultStr.toString());

        } catch (Exception e) {
//            result.put("errorCode", ProjectConstant.ERROR_CODE_EXTERNAL_CONNECTION_EXCEPTION);
            errorLogger.error(LogFormatter.error(Utility.printStackTraceToLog(e)));
            e.printStackTrace();
        }
        return result;
    }

}

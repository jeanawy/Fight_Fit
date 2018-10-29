package th.fight.fit.mpybackoffice.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.domain.MasSystemParam;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.service.MasSysParamService;

@Component
public class SystemParamUtil {

    private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
    private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);

    private static HashMap<String, Object> dataMap = null;
    public static final String SYSTEMPARAMETER = "SYSPARAM";
    public static final long REFRESH_PERIOD = 300000;
    private long lastLoadTime = System.currentTimeMillis();

    @Autowired
    private MasSysParamService masSysParamService;

    public void loadParam() {
        dataMap = getParameterData();

    }

    /**
     * Calls DAO to obtain the system parameters listing.
     *
     * @return HashMap
     */
    private HashMap<String, Object> getParameterData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        try {

            //DefaultLogger.debug(DEBUG_THIS_CLASS_NAME, "Getting DAO for parameter list");
            List<MasSystemParam> systemParamList = masSysParamService.getMasSysParam(null);

            if (systemParamList != null && !systemParamList.isEmpty()) {
                // does sorting and puts in hashMap
                hashMap = sortParametersByParamName(systemParamList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            errorLogger.error(LogFormatter.error(e));

        }
        return hashMap;

    }

    /**
     * This method assumes the Collection of OBSystemParam is sorted in
     * ParamName order and then puts all the same data into a hashMap and
     * returning it to the caller.
     *
     * @param c Collection of data
     * @return HashMap hashMap
     */
    private static HashMap<String, Object> sortParametersByParamName(Collection c) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Iterator itr = c.iterator();
        int i = 1;
        while (itr.hasNext()) {
            MasSystemParam obSystemParam = (MasSystemParam) itr.next();
            String paramKey = obSystemParam.getParamKey();
            //DefaultLogger.debug(DEBUG_THIS_CLASS_NAME, "obParam[" + i + "].paramName = " + paramKey);
            if (hashMap.get(paramKey) != null) {
                List<MasSystemParam> existingList = (ArrayList<MasSystemParam>) hashMap.get(paramKey);
                existingList.add(obSystemParam);
                //DefaultLogger.debug(DEBUG_THIS_CLASS_NAME, "Existing list size added " + existingList.size());
            } else {
                List<MasSystemParam> list = new ArrayList<MasSystemParam>();
                list.add(obSystemParam);
                hashMap.put(paramKey, list);
                //DefaultLogger.debug(DEBUG_THIS_CLASS_NAME, "New list created for " + paramKey);
            }
            i++;
        }

        return hashMap;
    }

    /*
	 * This method get parameters based on paramater Name from dataMap and returns the value.
	 * @param paramKey
	 * @return
     */
    public String getValue(String paramKey) {
        String value = null;
        reloadParameters();
        if (dataMap != null && !dataMap.isEmpty()) {
            List<MasSystemParam> list = (ArrayList<MasSystemParam>) dataMap.get(paramKey);
            if (list != null) {
                //                    vector = new Vector();
                for (int i = 0, iTotal = list.size(); i < iTotal; i++) {
                    MasSystemParam obSystemParam = (MasSystemParam) list.get(i);
                    value = obSystemParam.getValue();
                }
            }
        } else {

        }

        return value;
    }

    /**
     * This method get parameters based on paramater Name from dataMap and
     * returns the value.
     *
     * @param paramKey
     * @return
     */
    public MasSystemParam getSystemParam(String paramKey) {
        //MasSystemParam value = null;

        reloadParameters();
        if (dataMap != null && !dataMap.isEmpty()) {
            List<MasSystemParam> list = (ArrayList<MasSystemParam>) dataMap.get(paramKey);
            if (list != null) {
                for (int i = 0, iTotal = list.size(); i < iTotal; i++) {
                    return (MasSystemParam) list.get(i);
                }
            }
        }
        return null;
    }

    /**
     * This method clears the cache and reload again from the database.
     */
    private void reloadParameters() {
        systemLogger.info(LogFormatter.info("Start reloadParameters !!!"));
        if (dataMap == null || System.currentTimeMillis() - lastLoadTime > REFRESH_PERIOD) {
            systemLogger.info(LogFormatter.info("reloadParameters"));
            dataMap.clear();
            dataMap = getParameterData();
            lastLoadTime = System.currentTimeMillis();

        }
    }

}

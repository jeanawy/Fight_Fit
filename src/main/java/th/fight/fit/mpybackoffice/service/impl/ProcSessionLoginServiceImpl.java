package th.fight.fit.mpybackoffice.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.dao.ProcSessionLoginDao;
import th.fight.fit.mpybackoffice.domain.ProcSessionLogin;
import th.fight.fit.mpybackoffice.domain.UserDetail;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;
import th.fight.fit.mpybackoffice.service.ProcSessionLoginService;
import th.fight.fit.mpybackoffice.util.DateUtil;
import th.fight.fit.mpybackoffice.util.SystemParamUtil;
import th.fight.fit.mpybackoffice.util.Utility;

@Service
public class ProcSessionLoginServiceImpl implements ProcSessionLoginService {
	private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
	private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
	
	@Autowired private ProcSessionLoginDao procSessionLoginDao;
	@Autowired private SystemParamUtil systemParamUtil;
	
	public void extendSessionTimeout(BigInteger sid, UserDetail userDetail) throws Exception{
		// Extend logout time. Added by Ratapong W. 20150917.
		systemLogger.info(LogFormatter.info(userDetail.getSid().toString(), userDetail.getUserLogin().getUserName(), "Start extendSessionTimeout"));
		int sessionTimeout = Integer.parseInt(systemParamUtil.getValue(ProjectConstant.SYSTEM_PARAM_SESSION_TIMEOUT));
		Date currentTime = new Date();
		Date newLogoutTime = new Date();
		
		try {
			newLogoutTime.setTime(currentTime.getTime() + (sessionTimeout * 1000)); // milliseconds
			
			ProcSessionLogin procSessionLogin = procSessionLoginDao.getProcSessionLogin(userDetail.getProcUserProfile().getUserId().toString());

			systemLogger.info(LogFormatter.info(userDetail.getSid().toString(), userDetail.getUserLogin().getUserName(), 
					"Update logoutTime from " +  DateUtil.formatDateTime(procSessionLogin.getLogoutTime(), Utility.getLocale(ProjectConstant.LANGUAGE_EN)) + " to : " + DateUtil.formatDateTime(newLogoutTime, Utility.getLocale(ProjectConstant.LANGUAGE_EN))));
			
			procSessionLogin.setLogoutTime(newLogoutTime);
			
			procSessionLoginDao.updateProcSessionLogin(procSessionLogin);
			
		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(LogFormatter.error(e));
			
			throw e;
		} finally {
			systemLogger.info(LogFormatter.callServiceTime(userDetail.getSid().toString(), userDetail.getUserLogin().getUserName(), currentTime, new Date()));
			
		}

	}

	public void deleteProcSessionLogin(BigInteger sessionLoginId) throws Exception {
		procSessionLoginDao.deleteProcSessionLogin(sessionLoginId);
		
	}
	
	public ProcSessionLogin getProcSessionLogin(BigInteger sid) throws Exception{
		ProcSessionLogin procSessionLogin = new ProcSessionLogin();
		procSessionLogin.setSid(sid);
		
		List<ProcSessionLogin> procSessionLoginList = procSessionLoginDao.findProcSessionLogin(procSessionLogin);
		
		return procSessionLoginList != null ? procSessionLoginList.get(0) : null;
		
	}
	
}

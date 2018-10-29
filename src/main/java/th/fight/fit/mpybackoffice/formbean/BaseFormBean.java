package th.fight.fit.mpybackoffice.formbean;

import javax.servlet.http.HttpServletRequest;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.util.StringUtils;

public abstract class BaseFormBean implements IFormBean{

	/**
	 *
	 */
	private static final long serialVersionUID = 3332110585910666729L;

	protected String command;
	protected String mode;
	protected String result;
	protected String errMsg;
	protected boolean isResultFalse = false;
	protected String language;
	


	public Object getSessionAttribute(HttpServletRequest request, String keyVal)throws Exception {
		if(null!=request.getSession(false)){
			return request.getSession(false).getAttribute(keyVal);
		}else{
			return null;
		}
	}

	public boolean setSessionAttribute(HttpServletRequest req, String keyVal, Object objVal)throws Exception {
		if(null!=req.getSession(false)){
			req.getSession(false).setAttribute(keyVal,objVal);
			return true;
		}else{
			return false;
		}
	}


	public boolean chkEmptyOrNull(String value) {
		if(StringUtils.isNotEmptyOrNull(value)){
			return true;
		}else{
			return false;
		}
	}


	public void setResult(String result) {
		this.result = result;
		if(ProjectConstant.STATUS_SUCCESS.equalsIgnoreCase(result)){
			setResultFalse(false);
		}else{
			setResultFalse(true);
		}
	}

	public String getResult() {
		return result;
	}

	public boolean getIsResultFalse() {
		return isResultFalse;
	}

	public String getErrMsg() {
		if(StringUtils.isNotEmptyOrNull(this.errMsg)){
			if(this.errMsg.length()>300){
				return this.errMsg.substring(0,300);
			}else{
				return this.errMsg;
			}
		}else{
			return this.errMsg;
		}
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}


	public boolean isResultFalse() {
		return isResultFalse;
	}

	public void setResultFalse(boolean isResultFalse) {
		this.isResultFalse = isResultFalse;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


}

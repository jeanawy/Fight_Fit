package th.fight.fit.mpybackoffice.formbean;



public class AjaxFormBean extends BaseFormBean {

	/**
	 *
	 */
	private static final long serialVersionUID = -1114640788045651834L;

	private String key1;
	private String key2;
	private String key3;
	
	private String key4;
	private String key5;
	private String key6;

	

	public String getKey6() {
		return key6;
	}
	public void setKey6(String key6) {
		this.key6 = key6;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public String getKey3() {
		return key3;
	}
	public void setKey3(String key3) {
		this.key3 = key3;
	}
	public String getKey4() {
		return key4;
	}
	public void setKey4(String key4) {
		this.key4 = key4;
	}
	public String getKey5() {
		return key5;
	}
	public void setKey5(String key5) {
		this.key5 = key5;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AjaxFormBean [key1=");
		builder.append(key1);
		builder.append(", key2=");
		builder.append(key2);
		builder.append(", key3=");
		builder.append(key3);
		builder.append(", key4=");
		builder.append(key4);
		builder.append(", key5=");
		builder.append(key5);
		builder.append(", command=");
		builder.append(command);
		builder.append(", mode=");
		builder.append(mode);
		builder.append(", result=");
		builder.append(result);
		builder.append(", errMsg=");
		builder.append(errMsg);
		builder.append(", isResultFalse=");
		builder.append(isResultFalse);
		builder.append(", language=");
		builder.append(language);
		builder.append("]");
		return builder.toString();
	}


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain.vo;

/**
 *
 * @author Worakan
 */
public class CheckBoxVO {

    private String checkBoxKey;
    private String checkBoxKey2;
    private String checkBoxKey3;

    private String checkBoxValue;
    private String checkBoxValue2;
    private String checkBoxValue3;

    public String getCheckBoxKey() {
        return checkBoxKey;
    }

    public void setCheckBoxKey(String checkBoxKey) {
        this.checkBoxKey = checkBoxKey;
    }

    public String getCheckBoxKey2() {
        return checkBoxKey2;
    }

    public void setCheckBoxKey2(String checkBoxKey2) {
        this.checkBoxKey2 = checkBoxKey2;
    }

    public String getCheckBoxKey3() {
        return checkBoxKey3;
    }

    public void setCheckBoxKey3(String checkBoxKey3) {
        this.checkBoxKey3 = checkBoxKey3;
    }

    public String getCheckBoxValue() {
        return checkBoxValue;
    }

    public void setCheckBoxValue(String checkBoxValue) {
        this.checkBoxValue = checkBoxValue;
    }

    public String getCheckBoxValue2() {
        return checkBoxValue2;
    }

    public void setCheckBoxValue2(String checkBoxValue2) {
        this.checkBoxValue2 = checkBoxValue2;
    }

    public String getCheckBoxValue3() {
        return checkBoxValue3;
    }

    public void setCheckBoxValue3(String checkBoxValue3) {
        this.checkBoxValue3 = checkBoxValue3;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[checkBoxKey=");
        builder.append(checkBoxKey);
        builder.append(",checkBoxKey2=");
        builder.append(checkBoxKey2);
        builder.append(",checkBoxKey3=");
        builder.append(checkBoxKey3);
        builder.append(",checkBoxValue=");
        builder.append(checkBoxValue);
        builder.append(",checkBoxValue2=");
        builder.append(checkBoxValue2);
        builder.append(",checkBoxValue3=");
        builder.append(checkBoxValue3);

        builder.append("]");

        return builder.toString();
    }

}

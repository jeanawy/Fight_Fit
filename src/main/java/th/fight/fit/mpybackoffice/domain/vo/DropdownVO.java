/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain.vo;

/**
 *
 * @author Anuwat_K
 */
public class DropdownVO {

    private String dropDownKey;
    private String dropDownValue;
    private String dropDownValue2;
    private String dropDownValue3;
    private String dropDownValue4;

    public String getDropDownKey() {
        return dropDownKey;
    }

    public void setDropDownKey(String dropDownKey) {
        this.dropDownKey = dropDownKey;
    }

    public String getDropDownValue() {
        return dropDownValue;
    }

    public void setDropDownValue(String dropDownValue) {
        this.dropDownValue = dropDownValue;
    }

    public String getDropDownValue2() {
        return dropDownValue2;
    }

    public void setDropDownValue2(String dropDownValue2) {
        this.dropDownValue2 = dropDownValue2;
    }

    public String getDropDownValue3() {
        return dropDownValue3;
    }

    public void setDropDownValue3(String dropDownValue3) {
        this.dropDownValue3 = dropDownValue3;
    }

    public String getDropDownValue4() {
        return dropDownValue4;
    }

    public void setDropDownValue4(String dropDownValue4) {
        this.dropDownValue4 = dropDownValue4;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[dropDownKey=");
        builder.append(dropDownKey);
        builder.append(", dropDownValue=");
        builder.append(dropDownValue);
        builder.append(", dropDownValue2=");
        builder.append(dropDownValue2);
        builder.append(", dropDownValue3=");
        builder.append(dropDownValue3);
        builder.append(", dropDownValue4=");
        builder.append(dropDownValue4);
        builder.append("]");
        return builder.toString();
    }
}

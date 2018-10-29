/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.rest.UserAuthorize;

import java.util.List;
import java.util.Map;
import th.fight.fit.mpybackoffice.domain.vo.CheckBoxVO;

/**
 *
 * @author Anuwat_K
 */
public class GetEmployeeDetailsResponse {

    private String uid;
    private String image;
    private String name;
    private String employeeID;
    private String department;

    private String division;
    private String position;
    private String level;
    private String group;
    private Map<String, List<CheckBoxVO>> authority;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Map<String, List<CheckBoxVO>> getAuthority() {
        return authority;
    }

    public void setAuthority(Map<String, List<CheckBoxVO>> authority) {
        this.authority = authority;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.Group;

/**
 *
 * @author Panaporn
 */
public class SearchNameModel {
    private String SearchName;
    private String groupIDs;
    private String sid;
    private String language;

    public String getSearchName() {
        return SearchName;
    }

    public void setSearchName(String SearchName) {
        this.SearchName = SearchName;
    }

    public String getGroupIDs() {
        return groupIDs;
    }

    public void setGroupIDs(String groupIDs) {
        this.groupIDs = groupIDs;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "SearchNameModel{" + "SearchName=" + SearchName + ", groupIDs=" + groupIDs + ", sid=" + sid + ", language=" + language + '}';
    }

    

   
    
    
}

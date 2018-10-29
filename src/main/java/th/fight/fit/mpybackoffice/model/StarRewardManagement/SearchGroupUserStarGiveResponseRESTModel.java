/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.StarRewardManagement;

/**
 *
 * @author ธนากร
 */
public class SearchGroupUserStarGiveResponseRESTModel {
    private String giveGoldStar;
    private String giveSilverStar;
    private String giveBronzeStar;

    public String getGiveGoldStar() {
        return giveGoldStar;
    }

    public void setGiveGoldStar(String giveGoldStar) {
        this.giveGoldStar = giveGoldStar;
    }

    public String getGiveSilverStar() {
        return giveSilverStar;
    }

    public void setGiveSilverStar(String giveSilverStar) {
        this.giveSilverStar = giveSilverStar;
    }

    public String getGiveBronzeStar() {
        return giveBronzeStar;
    }

    public void setGiveBronzeStar(String giveBronzeStar) {
        this.giveBronzeStar = giveBronzeStar;
    }

    @Override
    public String toString() {
        return "SearchGroupUserStarGiveResponseRESTModel{" + "giveGoldStar=" + giveGoldStar + ", giveSilverStar=" + giveSilverStar + ", giveBronzeStar=" + giveBronzeStar + '}';
    }
    
}

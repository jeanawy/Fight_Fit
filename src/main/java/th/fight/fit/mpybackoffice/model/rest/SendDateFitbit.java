/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.rest;

import java.util.Date;

/**
 *
 * @author Sent
 */
public class SendDateFitbit {
   private String mytime; // 2018-10-17
   private String startTime;// 10:50
   private String endTime;

    public String getMytime() {
        return mytime;
    }

    public void setMytime(String mytime) {
        this.mytime = mytime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SendDateFitbit{" + "mytime=" + mytime + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
  
}

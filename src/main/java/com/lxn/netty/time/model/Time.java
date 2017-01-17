package com.lxn.netty.time.model;

import java.util.Date;

/**
 * Created by Lin Xiangnan on 2017/1/6.
 *
 * @author Lin Xiangnan
 * @func
 **/
public class Time {

    private Date currentTime;

    public Time(){
        this.currentTime = new Date();
    }

    public Time(long time){
        this.currentTime = new Date((time-2208988800L)*1000L);
    }

    public Date getCurrentTime(){
        return currentTime;
    }

    @Override
    public String toString(){
        return currentTime.toString();
    }

}

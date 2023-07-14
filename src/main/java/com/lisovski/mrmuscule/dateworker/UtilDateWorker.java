package com.lisovski.mrmuscule.dateworker;

import java.util.Date;

public class UtilDateWorker {
    private Date date;

    public UtilDateWorker(){
        this.date = new Date();
    }

    public long getDateInMilis(){
        return date.getTime();
    }

}

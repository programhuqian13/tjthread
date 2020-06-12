package org.tony.tj.thread.threadlocal;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class MyDateFormatter {

    private ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    public String format(Date date){
        SimpleDateFormat simpleDateFormat = getSimpleDateFormat();
        return simpleDateFormat.format(date);
    }

    private SimpleDateFormat getSimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if(Objects.isNull(simpleDateFormat)){
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            threadLocal.set(simpleDateFormat);
        }
        return simpleDateFormat;
    }

    
}
package org.tony.tj.thread.threadlocal;

import java.util.Date;

/***
 * 延迟设置ThreadLocal的值 在某些情况下，您不能使用设置初始值的标准方法。
 * 例如，您可能需要一些在创建ThreadLocal变量时不可用的配置信息。 在这种情况下，可以延迟设置初始值。
 */
public class ThreadLocalLazySettingValue {
    
    public static void main(String ... args){
        MyDateFormatter myDateFormatter = new MyDateFormatter();
        String result = myDateFormatter.format(new Date());
        System.out.println("time result:" + result);
    }
}
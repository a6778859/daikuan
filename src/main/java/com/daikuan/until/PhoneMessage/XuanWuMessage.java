package com.daikuan.until.PhoneMessage;

/**
 * 短信发送类
 */
public class XuanWuMessage  {


    private static XuanWuMessage client = null;


    public  XuanWuMessage() {
        System.out.println("12121");
    }


    public synchronized static XuanWuMessage getInstance() {
        if (client == null) {
            client = new XuanWuMessage();
        }
        return client;
    }



    public void send() {
        System.out.println("send");
    }
}

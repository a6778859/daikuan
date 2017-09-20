package com.daikuan.until.PhoneMessage;

import com.esms.MessageData;
import com.esms.PostMsg;
import com.esms.common.entity.Account;
import com.esms.common.entity.GsmsResponse;
import com.esms.common.entity.MTPack;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 短信发送类
 */
public class XuanWuMessage  {



    public static String send(String phone,String title,String context ) throws Exception {
        Account ac = new Account("jyx@jyx", "7rBDuywc");//
        PostMsg pm = new PostMsg();
        pm.getCmHost().setHost("211.147.239.62", 9080);//设置网关的IP和port，用于发送信息，建议可配
        pm.getWsHost().setHost("211.147.239.62", 9070);
        return doSendSms(pm, ac,phone,title,context);
    }


    public static String doSendSms(PostMsg pm, Account ac,String phone,String title,String context) throws Exception{
        MTPack pack = new MTPack();
        pack.setBatchID(UUID.randomUUID());
        pack.setBatchName(title);
        pack.setMsgType(MTPack.MsgType.SMS);
        pack.setBizType(0);
        pack.setDistinctFlag(false);
        ArrayList<MessageData> msgs = new ArrayList<MessageData>();
        /** 群发，多号码一内容 */
        pack.setSendType(MTPack.SendType.MASS);
        String content =context;
        msgs.add(new MessageData(phone, content));
        pack.setMsgs(msgs);
        GsmsResponse resp = pm.post(ac, pack);
        return resp.toString();
    }
}

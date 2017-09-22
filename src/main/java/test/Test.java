package test;

import com.daikuan.until.CommonUtil;
import com.daikuan.until.PhoneMessage.XuanWuMessage;
import com.daikuan.until.ResultMsg;


import java.util.Arrays;
import java.util.List;

public class Test {
    //12121
    public static void main(String[] args) throws Exception {
//        String[] arr="1".split(",");
//        List<String> list = Arrays.asList(arr);
//        System.out.println(list.toArray());
        System.out.println( ResultMsg.phoneMessage(XuanWuMessage.send("13326018211","短信验证码","短信验证码:658756")));

    }
}

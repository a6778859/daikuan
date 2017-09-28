package test;

import com.daikuan.push.Demo;
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
        Demo demo = new Demo("590fe2a1f29d986cb300019c", "artwlovwehbhjv9sm7ihvrpgpsibaked");
        demo.sendIOSCustomizedcast("13326018211", "ALISAS_TYPEDIPAI", "优惠劵来啦");
        demo = new Demo("59111531b27b0a1b85001ef5", "aexqgcbuiuh0ylckdmgbpnj0ryililte");
        demo.sendAndroidCustomizedcast("13326018211", "APPID", "优惠劵", "优惠劵来啦", "查看您的优惠劵");
    }
}

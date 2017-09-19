package test;

import com.daikuan.service.SmslogService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 单元测试
 * Created by shuzheng on 2017/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:applicationContext-jdbc.xml"

})
public class testset {
//122121
    @Autowired
    SmslogService smslogService;
    @org.junit.Test
    public void index() throws ParseException {
        String phone="13326018211";
        Date nowDate = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

        String begin="2017-08-25" + " 00:00:00";
        String end="2017-09-28" + " 23:59:59";
        System.out.println(smslogService.getNowNum(phone)+"8859");

        System.out.println(smslogService.getLast("13326018211"));
//    @BatisGenerator
//    public void selectForPage() {
//        // 根据条件，按页码+每页条数分页
//        UpmsPermissionExample upmsPermissionExample = new UpmsPermissionExample();
//        upmsPermissionExample.createCriteria()
//                .andSystemIdEqualTo(1);
//        List<UpmsPermission> upmsPermissions = upmsPermissionService.selectByExampleForStartPage(upmsPermissionExample, 2, 20);
//        System.out.println(upmsPermissions.size());
//        // 根据条件，按offset+limit分页
//        upmsPermissionExample = new UpmsPermissionExample();
//        upmsPermissionExample.createCriteria()
//                .andSystemIdEqualTo(2);
//        upmsPermissions = upmsPermissionService.selectByExampleForOffsetPage(upmsPermissionExample, 3, 5);
//        System.out.println(upmsPermissions.size());
//    }

    }
}

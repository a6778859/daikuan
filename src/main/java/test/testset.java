package test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @org.junit.Test
    public void index() {
      //  System.out.println(testService.selectByPrimaryKey(1));

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

package com.daikuan.controller;

import com.alibaba.fastjson.JSON;
import com.daikuan.entity.Label;
import com.daikuan.entity.Loan;
import com.daikuan.entity.User;
import com.daikuan.until.CommonUtil;
import com.daikuan.until.PageLimit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/home/login.jsp";
    }

    /**
     * 退出登录
     *
     * @param modelMap
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public String out(ModelMap modelMap) throws IOException {
        SecurityUtils.getSubject().logout();
        return "redirect:/home/login";
    }


    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login_(User user) throws IOException {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getName(), CommonUtil.getMD5(user.getPassword())));
        } catch (UnknownAccountException e) {
            writeErrorJson("账号或密码错误");
            return null;
        } catch (Exception e) {
            writeErrorJson("异常");
            return null;
        }
        writeSuccessJson("成功");
        return null;
    }


    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        // System.out.println("121");
        return "/home/index.jsp";
    }


    /**
     * 贷款类目页面
     *
     * @return
     */
    @RequestMapping(value = "/loan", method = RequestMethod.GET)
    public String loan(PageLimit pageLimit, ModelMap modelMap) {
        // System.out.println("121");
        PageHelper.startPage(pageLimit.getPageNo(), pageLimit.getPageSize());
        List<Map> list = commonService.selectForLoanList();
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("total", total + "");
        return "/home/loan.jsp";
    }


    /**
     * 贷款详细
     *
     * @return
     */
    @RequestMapping(value = "/loan_id", method = RequestMethod.GET)
    public String loan_id(ModelMap modelMap, String id) throws IOException {
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            Loan loan = loanService.selectByPrimaryKey(Integer.parseInt(id));
            map.put("state", "1");
            map.put("msg", loan);
        } catch (Exception e) {
            map.put("state", "2");
            map.put("msg", "异常");
        }
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }


    /**
     * 标签列表
     *
     * @return
     */
    @RequestMapping(value = "/label", method = RequestMethod.GET)
    public String label(ModelMap modelMap, PageLimit pageLimit) throws IOException {
        PageHelper.startPage(pageLimit.getPageNo(), pageLimit.getPageSize());
        List<Map> list = commonService.selectForLabelList();
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("total", total + "");
        return "/home/label.jsp";
    }


    /**
     * 标签详细
     *
     * @return
     */
    @RequestMapping(value = "/label_id", method = RequestMethod.GET)
    public String label_id(ModelMap modelMap, String id) throws IOException {
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            Label label = labelService.selectByPrimaryKey(Integer.parseInt(id));
            map.put("state", "1");
            map.put("msg", label);
        } catch (Exception e) {
            map.put("state", "2");
            map.put("msg", "异常");
        }
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }



}

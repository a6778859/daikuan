package com.daikuan.controller;

import com.alibaba.fastjson.JSON;
import com.daikuan.entity.Company;
import com.daikuan.entity.Label;
import com.daikuan.entity.Loan;
import com.daikuan.entity.User;
import com.daikuan.service.UserService;
import com.daikuan.until.CommonUtil;
import com.daikuan.until.Constants;
import com.daikuan.until.PageLimit;
import com.daikuan.until.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
    @RequestMapping(value = "/loan_", method = RequestMethod.GET)
    public String loan(PageLimit pageLimit, ModelMap modelMap) {
        // System.out.println("121");
        PageHelper.startPage(pageLimit.getPageNo(), pageLimit.getPageSize());
        List<Map> list = commonService.selectForLoanList(null, null);
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("total", total + "");
        //查找出关联的标签
        List<Map> labelList = commonService.selectForLabelList();
        modelMap.addAttribute("labelList", labelList);
        modelMap.addAttribute("pagehelper", pageInfo);

        List<Map> companyList = commonService.selectForCompany();
        modelMap.addAttribute("companyList", companyList);
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
            //查找对应的lable
            List<Map> checkbox = commonService.selectForRelation(Integer.parseInt(id));
            map.put("checkbox", checkbox);
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
     * 修改贷款时间
     *
     * @return
     */
    @RequestMapping(value = "/loan_time", method = RequestMethod.GET)
    public String loan_time(String id) throws IOException {

        try {
            commonService.updateByLoanUpdatetime(Integer.parseInt(id), new Date());
            writeSuccessJson("成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            writeErrorJson("异常");
        }
        return null;
    }


    /**
     * 上传用户头像图片
     *
     * @throws Exception
     */

    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    public String uploadPic(@RequestParam(value = "myfiles") MultipartFile myfiles) throws Exception {
        try {
            String fileName = "";
            String localName = "/user/";
            if (myfiles == null || myfiles.getSize() <= 0) {
                writeErrorJson("文件不能为空");
                return null;
            } else if (myfiles.getSize() / 1024 / 1024 > 1) {
                writeErrorJson("文件不能大于1M");
                return null;
            } else {
                fileName = myfiles.getOriginalFilename();
                String imgPostfix = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (imgPostfix.equals("jpg") || imgPostfix.equals("png")) {
                } else {
                    writeErrorJson("请上传jpg和png格式文件");
                    return null;
                }
                // 得到服务器项目发布运行所在地址
                String trueFileName = System.currentTimeMillis() + "." + imgPostfix;
                // 设置存放图片文件的路径
                String truepath = Constants.TMPURL + localName + trueFileName;

                // 把文件上传至path的路径
                File localFile = new File(truepath);
                myfiles.transferTo(localFile);
                writeSuccessJson("/othertemp" + localName + trueFileName);
            }

        } catch (Exception e) {
            writeErrorJson("异常");
        }
        return null;
    }


    /**
     * 贷款修改
     *
     * @return
     */
    @RequestMapping(value = "/loansave", method = RequestMethod.POST)
    public String loansave(ModelMap modelMap, Loan loan) throws IOException {
        try {
            //判断companyid
            String  companyid="";
            if(!StringUtil.isBlank(request.getParameter("companyid"))){
                companyid=request.getParameter("companyid");
                Company company=companyService.selectByPrimaryKey(Integer.parseInt(companyid));
                loan.setPic(company.getPic());
            }

            //不为空修改
            if (StringUtil.isBlank(request.getParameter("id"))) {
                loanService.insertSelective(loan);


            } else {
                loanService.updateByPrimaryKeySelective(loan);
                //删除关联的标签
                commonService.deleteByLoanid(loan.getId());
            }
            if (!StringUtil.isBlank(request.getParameter("label2"))) {
                String[] arr = request.getParameterValues("label2");
                List<String> list = Arrays.asList(arr);
                //插入标签
                commonService.insertByLoanId(loan.getId(), list);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            writeErrorJson("异常");
            return null;
        }
        writeSuccessJson("成功");
        return null;
    }


    /**
     * 标签列表
     *
     * @return
     */
    @RequestMapping(value = "/label_", method = RequestMethod.GET)
    public String label_(ModelMap modelMap, PageLimit pageLimit) throws IOException {
        PageHelper.startPage(pageLimit.getPageNo(), pageLimit.getPageSize());
        List<Map> list = commonService.selectForLabelList();
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        modelMap.addAttribute("list", list);

        modelMap.addAttribute("pagehelper", pageInfo);

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


    /**
     * 标签修改
     *
     * @return
     */
    @RequestMapping(value = "/labelsave", method = RequestMethod.POST)
    public String labelsave(ModelMap modelMap, Label label) throws IOException {
        try {
            //不为空修改
            if (StringUtil.isBlank(request.getParameter("id"))) {
                labelService.insertSelective(label);
            } else {
                labelService.updateByPrimaryKeySelective(label);
            }

        } catch (Exception e) {
            writeErrorJson("异常");
        }
        writeSuccessJson("成功");
        return null;
    }


    /**
     * 用户详细
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(ModelMap modelMap, String phone, PageLimit pageLimit) throws IOException {
        PageHelper.startPage(pageLimit.getPageNo(), pageLimit.getPageSize());
        //查询出用户数据除啦admin
        List<Map> list = commonService.selectForUserNoAdmin(phone);
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        //查找所有用户出啦admin
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("pagehelper", pageInfo);
        return "/home/user.jsp";
    }


    /**
     * 用户详细
     *
     * @return
     */
    @RequestMapping(value = "/user_id", method = RequestMethod.GET)
    public String user_id(String id) throws IOException {
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            User user = userService.selectByPrimaryKey(Integer.parseInt(id));
            map.put("state", "1");
            map.put("msg", user);
        } catch (Exception e) {
            map.put("state", "-1");
            map.put("msg", "异常");
        }
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }


    @RequestMapping(value = "/usesave", method = RequestMethod.POST)
    public String usesave(User user) throws IOException {
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            if (StringUtil.isBlank(request.getParameter("id"))) {
                userService.insertSelective(user);
            } else {
                userService.updateByPrimaryKeySelective(user);
            }
            writeSuccessJson("成功");
        } catch (Exception e) {
            writeErrorJson("异常");
        }

        return null;
    }

    /**
     * 公司列表
     *
     * @return
     */
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String company(ModelMap modelMap,  PageLimit pageLimit) throws IOException {
        PageHelper.startPage(pageLimit.getPageNo(), pageLimit.getPageSize());
        //查询出用户数据除啦admin
        List<Map> list = commonService.selectForCompany();
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        //查找所有用户出啦admin
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("pagehelper", pageInfo);
        return "/home/company.jsp";
    }

    /**
     * 公司单独列表
     *
     * @return
     */
    @RequestMapping(value = "/company_id", method = RequestMethod.GET)
    public String company_id(ModelMap modelMap,  String companyid) throws IOException {
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            Company company=companyService.selectByPrimaryKey(Integer.parseInt(companyid));
            map.put("state", "1");
            map.put("msg", company);
        } catch (Exception e) {
            map.put("state", "-1");
            map.put("msg", "异常");
        }
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }

    /**
     * 公司单独列表
     *
     * @return
     */
    @RequestMapping(value = "/companysave", method = RequestMethod.POST)
    public String companysave(Company company,  String companyid) throws IOException {
        Map<Object, Object> map = new HashMap<Object, Object>();
        try {
            if (StringUtil.isBlank(request.getParameter("companyid"))) {
                companyService.insertSelective(company);
            } else {
                companyService.updateByPrimaryKeySelective(company);
            }
            writeSuccessJson("成功");
        } catch (Exception e) {
            writeErrorJson("异常");
        }
        return  null;
    }

}

package com.daikuan.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.daikuan.dao.LoanMapper;
import com.daikuan.entity.Loan;
import com.daikuan.service.LoanService;
import com.daikuan.until.PageLimit;
import com.daikuan.until.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    /**
     * 首页列表
     * @param pageLimit
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(PageLimit pageLimit,String label) throws IOException {
        JSONObject json = new JSONObject();
        //获取所有的loan
        PageHelper.startPage(pageLimit.getPageNo(), pageLimit.getPageSize());
        List<Map> list = commonService.selectForLoanList("1",label);
        String tmpString = "";
        List<Integer> item = new ArrayList();
        for (Map tmpMap : list) {
            item.add(Integer.parseInt(tmpMap.get("id") + ""));
        }
        //查找对应的label
        if (!StringUtil.isBlank(item)) {
            List<Map> labellist = commonService.selectForLabelInLoanId(item);
            Map labletmpMap = new HashMap();
            for (Map tmpMap : labellist) {
                String id = tmpMap.get("id") + "";
                String value = tmpMap.get("value") + "";
                if (labletmpMap.get(id) == null) {
                    labletmpMap.put(id, value);
                } else {
                    labletmpMap.put(id, labletmpMap.get(id) + "," + value);
                }
            }
            Long  time=new Date().getTime()/1000000000;
            for (int i = 0; i < list.size(); i++) {
                String id = list.get(i).get("id") + "";
                list.get(i).put("labelList", labletmpMap.get(id + ""));
                list.get(i).put("ID", id);
                int id_=Integer.parseInt(id);
                list.get(i).put("number", (900+(id_%3+1)*id_+time)+"");
                list.get(i).put("successrate", (95+id_%3)+"%");
                list.get(i).put("title3", "一分钟完成申请，最快两小时到账");
                list.get(i).put("interestrate", list.get(i).get("interestrate")+"%");
                String moenyrange=list.get(i).get("moenyrange")+"";
                if(!StringUtil.isBlank(moenyrange)&&moenyrange.indexOf("-")!=-1) {
                    moenyrange=moenyrange.substring(moenyrange.lastIndexOf("-") + 1);
                    list.get(i).put("moenyrange", moenyrange);
                }
            }

        }
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        long total = pageInfo.getTotal(); //获取总记录数
        json.put("total", total+"");
        json.put("state", "1");
        json.put("applynum", "998");
        List<Map> list2 = new ArrayList();
        Map tmpMap = new HashMap();
        tmpMap.put("name", "13326018211");
        tmpMap.put("money", "10000元");
        list2.add(tmpMap);
        tmpMap = new HashMap();
        tmpMap.put("name", "1332***211");
        tmpMap.put("money", "10080元");
        list2.add(tmpMap);
        json.put("list2", list2);
        json.put("list", list);
        String jsonString = JSON.toJSONString(json);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }

    /**
     * 首页图片
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/pic", method = RequestMethod.GET)
    public String pic() throws IOException {
        System.out.println("121");
        JSONObject json = new JSONObject();
        List<Map> sitellist = commonService.selectForSiteList();
        json.put("state", "1");
        json.put("list", sitellist);
        String jsonString = JSON.toJSONString(json);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }

    /**
     * 详细信息
     * @param ID
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(String ID) throws IOException {
        JSONObject json = new JSONObject();
        try {
            Loan loan = loanService.selectByPrimaryKey(Integer.parseInt(ID));
            json.put("title", loan.getTitle());
            json.put("moenyrange", loan.getMoenyrange() + "");
            json.put("timerange", loan.getTimerange() + "");
            json.put("interestrate", loan.getInterestrate() + "");
            json.put("lendingmethods", loan.getLendingmethods() + "");
            json.put("payreturn", loan.getPayreturn() + "");
            json.put("remark", loan.getRemark() + "");
            json.put("pic", loan.getPic() + "");
            json.put("state", "1");
            int id_=Integer.parseInt(ID);
            Long  time=new Date().getTime()/1000000000;
            json.put("applynum", (900+(id_%3+1)*id_+time)+"");
            json.put("successrate", (95+id_%3)+"%");


            json.put("material", "身份证，银行卡，手机号");

        } catch (Exception e) {
            json.put("msg", "异常");
            json.put("state", "-1");
        }

        String jsonString = JSON.toJSONString(json);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }


}

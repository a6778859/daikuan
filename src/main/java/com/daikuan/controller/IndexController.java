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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(PageLimit pageLimit) throws IOException {


        JSONObject json = new JSONObject();

        //获取所有的loan
        PageHelper.startPage(pageLimit.getPageNo(), pageLimit.getPageSize());
        List<Map> list = commonService.selectForLoanList("1");
        //PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        //long total = pageInfo.getTotal(); //获取总记录数
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

            for (int i = 0; i < list.size(); i++) {
                String id = list.get(i).get("id") + "";
                list.get(i).put("labelList", labletmpMap.get(id + ""));
                list.get(i).put("ID", id);
                list.get(i).put("number", "1988");
                list.get(i).put("successrate", "100");
            }

        }

        json.put("state", "1");
        json.put("applynum", "998");
        List<Map> list2 = new ArrayList();
        Map tmpMap = new HashMap();
        tmpMap.put("key", "13326018211");
        tmpMap.put("value", "10000元");
        list2.add(tmpMap);
        tmpMap = new HashMap();
        tmpMap.put("key", "1332***211");
        tmpMap.put("value", "10080元");
        list2.add(tmpMap);
        json.put("list2", list2);
        json.put("list", list);
        String jsonString = JSON.toJSONString(json);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }


    @RequestMapping(value = "/pic", method = RequestMethod.GET)
    public String pic() {

        return null;
    }


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(String ID) throws IOException {
        JSONObject json = new JSONObject();
        try {
            Loan loan = loanService.selectByPrimaryKey(Integer.parseInt(ID));
            json.put("list", loan);
            json.put("state", "1");
            json.put("applynum", "768900");
            json.put("successrate", "97%");
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

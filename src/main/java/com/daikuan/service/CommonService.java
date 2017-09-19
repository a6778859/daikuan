package com.daikuan.service;

import com.daikuan.dao.CommonMapper;
import com.daikuan.entity.User;
import com.daikuan.until.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommonService {
    @Autowired
    CommonMapper commonMapper;
    @Autowired
    SmslogService smslogService;

    public User selectForUser(String name) {
        return commonMapper.selectForUser(name);
    }

    public List<Map> selectForLoanList(String status) {
        return commonMapper.selectForLoanList(status);
    }

    public List<Map> selectForLabelList() {
        return commonMapper.selectForLabelList();
    }

    public List<Map> selectForRelation(int loanid) {
        return commonMapper.selectForRelation(loanid);
    }

    public int insertByLoanId(int loanid, List<String> label) {
        return commonMapper.insertByLoanId(loanid, label);
    }

    public int deleteByLoanid(int loanid) {
        return commonMapper.deleteByLoanid(loanid);
    }

    public int updateByLoanUpdatetime(int loanid, Date date) {
        return commonMapper.updateByLoanUpdatetime(loanid, date);
    }


    public List<Map> selectForLoanDetail() {
        return commonMapper.selectForLoanDetail();
    }

    public List<Map> selectForLabelInLoanId(List tmpString) {
        return commonMapper.selectForLabelInLoanId(tmpString);
    }


    public List<Map> selectForSiteList() {
        return commonMapper.selectForSiteList();
    }


    public String checkMobileVcode(String phone, String codePhone) {
        if (Constants.TEST) {
            return "";
        }

        List<Map> smslogsms = smslogService.getByPhone(phone);
        if (smslogsms.size() > 0 && smslogsms.get(0).get("Count") == null) {
            String remarks = smslogsms.get(0).get("Remarks") + "";
            remarks = remarks.replace("验证码：", "").trim();
            if (!remarks.equals(codePhone)) {
                return "手机验证码错误";
            } else {
                smslogService.setCount(smslogsms.get(0).get("ID") + "");
            }
        } else {
            return "手机验证码失效,请重新验证";
        }

        return "";

    }

    public int selectByMobileCount(String name) {
       return commonMapper.selectByMobileCount(name);
    }

    public void updatePassword(String mobilePhone, String md5) {
        commonMapper.updatePassword(mobilePhone,md5);
    }
}

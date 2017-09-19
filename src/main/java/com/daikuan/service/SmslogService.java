package com.daikuan.service;

import com.daikuan.dao.SiteMapper;
import com.daikuan.dao.SmslogMapper;
import com.daikuan.entity.Loan;
import com.daikuan.entity.Smslog;
import com.daikuan.until.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
@Service
public class SmslogService {
    @Autowired
    SmslogMapper smslogMapper;


    public String check(String phoneStr, String Code_, String temptoken, HttpServletRequest request, HttpSession session) throws ParseException {
        String Code = "";
        if (!StringUtil.isBlank(temptoken)&&RedisUtil.get(temptoken) != null) {
            Code = RedisUtil.get(temptoken);
        }
        if (!StringUtil.isBlank(Code) && !StringUtil.isBlank(Code_)) {
            if (!Code.toLowerCase().equals((Code_.toLowerCase()))) {
                return "验证码错误";
            } else {
                session.setAttribute("Code", null);
                if (temptoken != null) {
                    RedisUtil.remove(temptoken);
                }
            }
        } else {
            return "验证码失效,请重新验证";
        }

        // session.setAttribute("Code", null);
        // 判断手机号是否合法
        if (!RegexChk.checkCellPhone(phoneStr)) {
            return "手机号码格式错误";
        }
        // // 判断手机号码是否唯一
        // if (customerService.getMobileExist(PhoneStr)) {
        // writeErrorJson("该手机号码已被注册或被封");
        // return null;
        // }

        // 判断当天该号码发送的短信条数
        synchronized (phoneStr) {
            int num = getNowNum(phoneStr);
            if (num >= 6) {
                return "今日发送短息数量已达上限";
            }
            // 60秒内短信不再发送
            // 获取最近发送的短信
            if (num >= 1) {
                // 获取最近的一条短信发送的时间
                List<Map> w = getLast(phoneStr);
                if (w.size() > 0) {
                    Timestamp time = (Timestamp) w.get(0).get("SendTime");
                    // 时间差
                    int second = DateUtil.distanceSec(new Date(time.getTime()), new Date());
                    if (second <= 60) {
                        return "短信已发送请稍后操作";
                    }
                }
            }

            // 同一个ip 一天最多发送 20条 短信
            String ip = CommonUtil.getRealIp(request);
            // 同一个ip在12小时发送的短信数量
            String ipNumStr = RedisUtil.get(ip);
            if (!StringUtil.isBlank(ip)) {
                if (!StringUtil.isBlank(ipNumStr)) {
                    int ipNum = Integer.parseInt(ipNumStr) + 1;
                    if (ipNum > 20) {
                        return "同一个ip当天发送短信上限";
                    } else {
                        RedisUtil.set(ip, ipNum + "", 43200);
                    }
                } else {
                    RedisUtil.set(ip, 1 + "", 43200);
                }
            }
            // 发送短信证码
            String phonCode = CommonUtil.RecommendCode(6);
            String msg = "验证码：" + phonCode;
            String result = "";
            if (!result.equals("") && !Constants.TEST) {
                return result;
            }
            Smslog smslog = new Smslog();
            smslog.setRemarks(msg);
            smslog.setSendtime(new Date());
            smslog.setMphone(phoneStr);
            insertSelective(smslog);
            return "";
        }
    }

    public List<Map> getLast(String phoneStr) {
        return smslogMapper.findMapBySQL(phoneStr);
    }

    public int getNowNum(String phone) throws ParseException {
        Date nowDate = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String sql = " select  * from smslog where  MPhone=? and SendTime>= '" + formater.format(nowDate) + " 00:00:00" + "'   and  SendTime <='" + formater.format(nowDate) + " 23:59:59" + "'";
        String begin=formater.format(nowDate) + " 00:00:00";
        String end=formater.format(nowDate) + " 23:59:59";
        return smslogMapper.countSqlQueryResult(phone,begin,end);
    }
    public  int insertSelective(Smslog smslog){
        return smslogMapper.insertSelective(smslog);
    }

    public List<Map> getByPhone(String phone) {
        //验证码有效时间一个钟头
        String date=DateUtil.getLongStrFromDate(DateUtil.optTime(new Date(), Calendar.HOUR_OF_DAY,-1));
       return smslogMapper.getByPhone(phone,date);
    }


    public void setCount(String id) {
        smslogMapper.setCount(id);
    }
}

package com.daikuan.entity;

import java.util.Date;

public class Loan {
    private Integer id;

    private String title;

    private Date addtime;

    private Date updatetime;

    private String payreturn;

    private String moenyrange;

    private String timerange;

    private String interestrate;

    private String label;

    private String lendingmethods;

    private String status;

    private String pic;

    private String title2;

    private String material;

    private String label3;

    private String title3;

    private String companyid;

    private String url;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPayreturn() {
        return payreturn;
    }

    public void setPayreturn(String payreturn) {
        this.payreturn = payreturn == null ? null : payreturn.trim();
    }

    public String getMoenyrange() {
        return moenyrange;
    }

    public void setMoenyrange(String moenyrange) {
        this.moenyrange = moenyrange == null ? null : moenyrange.trim();
    }

    public String getTimerange() {
        return timerange;
    }

    public void setTimerange(String timerange) {
        this.timerange = timerange == null ? null : timerange.trim();
    }

    public String getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(String interestrate) {
        this.interestrate = interestrate == null ? null : interestrate.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getLendingmethods() {
        return lendingmethods;
    }

    public void setLendingmethods(String lendingmethods) {
        this.lendingmethods = lendingmethods == null ? null : lendingmethods.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2 == null ? null : title2.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getLabel3() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3 = label3 == null ? null : label3.trim();
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3 == null ? null : title3.trim();
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
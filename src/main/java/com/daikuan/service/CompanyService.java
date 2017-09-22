package com.daikuan.service;

import com.daikuan.dao.CompanyMapper;
import com.daikuan.dao.SiteMapper;
import com.daikuan.entity.Company;
import com.daikuan.entity.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    CompanyMapper companyMapper;

    public Company selectByPrimaryKey(int companyid) {
        return companyMapper.selectByPrimaryKey(companyid);
    }

    public void insertSelective(Company company) {
        companyMapper.insertSelective(company);
    }

    public void updateByPrimaryKeySelective(Company company) {
        companyMapper.updateByPrimaryKeySelective(company);
    }
}

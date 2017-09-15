package com.daikuan.service;

import com.daikuan.dao.LoanMapper;
import com.daikuan.dao.SiteMapper;
import com.daikuan.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService {
    @Autowired
    SiteMapper siteMapper;


}

package dev.dle.learnspringframework.enterprise.web;

import dev.dle.learnspringframework.enterprise.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyWebController {
    private final BusinessService businessService;

    @Autowired
    public MyWebController(BusinessService service) {
        this.businessService = service;
    }


    public long returnValueFromBusinessService() {
        return businessService.calculateSum();
    }
}


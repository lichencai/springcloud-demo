package com.licc.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefreshController {
	@Autowired  
    RefreshRouteService refreshRouteService;  
    @Autowired  
    ZuulHandlerMapping zuulHandlerMapping;  
  
    @GetMapping("/refreshRoute")  
    public String refresh() {  
        refreshRouteService.refreshRoute();  
        return "refresh success";  
    }  
  
    @RequestMapping("/watchRoute")  
    public Object watchNowRoute() {  
        //可以用debug模式看里面具体是什么  
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();  
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.putAll(handlerMap);
        
        return result;  
    }
}

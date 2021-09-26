package com.digiwin.controller;

import com.digiwin.servcie.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Date;

@RestController
public class FordigController {
    @Autowired
    private HttpService httpService;
    @RequestMapping("/commit")
    public String hello(@RequestParam String project) throws IOException {
        httpService.httpClientWithBasicAuth(project);
        Date date = new Date();
        return date + ": Successful";
    }


//    @RequestMapping("/commit1")
//    public ModelAndView hello1()  {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("welcome.jsp");
//        modelAndView.addObject("message","hellobaby");
//        return modelAndView;
//    }
}



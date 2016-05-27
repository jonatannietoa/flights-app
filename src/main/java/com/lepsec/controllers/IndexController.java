package com.lepsec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jnieto on 26/5/16.
 */
@Controller
public class IndexController {
    @RequestMapping(name = "/")
    public String getIndex(){
        return "index";
    }
}

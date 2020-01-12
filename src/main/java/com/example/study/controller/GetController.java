package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method= RequestMethod.GET ,path="/getmethod")
    public String getRequest(){
        return "hi";
    }

    @GetMapping("/getParameter")
    public SearchParam getParameter(SearchParam searchParam){
        return searchParam;
    }
}

package edu.buet.cse.spring.ch10.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.buet.cse.spring.ch10.v1.service.ChirperService;

@Controller
public class SimpleController {
  private final ChirperService chirperService;
  
  @Autowired
  public SimpleController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHomePage() {
    return "home";
  }
}

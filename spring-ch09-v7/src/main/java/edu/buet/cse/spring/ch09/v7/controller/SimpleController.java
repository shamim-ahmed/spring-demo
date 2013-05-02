package edu.buet.cse.spring.ch09.v7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHomePage() {
    return "home";
  }
  
  @RequestMapping("/secured-page")
  public String showSecuredPage() {
    return "securedPage";
  }
}

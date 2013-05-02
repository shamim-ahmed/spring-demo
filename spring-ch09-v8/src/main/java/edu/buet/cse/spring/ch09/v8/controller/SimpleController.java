package edu.buet.cse.spring.ch09.v8.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showHome() {
    return "home";
  }
  
  @RequestMapping(value = "/login-form", method = RequestMethod.GET)
  public String showLoginForm() {
    return "loginForm";
  }
  
  @RolesAllowed("ROLE_PAINTER")
  @RequestMapping(value = "/color-list", method = RequestMethod.GET)
  public String showColorList() {
    return "colorList";
  }
  
  @RolesAllowed("ROLE_CHEF")
  @RequestMapping(value = "/fruit-list", method = RequestMethod.GET)
  public String showFruitList() {
    return "fruitList";
  }
  
  @RolesAllowed("ROLE_POET")
  @RequestMapping(value = "/poem", method = RequestMethod.GET)
  public String showPoem() {
    return "poem";
  }
}

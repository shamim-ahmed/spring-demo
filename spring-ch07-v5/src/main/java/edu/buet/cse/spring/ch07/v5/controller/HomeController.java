package edu.buet.cse.spring.ch07.v5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.buet.cse.spring.ch07.v5.model.User;
import edu.buet.cse.spring.ch07.v5.service.ChirperService;

public class HomeController extends AbstractController {
  private final ChirperService userService;
  
  public HomeController(ChirperService userService) {
    this.userService = userService;
  }

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mv = new ModelAndView("home");
    List<User> users = userService.getUsers();
    mv.addObject("users", users);
    
    return mv;
  }
}

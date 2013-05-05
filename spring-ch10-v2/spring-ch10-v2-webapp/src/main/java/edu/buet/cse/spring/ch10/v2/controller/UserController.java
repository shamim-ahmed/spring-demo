package edu.buet.cse.spring.ch10.v2.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.buet.cse.spring.ch10.v2.model.User;
import edu.buet.cse.spring.ch10.v2.service.ChirperService;

@Controller("userController")
public class UserController extends AbstractController {
  private final ChirperService chirperService;
  
  @Autowired
  public UserController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }
  
  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mv = new ModelAndView("userList");
    Collection<User> users = chirperService.getUsers(Integer.MAX_VALUE);
    mv.addObject("users", users);
    
    return mv;
  }
}

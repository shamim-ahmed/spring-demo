package edu.buet.cse.spring.ch13.v4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller("homeController")
public class HomeController extends AbstractController {
  private static final int COUNT = 5;
  
  private int upperLimit = 100;
  
  public int getUpperLimit() {
    return upperLimit;
  }

  public void setUpperLimit(int upperLimit) {
    this.upperLimit = upperLimit;
  }

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mv = new ModelAndView("home");
    Random randomGenerator = new Random();
    List<Integer> numbers = new ArrayList<>();
    
    for (int i = 0; i < COUNT; i++) {
      numbers.add(randomGenerator.nextInt(upperLimit));
    }
    
    mv.addObject("numbers", numbers);
    
    return mv;
  }
}

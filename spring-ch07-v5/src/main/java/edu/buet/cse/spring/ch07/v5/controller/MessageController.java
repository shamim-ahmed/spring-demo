package edu.buet.cse.spring.ch07.v5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.buet.cse.spring.ch07.v5.model.Message;
import edu.buet.cse.spring.ch07.v5.service.ChirperService;

public class MessageController extends AbstractController {
  private final ChirperService chirperService;

  public MessageController(ChirperService chirperService) {
    this.chirperService = chirperService;
  }

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mv = new ModelAndView("messageList");
    List<Message> messages = chirperService.getMessages();
    mv.addObject("messages", messages);

    return mv;
  }
}

package edu.buet.cse.spring.ch09.v7.tag;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class GetUsernameTag extends SimpleTagSupport {
  private String var;

  public void setVar(String var) {
    this.var = var;
  }

  @Override
  public void doTag() {
    PageContext pageContext = (PageContext) getJspContext();
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = null;
    
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    }
    
    pageContext.setAttribute(var, username);
  }
}

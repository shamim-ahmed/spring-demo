package edu.buet.cse.spring.ch09.v10.evaluator;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import edu.buet.cse.spring.ch09.v10.model.Message;

/**
 * This permission evaluator ensures that a user can only view his own message
 * @author shamim
 *
 */
public class MessagePermissionEvaluator implements PermissionEvaluator {
  private static final String VIEW_PERMISSION = "view";

  @Override
  public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
    boolean result = false;

    if (targetDomainObject instanceof Message && VIEW_PERMISSION.equals(permission)) {
      Message message = (Message) targetDomainObject;
      result = message.getUsername().equals(authentication.getName());
    }

    return result;
  }

  @Override
  public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
      Object permission) {
    throw new UnsupportedOperationException();
  }
}

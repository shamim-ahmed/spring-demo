package edu.buet.cse.spring.ch11.v2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.buet.cse.spring.ch11.v2.model.Message;
import edu.buet.cse.spring.ch11.v2.model.User;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ChirperDaoImpl extends SimpleJdbcDaoSupport implements ChirperDao {
  private static final String GET_USER_SQL = "SELECT * FROM User WHERE id = ?";
  private static final String GET_MESSAGE_SQL = "SELECT * FROM Message WHERE id = ?";
  private static final String GET_USERS_SQL = "SELECT * FROM User LIMIT ?";
  private static final String GET_MESSAGES_BY_USERID_SQL = "SELECT * FROM Message where user_id = ?";
  private static final String INSERT_USER_SQL = "INSERT INTO User(username, password, join_date, receive_email) VALUES (:uname, :passwd, :joinDate, :recvEmail)";
  private static final String INSERT_MESSAGE_SQL = "INSERT INTO Message(content, created_on, user_id) VALUES (:txt, :creationDate, :userId)";
  private static final String UPDATE_USER_SQL = "UPDATE User SET password = :passwd, receive_email = :recvEmail WHERE id = :id";
  private static final String DELETE_USER_SQL = "DELETE FROM User where id = ?";
  private static final String UPDATE_MESSAGE_SQL = "UPDATE Message SET content = :txt WHERE id = :id";
  private static final String DELETE_MESSAGE_SQL = "DELETE FROM Message WHERE id = ?";
  
  
  private final UserRowMapper userRowMapper = new UserRowMapper();
  private final MessageRowMapper messageRowMapper = new MessageRowMapper();
  
  @Override
  public User getUser(Long id) {
    User user = getSimpleJdbcTemplate().queryForObject(GET_USER_SQL, userRowMapper, id);
    return user;
  }

  @Override
  public Message getMessage(Long id) {
    Message message = getSimpleJdbcTemplate().queryForObject(GET_MESSAGE_SQL, messageRowMapper, id);
    return message;
  }

  @Override
  public Collection<User> getUsers(int count) {
    List<User> users = getSimpleJdbcTemplate().query(GET_USERS_SQL, userRowMapper, count);
    return users;
  }

  @Override
  public Collection<Message> getMessagesByUserId(Long userId) {
    List<Message> messages = getSimpleJdbcTemplate().query(GET_MESSAGES_BY_USERID_SQL, messageRowMapper, userId);
    return messages;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public boolean addUser(User user) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("uname", user.getUsername());
    paramMap.put("passwd", user.getPassword());
    paramMap.put("joinDate", user.getJoinDate());
    paramMap.put("recvEmail", user.isReceiveEmail());
    
    int count = getSimpleJdbcTemplate().update(INSERT_USER_SQL, paramMap);
    return count == 1;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public boolean addMessage(Message message) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("txt", message.getContent());
    paramMap.put("creationDate", message.getCreationDate());
    paramMap.put("userId", message.getUserId());
    
    int count = getSimpleJdbcTemplate().update(INSERT_MESSAGE_SQL, paramMap);
    return count == 1;
  }
  
  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public boolean updateUser(User user) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", user.getId());
    paramMap.put("passwd", user.getPassword());
    paramMap.put("recvEmail", user.isReceiveEmail());
    
    int count = getSimpleJdbcTemplate().update(UPDATE_USER_SQL, paramMap);
    
    return count == 1;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public boolean deleteUser(Long id) {
    int count = getSimpleJdbcTemplate().update(DELETE_USER_SQL, id);
    return count == 1;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public boolean updateMessage(Message message) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("id", message.getId());
    paramMap.put("txt", message.getContent());
    
    int count = getSimpleJdbcTemplate().update(UPDATE_MESSAGE_SQL, paramMap);
    return count == 1;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public boolean deleteMessage(Long id) { 
    int count = getSimpleJdbcTemplate().update(DELETE_MESSAGE_SQL, id);
    return count == 1;
  }
  
  private static class MessageRowMapper implements RowMapper<Message> {
    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
      Message message = new Message();
      message.setId(rs.getLong("id"));
      message.setContent(rs.getString("content"));
      message.setCreationDate(rs.getDate("created_on"));
      message.setUserId(rs.getLong("user_id"));
      
      return message;
    }
  }
  
  private static class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setId(rs.getLong("id"));
      user.setUsername(rs.getString("username"));
      user.setPassword(rs.getString("password"));
      user.setJoinDate(rs.getDate("join_date"));
      user.setReceiveEmail(rs.getBoolean("receive_email"));
      
      return user;
    }
  }
}

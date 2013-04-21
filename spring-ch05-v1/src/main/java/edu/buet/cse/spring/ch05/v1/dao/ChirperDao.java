package edu.buet.cse.spring.ch05.v1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import edu.buet.cse.spring.ch05.v1.model.Message;
import edu.buet.cse.spring.ch05.v1.model.User;

public class ChirperDao {
  public static final int MAX_MESSAGES = 10;
  private static final String SELECT_USER_QUERY = "SELECT * FROM User WHERE id = ?";
  private static final String SELECT_MESSAGE_QUERY = "SELECT * FROM Message WHERE id = :msgId";
  private static final String SELECT_LATEST_MESSAGES_QUERY = "SELECT * FROM Message ORDER BY id DESC LIMIT ?";
  private final UserRowMapper userRowMapper = new UserRowMapper();
  private final MessageRowMapper messageRowMapper = new MessageRowMapper();
  private final SimpleJdbcTemplate jdbcTemplate;

  public ChirperDao(SimpleJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public User getUser(Long id) {
    User user = jdbcTemplate.queryForObject(SELECT_USER_QUERY, userRowMapper, id);
    return user;
  }

  public Message getMessage(Long id) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("msgId", id);
    Message message = jdbcTemplate.queryForObject(SELECT_MESSAGE_QUERY, messageRowMapper, paramMap);
    
    return message;
  }
    
  public List<Message> getLatestMessages(int count) {
    if (count < 0) {
      return Collections.emptyList();
    }
    
    if (count > MAX_MESSAGES) {
      count = MAX_MESSAGES;
    }
    
    return jdbcTemplate.query(SELECT_LATEST_MESSAGES_QUERY, messageRowMapper, count);
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

  private static class MessageRowMapper implements RowMapper<Message> {
    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
      Message message = new Message();
      message.setId(rs.getLong("id"));
      message.setCreationDate(rs.getDate("created_on"));
      message.setContent(rs.getString("content"));
      message.setUserId(rs.getLong("user_id"));

      return message;
    }
  }
}

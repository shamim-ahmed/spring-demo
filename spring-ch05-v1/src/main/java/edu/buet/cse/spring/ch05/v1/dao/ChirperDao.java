package edu.buet.cse.spring.ch05.v1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import edu.buet.cse.spring.ch05.v1.model.Message;
import edu.buet.cse.spring.ch05.v1.model.User;

public class ChirperDao {
  private static final String SELECT_USER_QUERY = "SELECT * FROM User WHERE id = ?";
  private static final String SELECT_MESSAGE_QUERY = "SELECT * FROM Message WHERE id = ?";
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
    Message message = jdbcTemplate.queryForObject(SELECT_MESSAGE_QUERY, messageRowMapper, id);
    return message;
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

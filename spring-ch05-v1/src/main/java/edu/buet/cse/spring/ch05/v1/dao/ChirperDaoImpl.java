package edu.buet.cse.spring.ch05.v1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import edu.buet.cse.spring.ch05.v1.model.Message;
import edu.buet.cse.spring.ch05.v1.model.User;

public class ChirperDaoImpl implements ChirperDao {
  public static final int MAX_MESSAGES = 10;
  private static final String DATE_FORMAT = "yyyy-MM-dd";
  private static final String SELECT_USER_SQL = "SELECT * FROM User WHERE id = ?";
  private static final String CREATE_USER_SQL = "INSERT INTO User(username, password, join_date, receive_email) VALUES (?, ?, ?, ?)";
  private static final String SELECT_MESSAGE_SQL = "SELECT * FROM Message WHERE id = :msgId";
  private static final String SELECT_LATEST_MESSAGES_SQL = "SELECT * FROM Message ORDER BY id DESC LIMIT ?";
  private static final String CREATE_MESSAGE_SQL = "INSERT INTO Message(content, created_on, user_id) VALUES (:msgText, :createdDate, :uId)";
  private final UserRowMapper userRowMapper = new UserRowMapper();
  private final MessageRowMapper messageRowMapper = new MessageRowMapper();
  private final SimpleJdbcTemplate jdbcTemplate;

  public ChirperDaoImpl(SimpleJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public User getUser(Long id) {
    User user = jdbcTemplate.queryForObject(SELECT_USER_SQL, userRowMapper, id);
    return user;
  }

  @Override
  public Message getMessage(Long id) {
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("msgId", id);
    Message message = jdbcTemplate.queryForObject(SELECT_MESSAGE_SQL, messageRowMapper, paramMap);

    return message;
  }

  @Override
  public boolean createUser(User user) {
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    int count = jdbcTemplate.update(CREATE_USER_SQL, user.getUsername(), user.getPassword(), dateFormat.format(user.getJoinDate()), user.isReceiveEmail());
    return count == 1;
  }

  @Override
  public boolean createMessage(Message message) {
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("msgText", message.getContent());
    paramMap.put("createdDate", dateFormat.format(message.getCreationDate()));
    paramMap.put("uId", message.getUserId());
    
    int count = jdbcTemplate.update(CREATE_MESSAGE_SQL, paramMap);
    return count == 1;
  }

  @Override
  public List<Message> getLatestMessages(int count) {
    if (count < 0) {
      return Collections.emptyList();
    }

    if (count > MAX_MESSAGES) {
      count = MAX_MESSAGES;
    }

    return jdbcTemplate.query(SELECT_LATEST_MESSAGES_SQL, messageRowMapper, count);
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

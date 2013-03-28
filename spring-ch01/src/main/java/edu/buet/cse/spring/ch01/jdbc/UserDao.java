package edu.buet.cse.spring.ch01.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UserDao {
  private static final String USER_QUERY = "SELECT * FROM Users WHERE userId = :id";
  private final UserMapper userMapper = new UserMapper();
  private final SimpleJdbcTemplate simpleJdbcTemplate;
  
  public UserDao(SimpleJdbcTemplate simpleJdbcTemplate) {
	this.simpleJdbcTemplate = Objects.requireNonNull(simpleJdbcTemplate);
  }
  
  public User getUser(long id) {
	Map<String, Object> paramMap = new HashMap<>();
	paramMap.put("id", id);
	
	return simpleJdbcTemplate.queryForObject(USER_QUERY, userMapper, paramMap);
  }
  
  private static class UserMapper implements RowMapper<User> {
	@Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	  User user = new User();
	  user.setId(rs.getLong("userId"));
	  user.setUsername(rs.getString("username"));
	  user.setPassword(rs.getString("password"));
	  
	  return user;
    }	
  }
}

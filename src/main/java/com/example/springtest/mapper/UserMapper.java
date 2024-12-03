package com.example.springtest.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.springtest.model.User;

@Component
public class UserMapper implements RowMapper<User>{
    
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("password"),
            rs.getString("roles")
            );
    }
}

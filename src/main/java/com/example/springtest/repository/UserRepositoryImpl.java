package com.example.springtest.repository;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springtest.mapper.UserMapper;
import com.example.springtest.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    String SQL_GET_USER_BY_ID = "select * from userTable where id=:id";

    private final UserMapper userMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(UserMapper userMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.userMapper = userMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> getUserById(int personId) {
        var params = new MapSqlParameterSource();
        params.addValue("id", personId);
        return jdbcTemplate.query(
                SQL_GET_USER_BY_ID,
                params,
                userMapper).stream()
                .findFirst();

    }

}

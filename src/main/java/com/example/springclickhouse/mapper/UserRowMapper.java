package com.example.springclickhouse.mapper;

import com.example.springclickhouse.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"));
    }
}

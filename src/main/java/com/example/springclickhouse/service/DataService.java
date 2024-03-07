package com.example.springclickhouse.service;

import com.example.springclickhouse.mapper.UserRowMapper;
import com.example.springclickhouse.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DataService {

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper mapper;

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM allUsers", mapper);
    }

}

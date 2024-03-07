package com.example.springclickhouse.controller;

import com.example.springclickhouse.advice.MeasureTime;
import com.example.springclickhouse.model.User;
import com.example.springclickhouse.service.DataService;
import com.example.springclickhouse.service.GeneratorService;
import com.example.springclickhouse.service.PublishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DataController {

    private final DataService dataService;
    private final GeneratorService generatorService;
    private final PublishService publishService;

    @MeasureTime
    @GetMapping("/generate")
    public void generate() {

        log.info("Starting to generate data");

        Set<User> users = generatorService.generateData(100_000);
        users.forEach(publishService::publish);

        log.info("Data generated and published");

    }

    @MeasureTime
    @GetMapping("/users")
    public List<User> getUsers() {
        return dataService.getUsers();
    }
}

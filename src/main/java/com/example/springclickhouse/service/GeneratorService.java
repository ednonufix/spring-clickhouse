package com.example.springclickhouse.service;

import com.example.springclickhouse.model.User;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GeneratorService {

    private static final Faker faker = new Faker();

    public Set<User> generateData(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> new User(faker.internet().uuid(),
                                    faker.name().fullName(),
                                    faker.internet().emailAddress(),
                                    faker.internet().password()))
            .collect(Collectors.toSet());
    }

}

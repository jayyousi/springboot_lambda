package com.lambda.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.lambda.model.Response;
import com.lambda.persistence.entity.User;
import com.lambda.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Response handleRequest(Map input, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("received : " + input);

        if (userRepository.count() == 0) {

            logger.log("Table Empty . . . Creating new data");

            userRepository.save(new User("Jack", "Bauer"));
            userRepository.save(new User("Chloe", "O'Brian"));
            userRepository.save(new User("Kim", "Bauer"));
            userRepository.save(new User("David", "Palmer"));
            userRepository.save(new User("Michelle", "Dessler"));
        } else {
            // fetch all customers
            logger.log("Users found with findAll():");
            logger.log("-------------------------------");
            for (User user : userRepository.findAll()) {
                logger.log(user.toString());
            }
            logger.log("");
        }

        // fetch customers by last name
        logger.log("User found with findByLastName('Bauer'):");
        logger.log("--------------------------------------------");
        for (User user : userRepository.findByLastName("Bauer")) {
            logger.log(user.toString());
        }
        logger.log("");

        Response response = new Response();
        response.setMessage("Hello, User");
        response.setStatus(Response.Status.OK);

        return response;
    }
}

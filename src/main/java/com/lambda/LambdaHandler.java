package com.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lambda.model.Response;
import com.lambda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = "com.lambda")
@EnableJpaRepositories(basePackages = {"com.lambda.persistence.repository"})
public class LambdaHandler implements RequestHandler<Map, Response> {

    static void main(String[] args) throws Exception {
        new LambdaHandler().getApplicationContext(args);
    }

    ApplicationContext getApplicationContext(String[] args) {
        return SpringApplication.run(LambdaHandler.class, args);
    }

    @Override
    public Response handleRequest(Map input, Context context) {

        String[] test = new String[0];

        UserService userService = getApplicationContext(test).getBean(UserService.class);
        return userService.handleRequest(input, context);
    }
}
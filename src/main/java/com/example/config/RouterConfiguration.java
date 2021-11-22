package com.example.config;

import com.example.service.EmployeeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

    @Autowired
    private EmployeeHandler employeeHandler;

    @Bean
    public RouterFunction<ServerResponse> loadEmployeeData(){
        return RouterFunctions.route()
                .GET("/emp/data",employeeHandler::getMonoData)
                .GET("emp/data/{input}",employeeHandler::getSigleData)
                .POST("emp/data",employeeHandler::postData).build();
    }
}

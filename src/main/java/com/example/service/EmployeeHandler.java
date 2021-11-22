package com.example.service;

import com.example.dao.EmployeeDao;
import com.example.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    public Mono<ServerResponse> getMonoData(ServerRequest request){
       Flux<Employee> emp =  employeeDao.getFluxStreamsEmployees();
      return ServerResponse.ok()
              .contentType(MediaType.TEXT_EVENT_STREAM)
              .body(emp,Employee.class);
    }

    public Mono<ServerResponse> getSigleData(ServerRequest request){
       int id = Integer.valueOf(request.pathVariable("input"));
       Mono<Employee> emp = employeeDao.getFluxStreamsEmployees().filter(x->x.getId()==id).next();
       return ServerResponse.ok().body(emp,Employee.class);
    }

    public Mono<ServerResponse> postData(ServerRequest request){
        Mono<Employee> employeeMono = request.bodyToMono(Employee.class);
        Mono<String> map = employeeMono.map(x -> x.getId() + "- " + x.getName());
        return ServerResponse.ok().body(map,String.class);
    }
}

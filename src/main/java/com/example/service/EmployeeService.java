package com.example.service;

import com.example.dao.EmployeeDao;
import com.example.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    public List<Employee> getEmployeeData(){
        long start = System.currentTimeMillis();
        List<Employee> list= employeeDao.getEmployees();
        long end = System.currentTimeMillis();
        System.out.println("Total time difference"+(end-start));
        return list;
    }

    public Flux<Employee> getStreamData(){
        long start = System.currentTimeMillis();
        Flux<Employee> list= employeeDao.getFluxStreamsEmployees();
        long end = System.currentTimeMillis();
        System.out.println("Total time difference"+(end-start));
        return list;
    }
}

package com.example.dao;

import com.example.dto.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class EmployeeDao {

    public static void sleep(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<Employee> getEmployees(){
        return IntStream.rangeClosed(1,20)
                .peek(EmployeeDao::sleep)
                .peek(i-> System.out.println("processing count "+i))
                .mapToObj(i->new Employee(i,"Employee "+i))
                .collect(Collectors.toList());
    }

    public Flux<Employee> getFluxStreamsEmployees(){
        return Flux.range(1,20)
                .delayElements(Duration.ofMillis(1000))
                .doOnNext(i-> System.out.println("processing count "+i))
                .map(i->new Employee(i,"Employee "+i));
    }
}

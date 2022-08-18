package com.example.datajpaquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CompanyApplication.class, args);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        employeeRepository.save(new Employee(1L, "Jan", "Kowalski", 1000.0));
        employeeRepository.save(new Employee(2L, "Marta", "Pies", 12000.0));
        employeeRepository.save(new Employee(3L, "Paweł", "Kot", 13000.0));
        employeeRepository.save(new Employee(4L, "Kasia", "Bon", 4000.0));

        System.out.println(">>> Pracownicy po podwyżce");
        employeeRepository.giveRiseToAll();
        employeeRepository.findAll().forEach(System.out::println);

        System.out.println(">>> Bogaci pracownicy");
        employeeRepository.findRichEmployees().forEach(System.out::println);

        System.out.println(">>> Pracownicy zarabiający pomiędzy 3k i 5k");
        employeeRepository.findBySalaryInRange(3000, 5000).forEach(System.out::println);

    }

}

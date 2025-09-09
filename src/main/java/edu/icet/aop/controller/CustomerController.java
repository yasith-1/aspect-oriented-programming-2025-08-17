package edu.icet.aop.controller;

import edu.icet.aop.annotation.LogExecutionTime;
import edu.icet.aop.model.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    //    Method one using @PathVariable
    @GetMapping("/info/{nic}")
    @LogExecutionTime
    public Customer getCustomerInfoM1(@PathVariable String nic) {
        return new Customer("yasiya", nic);
    }

    // Method two using @RequestParam , Sometimes some string can't send as path variable in this time we can use @RequestParam
    // if required = true then it is mandatory to pass the parameter
    // if required = false then it is optional to pass the parameter
    // Example URL: localhost:8080/customer/info?nic=125478521&name=yasiya
    @GetMapping("/info")
    @LogExecutionTime
    public Customer getCustomerInfoM2(@RequestParam String nic, @RequestParam(required = true) String name) {
        return new Customer(name, nic);
    }

    //localhost:8080/customer/info/20025700817?name=yasiya
    @GetMapping("/allInfo/{nic}")
    @LogExecutionTime
    public Customer combinedAboveMethod(@PathVariable String nic, @RequestParam String name) {
        return new Customer(name, nic);
    }

}

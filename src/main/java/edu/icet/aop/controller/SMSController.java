package edu.icet.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@Slf4j
public class SMSController {

    @PostMapping("/send/{mobile}")
    public void sendSMS(@PathVariable String mobile) {
        log.info("Your mobile number recived : {} ", mobile);
    }
}

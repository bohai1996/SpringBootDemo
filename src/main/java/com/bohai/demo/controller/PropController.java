package com.bohai.demo.controller;

import com.bohai.demo.properties.MyProperties1;
import com.bohai.demo.properties.MyProperties2;
import com.bohai.demo.properties.Myprop1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/prop")
@RestController
public class PropController {

    private static final Logger log = LoggerFactory.getLogger(PropController.class);

    private final MyProperties1 myProperties1;
    private final MyProperties2 myProperties2;

    @Autowired
    public PropController(MyProperties1 myProperties1, MyProperties2 myProperties2) {
        this.myProperties1 = myProperties1;
        this.myProperties2 = myProperties2;
    }

    @Value("${my1.name}")
    private String my1Name;

    @Autowired
    private Myprop1 myprop1;

    @GetMapping("/1")
    public MyProperties1 getMyProperties1() {

        log.info("==============================================");
        log.info(myProperties1.toString());
        log.info(myprop1.toString());
        log.info(my1Name);
        log.info("==============================================");

        return myProperties1;
    }

    @GetMapping("/2")
    public MyProperties2 myProperties2() {
        log.info("=================================================================================================");
        log.info(myProperties2.toString());
        log.info("=================================================================================================");
        return myProperties2;
    }
}

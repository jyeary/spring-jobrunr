package com.example.jobrunr.controller;

import com.example.jobrunr.service.SchedulingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 */
@RestController
@Slf4j
public class JobSchedulingController {

    @Autowired
    private SchedulingService scheduler;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String index() {
        return "{ \"usage\":\"Send an empty POST to the base URL\"}";
    }

    @PostMapping("/")
    public ResponseEntity<String> schedule() {
        log.info("POST Request to schedule job");
        scheduler.schedule();
        return ResponseEntity.status(HttpStatusCode.valueOf(202)).build();
    }

}

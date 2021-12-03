package it.core.facilitator.boot.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/boot")
public class BootController {

    @GetMapping(value = "/api")
    public ResponseEntity<Object> checkAssistenza() throws IOException {

      	return new ResponseEntity<Object>("ok", HttpStatus.OK);
    }

	
}

package it.core.facilitator.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.core.facilitator.boot.service.IBootService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class BootController {
	
	@Autowired
	IBootService bootService;
  	
	/**
	 * method that return qrcode png from string
	 * @param content - text in string format
	 * @return png resource
	 */
  	@GetMapping(value = "/qrcode", params = {"content!="}, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> qrCodeGenerator(@RequestParam String content) {
  		log.info("content {}", content);
        ByteArrayResource inputStream = bootService.getImageFromText(content);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }
	
}

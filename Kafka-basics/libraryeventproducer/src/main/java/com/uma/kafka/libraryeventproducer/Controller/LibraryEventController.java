package com.uma.kafka.libraryeventproducer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uma.kafka.libraryeventproducer.domain.LibraryEvent;
import com.uma.kafka.libraryeventproducer.producer.LibraryEventsProducer;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LibraryEventController {
	@Autowired
	LibraryEventsProducer le;
	
	@PostMapping("v1/libraryevent")
	public ResponseEntity<LibraryEvent> postlibraryevent(@RequestBody  LibraryEvent libraryevent){
		log.info("libraryevent"+ libraryevent);
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryevent);
	}
	@PostMapping("v1/sendlibraryevent")
	public ResponseEntity<LibraryEvent> sendlibraryevent(@RequestBody  LibraryEvent libraryevent) throws JsonProcessingException{
		log.info("libraryevent"+ libraryevent);
		le.sendLibraryevent(libraryevent);
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryevent);
	}

}

package com.uma.kafka.libraryeventproducer.producer;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uma.kafka.libraryeventproducer.domain.LibraryEvent;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.support.SendResult;

@Component
@Slf4j
public class LibraryEventsProducer {
	
	private final KafkaTemplate<Integer,String> kafkatempalte;
	@Value("${spring.kafka.topic}")
	private String topic;
	
	ObjectMapper objectmapper;//used to convert json to string

	public LibraryEventsProducer(KafkaTemplate<Integer, String> kafkatempalte) {
		super();
		this.kafkatempalte = kafkatempalte;
	}
	public CompletableFuture sendLibraryevent(LibraryEvent l) throws JsonProcessingException {
		var key =l.libraryEventId();
		var value= objectmapper.writeValueAsString(l);
		var cf= kafkatempalte.sendDefault( key, value);//this will return completable future ,return in future ,run in backgroug4
		//handle suc and failure on completion,completablefuture has method called whencomplete method,use this 
		 return cf.whenComplete( (sendResult, throwable)->{
			if(throwable!=null) {
				handleFailure(key,value,throwable);
			}else {
				handlesucess(key,value,sendResult);
			}
		});
		
	}
	private void handlesucess(Integer key, String value, SendResult<Integer, String> sendResult) {
		
		// TODO Auto-generated method stub
		
		log.info("sending message su"+key ,value,sendResult.getRecordMetadata().partition());
	}
	private void handleFailure(Integer key, String value, Throwable th) {
		// TODO Auto-generated method stub
		log.error("error sending message", th.getMessage(),th);
		
	}

}

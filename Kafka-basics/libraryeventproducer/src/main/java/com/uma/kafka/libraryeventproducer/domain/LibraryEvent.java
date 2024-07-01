package com.uma.kafka.libraryeventproducer.domain;

public record LibraryEvent(
	Integer libraryEventId,
	LibraryEventType libraryEventType,
	Book book
		) {

}

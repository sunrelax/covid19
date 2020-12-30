package it.gc.covid19.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.gc.covid19.document.NotaDoc;

public interface NotaRep extends MongoRepository<NotaDoc, String> {

}

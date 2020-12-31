package it.gc.covid19.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.gc.covid19.document.RegioneDoc;

public interface RegioneRep extends MongoRepository<RegioneDoc, String> {

}

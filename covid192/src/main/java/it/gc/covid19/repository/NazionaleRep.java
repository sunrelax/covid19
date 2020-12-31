package it.gc.covid19.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.gc.covid19.document.NazionaleDoc;

public interface NazionaleRep extends MongoRepository<NazionaleDoc, String> {

}

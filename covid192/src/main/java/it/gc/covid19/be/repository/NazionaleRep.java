package it.gc.covid19.be.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.gc.covid19.be.document.NazionaleDoc;

public interface NazionaleRep extends MongoRepository<NazionaleDoc, String> {

}

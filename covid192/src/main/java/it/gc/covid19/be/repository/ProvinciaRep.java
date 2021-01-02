package it.gc.covid19.be.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.gc.covid19.be.document.ProvinciaDoc;

public interface ProvinciaRep extends MongoRepository<ProvinciaDoc, String> {

}

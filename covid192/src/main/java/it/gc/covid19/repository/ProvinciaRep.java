package it.gc.covid19.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.gc.covid19.document.ProvinciaDoc;

public interface ProvinciaRep extends MongoRepository<ProvinciaDoc, String> {

}

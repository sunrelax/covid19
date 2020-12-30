
package it.gc.covid19.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import it.gc.covid19.document.NotaDoc;

@Service
public class NotaMongoSer {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<NotaDoc> getNote() {
		return mongoTemplate.findAll(NotaDoc.class, "note");
	}

}

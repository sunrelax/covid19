
package it.gc.covid19.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.gc.covid19.document.NotaDoc;

@Service
public class NotaMSer {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<NotaDoc> getNote() {
		return mongoTemplate.findAll(NotaDoc.class, "note");
	}

	public List<NotaDoc> getNoteDa(String dataDa) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa));
		List<NotaDoc> note = mongoTemplate.find(query, NotaDoc.class);
		return note;
	}

	public List<NotaDoc> getNoteA(String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").lte(dataA));
		List<NotaDoc> note = mongoTemplate.find(query, NotaDoc.class);
		return note;
	}

	public List<NotaDoc> getNote(String dataDa, String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa).lte(dataA));
		List<NotaDoc> note = mongoTemplate.find(query, NotaDoc.class);
		return note;
	}

}

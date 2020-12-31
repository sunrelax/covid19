
package it.gc.covid19.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.gc.covid19.document.NazionaleDoc;

@Service
public class NazionaleMSer {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<NazionaleDoc> getNote() {
		return mongoTemplate.findAll(NazionaleDoc.class, "note");
	}

	public List<NazionaleDoc> getNoteDa(String dataDa) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa));
		List<NazionaleDoc> nazionali = mongoTemplate.find(query, NazionaleDoc.class);
		return nazionali;
	}

	public List<NazionaleDoc> getNoteA(String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").lte(dataA));
		List<NazionaleDoc> nazionali = mongoTemplate.find(query, NazionaleDoc.class);
		return nazionali;
	}

	public List<NazionaleDoc> getNote(String dataDa, String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa).lte(dataA));
		List<NazionaleDoc> nazionali = mongoTemplate.find(query, NazionaleDoc.class);
		return nazionali;
	}

}

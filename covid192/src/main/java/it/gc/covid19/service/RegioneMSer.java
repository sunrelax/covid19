
package it.gc.covid19.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.gc.covid19.document.RegioneDoc;

@Service
public class RegioneMSer {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<RegioneDoc> getRegioni() {
		return mongoTemplate.findAll(RegioneDoc.class, "regioni");
	}

	public List<RegioneDoc> getRegioniDa(String dataDa) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa));
		List<RegioneDoc> regioni = mongoTemplate.find(query, RegioneDoc.class);
		return regioni;
	}

	public List<RegioneDoc> getRegioniA(String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").lte(dataA));
		List<RegioneDoc> regioni = mongoTemplate.find(query, RegioneDoc.class);
		return regioni;
	}

	public List<RegioneDoc> getRegioni(String dataDa, String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa).lte(dataA));
		List<RegioneDoc> regioni = mongoTemplate.find(query, RegioneDoc.class);
		return regioni;
	}

}

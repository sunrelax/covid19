
package it.gc.covid19.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.gc.covid19.document.ProvinciaDoc;

@Service
public class ProvinciaMSer {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<ProvinciaDoc> getProvince() {
		return mongoTemplate.findAll(ProvinciaDoc.class, "province");
	}

	public List<ProvinciaDoc> getProvinceDa(String dataDa) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa));
		List<ProvinciaDoc> province = mongoTemplate.find(query, ProvinciaDoc.class);
		return province;
	}

	public List<ProvinciaDoc> getProvinceA(String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").lte(dataA));
		List<ProvinciaDoc> province = mongoTemplate.find(query, ProvinciaDoc.class);
		return province;
	}

	public List<ProvinciaDoc> getProvince(String dataDa, String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa).lte(dataA));
		List<ProvinciaDoc> province = mongoTemplate.find(query, ProvinciaDoc.class);
		return province;
	}

}

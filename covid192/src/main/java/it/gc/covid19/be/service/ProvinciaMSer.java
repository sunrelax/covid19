
package it.gc.covid19.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.gc.covid19.be.document.ProvinciaDoc;

@Service
public class ProvinciaMSer {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<ProvinciaDoc> getProvince() {
		return mongoTemplate.findAll(ProvinciaDoc.class, "province");
	}

	public List<ProvinciaDoc> getProvince(List<Integer> codiciProvince) {
		Query query = new Query();
		query.addCriteria(Criteria.where("codice_provincia").in(codiciProvince));
		List<ProvinciaDoc> province = mongoTemplate.find(query, ProvinciaDoc.class);
		return province;
	}

	public List<ProvinciaDoc> getProvinceDa(List<Integer> codiciProvince, String dataDa) {
		Query query = new Query();
		query.addCriteria(Criteria.where("codice_provincia").in(codiciProvince));
		query.addCriteria(Criteria.where("data").gte(dataDa));
		List<ProvinciaDoc> province = mongoTemplate.find(query, ProvinciaDoc.class);
		return province;
	}

	public List<ProvinciaDoc> getProvinceA(List<Integer> codiciProvince, String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("codice_provincia").in(codiciProvince));
		query.addCriteria(Criteria.where("data").lte(dataA));
		List<ProvinciaDoc> province = mongoTemplate.find(query, ProvinciaDoc.class);
		return province;
	}

	public List<ProvinciaDoc> getProvince(List<Integer> codiciProvince, String dataDa, String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("codice_provincia").in(codiciProvince));
		query.addCriteria(Criteria.where("data").gte(dataDa).lte(dataA));
		List<ProvinciaDoc> province = mongoTemplate.find(query, ProvinciaDoc.class);
		return province;
	}
}

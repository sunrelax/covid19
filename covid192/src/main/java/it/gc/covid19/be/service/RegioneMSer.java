
package it.gc.covid19.be.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.gc.covid19.be.bean.RegioneComboB;
import it.gc.covid19.be.document.RegioneDoc;

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

//	public List<RegioneComboB> getRegioniKeyValue() {
//		List<String> codiciRegione = mongoTemplate.getCollection("regione").distinct("codice_regione", String.class).into(new ArrayList<String>());
//		List<RegioneComboB> regioniComboB = new ArrayList<RegioneComboB>();
//		for (RegioneDoc regioneDoc : regioni) {
//			RegioneComboB regioneComboB = new RegioneComboB();
//			BeanUtils.copyProperties(regioneDoc, regioneComboB);
//			regioniComboB.add(regioneComboB);
//		}
//		return regioniComboB;
//	}

}

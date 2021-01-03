
package it.gc.covid19.be.service;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import it.gc.covid19.be.util.Aggregation;
import it.gc.covid19.be.util.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.gc.covid19.be.document.NazionaleDoc;

@Service
public class NazionaleMSer {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<NazionaleDoc> getNazionali() {
		return mongoTemplate.findAll(NazionaleDoc.class, "nazionale");
	}

	public List<NazionaleDoc> getNazionaliDa(String dataDa) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(dataDa));
		List<NazionaleDoc> nazionali = mongoTemplate.find(query, NazionaleDoc.class);
		return nazionali;
	}

	public List<NazionaleDoc> getNazionaliA(String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").lte(dataA));
		List<NazionaleDoc> nazionali = mongoTemplate.find(query, NazionaleDoc.class);
		return nazionali;
	}

	public List<NazionaleDoc> getNazionali(String dataDa, String dataA) {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").lte(dataA).gte(dataDa));
		List<NazionaleDoc> nazionali = mongoTemplate.find(query, NazionaleDoc.class);
		return nazionali;
	}
	public List<NazionaleDoc> getCountryData(LocalDate form, LocalDate to, Type type, Aggregation agg)  {
		Query query = new Query();
		query.addCriteria(Criteria.where("data").gte(LocalDateTime.of(form, LocalTime.MIN).toString()).lte(LocalDateTime.of(to, LocalTime.MIN).toString()));
		List<NazionaleDoc> nazionali = mongoTemplate.find(query, NazionaleDoc.class);
		return nazionali;
	}

}

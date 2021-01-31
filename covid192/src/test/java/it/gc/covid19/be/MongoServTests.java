package it.gc.covid19.be;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.gc.covid19.be.document.NazionaleDoc;
import it.gc.covid19.be.document.NotaDoc;
import it.gc.covid19.be.document.ProvinciaDoc;
import it.gc.covid19.be.document.RegioneDoc;
import it.gc.covid19.be.service.NazionaleMSer;
import it.gc.covid19.be.service.NotaMSer;
import it.gc.covid19.be.service.ProvinciaMSer;
import it.gc.covid19.be.service.RegioneMSer;

@SpringBootTest
class MongoServTests {

	Logger logger = LoggerFactory.getLogger(MongoServTests.class);

	@Autowired
	private NazionaleMSer nazionaleMSer;
	@Autowired
	private NotaMSer notaMSer;
	@Autowired
	private ProvinciaMSer provinciaMSer;
	@Autowired
	private RegioneMSer regioneMSer;

	@Test
	public void findAllNazionaleDa() {
		List<NazionaleDoc> nazionali = nazionaleMSer.getNazionaliDa("2020-12-20T17:00:00");
		for (NazionaleDoc nazionale : nazionali) {
			logger.info(nazionale.toString());
		}
	}

	@Test
	public void findAllNote() {
		List<NotaDoc> note = notaMSer.getNote();
		for (NotaDoc nota : note) {
			logger.info(nota.getData() + " " + nota.getNote());
		}
	}

	@Test
	public void findAllNoteDataDa() {
		String dataDa = "2020-07-06T17:00:00";
		List<NotaDoc> note = notaMSer.getNoteDa(dataDa);
		for (NotaDoc nota : note) {
			logger.info(nota.getData() + " " + nota.getNote());
		}
	}

	@Test
	public void findAllProvince() {
		List<ProvinciaDoc> province = provinciaMSer.getProvince();
		TreeMap<String, String> elencoProvince = new TreeMap<String, String>();
		for (ProvinciaDoc provincia : province) {
			//elencoProvince.put(provincia.getCodice_provincia(), provincia.getDenominazioneProvincia());
			elencoProvince.put(provincia.getDenominazioneProvincia(), provincia.getCodiceProvincia());
		}
		Set<Entry<String, String>> setEntry = elencoProvince.entrySet();
		for(Entry<String, String> prov: setEntry) {
//			logger.info("ComboB " + StringUtils.lowerCase(prov.getKey()) + " = new ComboB(\"" + prov.getValue()
//					+ "\", \"" + prov.getKey() + "\");");
//			logger.info("ep.add(" + StringUtils.lowerCase(prov.getKey()) + ");");
//			Abruzzo(13, "Abruzzo")
			logger.info(prov.getKey() + "(" + prov.getValue() + ", \"" + prov.getKey() + "\"), ");
		}
		logger.info(elencoProvince.toString());
		
//		for (Integer i = 1; i < 150; i++) {
//			logger.info("ComboB " + StringUtils.lowerCase(elencoProvince.get(i.toString())) + " = new ComboB(\"" + i
//					+ "\", \"" + elencoProvince.get(i.toString()) + "\");");
//			logger.info("ep.add(" + StringUtils.lowerCase(elencoProvince.get(i.toString())) + ");");
//
//		}
//		elencoProvince.entrySet().forEach(entry -> {
//			logger.info(entry.getKey() + " " + entry.getValue());
//		});
	}

	@Test
	public void findAllRegioni() {
		List<RegioneDoc> regioni = regioneMSer.getRegioni();
		for (RegioneDoc regione : regioni) {
			logger.info(regione.toString());
		}
	}

	@Test
	public void findAllRegioni2() {
		List<Integer> cR = new ArrayList<Integer>();
		cR.add(13);
		List<RegioneDoc> regioni = regioneMSer.getRegioni(cR);
		for (RegioneDoc regione : regioni) {
			logger.info(regione.toString());
		}
	}


}
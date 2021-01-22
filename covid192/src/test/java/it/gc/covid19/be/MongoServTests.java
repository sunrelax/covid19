package it.gc.covid19.be;

import java.util.ArrayList;
import java.util.List;

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
		for (ProvinciaDoc provincia : province) {
			logger.info(provincia.toString());
		}
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
package it.gc.covid19.be;

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
import it.gc.covid19.be.repository.NazionaleRep;
import it.gc.covid19.be.repository.NotaRep;
import it.gc.covid19.be.repository.ProvinciaRep;
import it.gc.covid19.be.repository.RegioneRep;

@SpringBootTest
class RepositoryTests {
	
	Logger logger = LoggerFactory.getLogger(RepositoryTests.class);

	@Autowired
	private NazionaleRep nazionaleRep;
	@Autowired
	private NotaRep notaRep;
	@Autowired
	private ProvinciaRep provinciaRep;
	@Autowired
	private RegioneRep regioneRep;

	@Test
	public void findAllNazionale() {
		List<NazionaleDoc> nazionali = nazionaleRep.findAll();
		for (NazionaleDoc nazionale : nazionali) {
			logger.info(nazionale.toString());
		}
	}

	@Test
	public void findAllNote() {
		List<NotaDoc> note = notaRep.findAll();
		for (NotaDoc nota : note) {
			logger.info(nota.getData() + " " + nota.getNote());
		}
	}

	@Test
	public void findAllProvince() {
		List<ProvinciaDoc> province = provinciaRep.findAll();
		for (ProvinciaDoc provincia : province) {
			logger.info(provincia.toString());
		}
	}

	@Test
	public void findAllRegioni() {
		List<RegioneDoc> regioni = regioneRep.findAll();
		for (RegioneDoc regione : regioni) {
			logger.info(regione.toString());
		}
	}

}
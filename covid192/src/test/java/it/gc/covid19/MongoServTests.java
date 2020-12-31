package it.gc.covid19;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.gc.covid19.document.NazionaleDoc;
import it.gc.covid19.document.NotaDoc;
import it.gc.covid19.document.ProvinciaDoc;
import it.gc.covid19.document.RegioneDoc;
import it.gc.covid19.repository.NazionaleRep;
import it.gc.covid19.repository.NotaRep;
import it.gc.covid19.repository.ProvinciaRep;
import it.gc.covid19.repository.RegioneRep;
import it.gc.covid19.service.NotaMSer;

@SpringBootTest
class MongoServTests {

	@Autowired
	private NotaMSer notaMongoSer;
	@Autowired
	private NotaRep notaRep;
	@Autowired
	private ProvinciaRep provinciaRep;
	@Autowired
	private RegioneRep regioneRep;

//	@Test
//	public void findAllNazionale() {
//		List<NazionaleDoc> nazionali = nazionaleRep.findAll();
//		for(NazionaleDoc nazionale: nazionali) {
//			System.out.println(nazionale.toString());
//		}
//	}
	
//	@Test
//	public void findAllNote() {
//		List<NotaDoc> note = notaMongoSer.getNote();
//		for(NotaDoc nota: note) {
//			System.out.println(nota.getData() + " " + nota.getNote());
//		}
//	}
	
	@Test
	public void findAllNoteDataDa() {
		String dataDa = "2020-07-06T17:00:00";
		List<NotaDoc> note = notaMongoSer.getNote(dataDa);
		for(NotaDoc nota: note) {
			System.out.println(nota.getData() + " " + nota.getNote());
		}
	}
	
//	@Test
//	public void findAllProvince() {
//		List<ProvinciaDoc> province = provinciaRep.findAll();
//		for(ProvinciaDoc provincia: province) {
//			System.out.println(provincia.toString());
//		}
//	}
//	
//	@Test
//	public void findAllRegioni() {
//		List<RegioneDoc> regioni = regioneRep.findAll();
//		for(RegioneDoc regione: regioni) {
//			System.out.println(regione.toString());
//		}
//	}

}
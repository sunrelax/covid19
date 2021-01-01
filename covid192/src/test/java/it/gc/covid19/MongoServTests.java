package it.gc.covid19;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.gc.covid19.document.NazionaleDoc;
import it.gc.covid19.document.NotaDoc;
import it.gc.covid19.document.ProvinciaDoc;
import it.gc.covid19.document.RegioneDoc;
import it.gc.covid19.service.NazionaleMSer;
import it.gc.covid19.service.NotaMSer;
import it.gc.covid19.service.ProvinciaMSer;
import it.gc.covid19.service.RegioneMSer;

@SpringBootTest
class MongoServTests {

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
			System.out.println(nazionale.toString());
		}
	}

	@Test
	public void findAllNote() {
		List<NotaDoc> note = notaMSer.getNote();
		for (NotaDoc nota : note) {
			System.out.println(nota.getData() + " " + nota.getNote());
		}
	}

	@Test
	public void findAllNoteDataDa() {
		String dataDa = "2020-07-06T17:00:00";
		List<NotaDoc> note = notaMSer.getNoteDa(dataDa);
		for (NotaDoc nota : note) {
			System.out.println(nota.getData() + " " + nota.getNote());
		}
	}

	@Test
	public void findAllProvince() {
		List<ProvinciaDoc> province = provinciaMSer.getProvince();
		for (ProvinciaDoc provincia : province) {
			System.out.println(provincia.toString());
		}
	}

	@Test
	public void findAllRegioni() {
		List<RegioneDoc> regioni = regioneMSer.getRegioni();
		for (RegioneDoc regione : regioni) {
			System.out.println(regione.toString());
		}
	}

}
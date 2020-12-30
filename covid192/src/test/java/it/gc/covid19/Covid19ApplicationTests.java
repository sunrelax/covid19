package it.gc.covid19;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.gc.covid19.document.NotaDoc;
import it.gc.covid19.repository.NotaRep;

@SpringBootTest
class Covid19ApplicationTests {

	@Autowired
	private NotaRep notaRep;

	@Test
	public void findAllNote() {
		List<NotaDoc> note = notaRep.findAll();
		for(NotaDoc nota: note) {
			System.out.println(nota.getData() + " " + nota.getNote());
		}
		System.out.println("Note " + note);
	}

}
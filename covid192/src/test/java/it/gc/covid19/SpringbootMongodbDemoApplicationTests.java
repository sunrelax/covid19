package it.gc.covid19;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import it.gc.covid19.document.NotaDoc;
import it.gc.covid19.repository.NotaRep;

/**
 * @author Siva
 *
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest
@DataMongoTest
public class SpringbootMongodbDemoApplicationTests {

	@Autowired
	private NotaRep notaRep;

	@Test
	public void findAllUsers() {
		List<NotaDoc> note = notaRep.findAll();
		System.out.println("Note " + note);
	}

}

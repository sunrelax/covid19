package it.gc.covid19.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "nazionale")
public class NazionaleDoc {
	@Id
	private String id;
	private String data;
	private String stato;
}

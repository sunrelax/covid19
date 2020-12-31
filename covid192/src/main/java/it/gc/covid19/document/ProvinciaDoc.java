package it.gc.covid19.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "province")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProvinciaDoc {

	@Id
	private String id;
	private String data;
	private String stato;
	private String codice_regione;
	private String denominazione_regione;
	private String codice_provincia;
	private String denominazione_provincia;
	private String lat;
	@Field(value = "long")
	private String longitudine;
	private String totale_casi;
	private String note;

}

package it.gc.covid19.be.document;

import it.gc.covid19.be.util.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Document(collection = "nazionale")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class NazionaleDoc {
	@Id
	private String id;
	private String data;
	private String stato;
	private String ricoverati_con_sintomi;
	private String terapia_intensiva;
	private String totale_ospedalizzati;
	private String isolamento_domiciliare;
	private String totale_positivi;
	private String variazione_totale_positivi;
	private String nuovi_positivi;
	private String dimessi_guariti;
	private String deceduti;
	private String casi_da_sospetto_diagnostico;
	private String casi_da_screening;
	private String totale_casi;
	private String tamponi;
	private String casi_testati;
	private String note;
	private String ingressi_terapia_intensiva;
	private String note_test;
	private String note_casi;

}

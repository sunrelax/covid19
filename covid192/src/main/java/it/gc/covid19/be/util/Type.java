package it.gc.covid19.be.util;

import it.gc.covid19.be.document.NazionaleDoc;

import java.lang.reflect.Method;
import java.util.Optional;

public enum Type {
	ricoverati_con_sintomi("getRicoverati_con_sintomi"), terapia_intensiva("getTerapia_intensiva"),
	totale_ospedalizzati("getTotale_ospedalizzati"), isolamento_domiciliare("getIsolamento_domiciliare"),
	totale_positivi("getTotale_positivi"), variazione_totale_positivi("getVariazione_totale_positivi"),
	nuovi_positivi("getNuovi_positivi"), dimessi_guariti("getDimessi_guariti"), deceduti("getDeceduti"),
	casi_da_sospetto_diagnostico("getCasi_da_sospetto_diagnostico"), casi_da_screening("getCasi_da_screening"),
	totale_casi("getTotale_casi"), tamponi("getTamponi"), casi_testati("getCasi_testati"), note("getNote"),
	ingressi_terapia_intensiva("getIngressi_terapia_intensiva");

	private String metodo;

	private Type(String metodo) {
		this.metodo = metodo;
	}

	public String getMetodo() {
		return metodo;
	}

	public String getValue(NazionaleDoc nazionaleDoc){
		try {
			Method method = NazionaleDoc.class.getMethod(getMetodo());
			return (String)method.invoke(nazionaleDoc);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}

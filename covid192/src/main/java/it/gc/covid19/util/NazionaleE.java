package it.gc.covid19.util;

public enum NazionaleE {
	ricoverati_con_sintomi("getRicoverati_con_sintomi"), terapia_intensiva("getTerapia_intensiva"),
	totale_ospedalizzati("getTotale_ospedalizzati"), isolamento_domiciliare("getIsolamento_domiciliare"),
	totale_positivi("getTotale_positivi"), variazione_totale_positivi("getVariazione_totale_positivi"),
	nuovi_positivi("getNuovi_positivi"), dimessi_guariti("getDimessi_guariti"), deceduti("getDeceduti"),
	casi_da_sospetto_diagnostico("getCasi_da_sospetto_diagnostico"), casi_da_screening("getCasi_da_screening"),
	totale_casi("getTotale_casi"), tamponi("getTamponi"), casi_testati("getCasi_testati"), note("getNote"),
	ingressi_terapia_intensiva("getIngressi_terapia_intensiva");

	private String metodo;

	private NazionaleE(String metodo) {
		this.metodo = metodo;
	}

	public String getMetodo() {
		return metodo;
	}

}

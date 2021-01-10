package it.gc.covid19.be.util;

public enum RegioniE {

	Abruzzo(13, "Abruzzo"), Basilicata(17, "Basilicata"), Calabria(18, "Calabria"), Campania(15, "Campania"),
	EmiliaRomagna(8, "Emilia-Romagna"), FriuliVeneziaGiulia(6, "Friuli Venezia Giulia"), Lazio(12, "Lazio"),
	Liguria(7, "Liguria"), Lombardia(3, "Lombardia"), Marche(11, "Marche"), Molise(14, "Molise"),
	PABolzano(21, "P.A. Bolzano"), PATrento(22, "P.A. Trento"), Piemonte(1, "Piemonte"), Puglia(16, "Puglia"),
	Sardegna(20, "Sardegna"), Sicilia(19, "Sicilia"), Toscana(9, "Toscana"), Umbria(10, "Umbria"),
	ValleDAosta(2, "Valle d'Aosta"), Veneto(5, "Veneto");

	private Integer codice;
	private String denominazione;

	private RegioniE(Integer codice, String denominazione) {
		this.codice = codice;
		this.denominazione = denominazione;
	}

	public Integer getCodice() {
		return codice;
	}

	public String getDenominazione() {
		return denominazione;
	}

}

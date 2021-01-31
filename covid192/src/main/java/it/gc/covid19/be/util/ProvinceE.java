package it.gc.covid19.be.util;

public enum ProvinceE {

	Agrigento(84, "Agrigento"), Alessandria(6, "Alessandria"), Ancona(42, "Ancona"), Aosta(7, "Aosta"),
	Arezzo(51, "Arezzo"), AscoliPiceno(44, "Ascoli Piceno"), Asti(5, "Asti"), Avellino(64, "Avellino"),
	Bari(72, "Bari"), BarlettaAndriaTrani(110, "Barletta-Andria-Trani"), Belluno(25, "Belluno"),
	Benevento(62, "Benevento"), Bergamo(16, "Bergamo"), Biella(96, "Biella"), Bologna(37, "Bologna"),
	Bolzano(21, "Bolzano"), Brescia(17, "Brescia"), Brindisi(74, "Brindisi"), Cagliari(92, "Cagliari"),
	Caltanissetta(85, "Caltanissetta"), Campobasso(70, "Campobasso"), Caserta(61, "Caserta"), Catania(87, "Catania"),
	Catanzaro(79, "Catanzaro"), Chieti(69, "Chieti"), Como(13, "Como"), Cosenza(78, "Cosenza"), Cremona(19, "Cremona"),
	Crotone(101, "Crotone"), Cuneo(4, "Cuneo"), Enna(86, "Enna"), Fermo(109, "Fermo"), Ferrara(38, "Ferrara"),
	Firenze(48, "Firenze"), Foggia(71, "Foggia"), ForliCesena(40, "Forlì-Cesena"), Frosinone(60, "Frosinone"),
	Genova(10, "Genova"), Gorizia(31, "Gorizia"), Grosseto(53, "Grosseto"), Imperia(8, "Imperia"),
	Isernia(94, "Isernia"), LAquila(66, "L'Aquila"), LaSpezia(11, "La Spezia"), Latina(59, "Latina"),
	Lecce(75, "Lecce"), Lecco(97, "Lecco"), Livorno(49, "Livorno"), Lodi(98, "Lodi"), Lucca(46, "Lucca"),
	Macerata(43, "Macerata"), Mantova(20, "Mantova"), MassaCarrara(45, "Massa Carrara"), Matera(77, "Matera"),
	Messina(83, "Messina"), Milano(15, "Milano"), Modena(36, "Modena"), MonzaBrianza(108, "Monza e della Brianza"),
	Napoli(63, "Napoli"), Novara(3, "Novara"), Nuoro(91, "Nuoro"), Oristano(95, "Oristano"), Padova(28, "Padova"),
	Palermo(82, "Palermo"), Parma(34, "Parma"), Pavia(18, "Pavia"), Perugia(54, "Perugia"),
	PesaroUrbino(41, "Pesaro e Urbino"), Pescara(68, "Pescara"), Piacenza(33, "Piacenza"), Pisa(50, "Pisa"),
	Pistoia(47, "Pistoia"), Pordenone(93, "Pordenone"), Potenza(76, "Potenza"), Prato(100, "Prato"),
	Ragusa(88, "Ragusa"), Ravenna(39, "Ravenna"), ReggioCalabria(80, "Reggio di Calabria"),
	ReggioEmilia(35, "Reggio nell'Emilia"), Rieti(57, "Rieti"), Rimini(99, "Rimini"), Roma(58, "Roma"),
	Rovigo(29, "Rovigo"), Salerno(65, "Salerno"), Sassari(90, "Sassari"), Savona(9, "Savona"), Siena(52, "Siena"),
	Siracusa(89, "Siracusa"), Sondrio(14, "Sondrio"), SudSardegna(111, "Sud Sardegna"), Taranto(73, "Taranto"),
	Teramo(67, "Teramo"), Terni(55, "Terni"), Torino(1, "Torino"), Trapani(81, "Trapani"), Trento(22, "Trento"),
	Treviso(26, "Treviso"), Trieste(32, "Trieste"), Udine(30, "Udine"), Varese(12, "Varese"), Venezia(27, "Venezia"),
	VerbanoCusioOssola(103, "Verbano-Cusio-Ossola"), Vercelli(2, "Vercelli"), Verona(23, "Verona"),
	ViboValentia(102, "Vibo Valentia"), Vicenza(24, "Vicenza"), Viterbo(56, "Viterbo");

	private Integer codice;
	private String denominazione;

	private ProvinceE(Integer codice, String denominazione) {
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

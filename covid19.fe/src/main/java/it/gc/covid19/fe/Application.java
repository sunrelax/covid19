package it.gc.covid19.fe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import it.gc.covid19.fe.bean.ComboB;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public List<ComboB> elencoRegioni() {
		List<ComboB> er = new ArrayList<ComboB>();
		ComboB abruzzo = new ComboB("13", "Abruzzo");
		ComboB basilicata = new ComboB("17", "Basilicata");
		ComboB calabria = new ComboB("18", "Calabria");
		ComboB campania = new ComboB("15", "Campania");
		ComboB emiliaRomagna = new ComboB("8", "Emilia-Romagna");
		ComboB friuliVeneziaGiulia = new ComboB("6", "Friuli Venezia Giulia");
		ComboB lazio = new ComboB("12", "Lazio");
		ComboB liguria = new ComboB("7", "Liguria");
		ComboB lombardia = new ComboB("3", "Lombardia");
		ComboB marche = new ComboB("11", "Marche");
		ComboB molise = new ComboB("14", "Molise");
		ComboB pABolzano = new ComboB("21", "P.A. Bolzano");
		ComboB pATrento = new ComboB("22", "P.A. Trento");
		ComboB piemonte = new ComboB("1", "Piemonte");
		ComboB puglia = new ComboB("16", "Puglia");
		ComboB sardegna = new ComboB("20", "Sardegna");
		ComboB sicilia = new ComboB("19", "Sicilia");
		ComboB toscana = new ComboB("9", "Toscana");
		ComboB umbria = new ComboB("10", "Umbria");
		ComboB valleDAosta = new ComboB("2", "Valle d'Aosta");
		ComboB veneto = new ComboB("5", "Veneto");

		er.add(abruzzo);
		er.add(basilicata);
		er.add(calabria);
		er.add(campania);
		er.add(emiliaRomagna);
		er.add(friuliVeneziaGiulia);
		er.add(lazio);
		er.add(lombardia);
		er.add(marche);
		er.add(molise);
		er.add(liguria);
		er.add(pABolzano);
		er.add(pATrento);
		er.add(piemonte);
		er.add(puglia);
		er.add(sardegna);
		er.add(sicilia);
		er.add(toscana);
		er.add(umbria);
		er.add(valleDAosta);
		er.add(veneto);
		return er;
	}

}

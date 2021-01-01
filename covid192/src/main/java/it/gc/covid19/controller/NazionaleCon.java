package it.gc.covid19.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.ceau.chart.LineChart;
import it.gc.covid19.document.NazionaleDoc;
import it.gc.covid19.service.NazionaleCSer;
import it.gc.covid19.service.NazionaleMSer;
import it.gc.covid19.util.NazionaleE;

@RestController
@RequestMapping("/nazionale")
public class NazionaleCon {

	@Autowired
	private NazionaleMSer nazionaleMSer;
	@Autowired
	private NazionaleCSer nazionaleCSer;

	@GetMapping("/{nazionaleE}")
	public ResponseEntity<LineChart> getLineChart(@PathVariable String nazionaleE, @RequestParam String dataDa)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException {

		List<NazionaleDoc> nazionali = nazionaleMSer.getNazionaliDa(dataDa);
		LineChart chart = nazionaleCSer.getLineChart(nazionali, NazionaleE.valueOf(nazionaleE));
		System.out.println(chart.toJson());

		return ResponseEntity.ok(chart);
	}

}

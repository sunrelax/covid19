package it.gc.covid19.be.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.ceau.chart.LineChart;
import it.gc.covid19.be.document.NazionaleDoc;
import it.gc.covid19.be.service.NazionaleCSer;
import it.gc.covid19.be.service.NazionaleMSer;
import it.gc.covid19.be.util.NazionaleE;

@RestController
@RequestMapping("/nazionale")
public class NazionaleCon {

	Logger logger = LoggerFactory.getLogger(NazionaleCon.class);

	@Autowired
	private NazionaleMSer nazionaleMSer;
	@Autowired
	private NazionaleCSer nazionaleCSer;

	@GetMapping(value = "/line/{nazionaleE}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LineChart> getLineChart(@PathVariable String nazionaleE,
			@RequestParam(required = false) String dataDa, @RequestParam(required = false) String dataA)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException {
		List<NazionaleDoc> nazionali = null;
		
		if (!StringUtils.hasText(dataDa) && !StringUtils.hasText(dataA)) {
			nazionali = nazionaleMSer.getNazionali();
		} else if (StringUtils.hasText(dataDa) && StringUtils.hasText(dataA)) {
			nazionali = nazionaleMSer.getNazionali(dataDa, dataA);
		} else if (StringUtils.hasText(dataDa)) {
			nazionali = nazionaleMSer.getNazionaliDa(dataDa);
		} else if (StringUtils.hasText(dataA)) {
			nazionali = nazionaleMSer.getNazionaliA(dataA);
		}

		LineChart chart = nazionaleCSer.getLineChart(nazionali, NazionaleE.valueOf(nazionaleE));
		logger.info("chart json: " + chart.toJson());

		return ResponseEntity.ok(chart);
	}

	@GetMapping("/dati")
	public ResponseEntity<List<NazionaleDoc>> getData(@RequestParam(required = false) String dataDa,
			@RequestParam(required = false) String dataA) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		List<NazionaleDoc> nazionali = null;
		if (!StringUtils.hasText(dataDa) && !StringUtils.hasText(dataA)) {
			nazionali = nazionaleMSer.getNazionali();
		} else if (StringUtils.hasText(dataDa) && StringUtils.hasText(dataA)) {
			nazionali = nazionaleMSer.getNazionali(dataDa, dataA);
		} else if (StringUtils.hasText(dataDa)) {
			nazionali = nazionaleMSer.getNazionaliDa(dataDa);
		} else if (StringUtils.hasText(dataA)) {
			nazionali = nazionaleMSer.getNazionaliA(dataA);
		}

		return ResponseEntity.ok(nazionali);
	}
}

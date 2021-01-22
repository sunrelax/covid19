package it.gc.covid19.be.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
import it.gc.covid19.be.document.RegioneDoc;
import it.gc.covid19.be.service.RegioneCSer;
import it.gc.covid19.be.service.RegioneMSer;
import it.gc.covid19.be.util.DatiE;

@RestController
@RequestMapping("/regionale")
public class RegionaleCon {

	Logger logger = LoggerFactory.getLogger(RegionaleCon.class);

	@Autowired
	private RegioneMSer regioneMSer;
	@Autowired
	private RegioneCSer regioneCSer;

	@GetMapping(value = "/line/{regioni}/{grafici}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LineChart> getLineChart(@PathVariable String regioni, @PathVariable String grafici,
			@RequestParam(required = false) String dataDa, @RequestParam(required = false) String dataA)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException {
		List<RegioneDoc> regionali = null;
		int[] regioniInt = Stream.of(regioni.split(",")).mapToInt(Integer::decode).toArray();
		List<Integer> codiciRegioni = IntStream.of(regioniInt).boxed().collect(Collectors.toList());

		if (!StringUtils.hasText(dataDa) && !StringUtils.hasText(dataA)) {
			regionali = regioneMSer.getRegioni(codiciRegioni);
		} else if (StringUtils.hasText(dataDa) && StringUtils.hasText(dataA)) {
			regionali = regioneMSer.getRegioni(codiciRegioni, dataDa, dataA);
		} else if (StringUtils.hasText(dataDa)) {
			regionali = regioneMSer.getRegioniDa(codiciRegioni, dataDa);
		} else if (StringUtils.hasText(dataA)) {
			regionali = regioneMSer.getRegioniA(codiciRegioni, dataA);
		}

		List<DatiE> datiE = Arrays.asList(grafici.split(",")).stream().map(DatiE::valueOf).collect(Collectors.toList());

		LineChart chart = regioneCSer.getLineChart(codiciRegioni, regionali, datiE);
		logger.info("chart json: " + chart.toJson());

		return ResponseEntity.ok(chart);
	}

}

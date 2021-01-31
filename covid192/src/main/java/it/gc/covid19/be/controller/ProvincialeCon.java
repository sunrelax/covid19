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
import it.gc.covid19.be.document.ProvinciaDoc;
import it.gc.covid19.be.service.ProvinciaCSer;
import it.gc.covid19.be.service.ProvinciaMSer;

@RestController
@RequestMapping("/provinciale")
public class ProvincialeCon {

	Logger logger = LoggerFactory.getLogger(ProvincialeCon.class);

	@Autowired
	private ProvinciaMSer provinciaMSer;
	@Autowired
	private ProvinciaCSer provinciaCSer;

	@GetMapping(value = "/line/{province}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LineChart> getLineChart(@PathVariable String province,
			@RequestParam(required = false) String dataDa, @RequestParam(required = false) String dataA)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException {
		List<ProvinciaDoc> provinciali = null;
		int[] provinceInt = Stream.of(province.split(",")).mapToInt(Integer::decode).toArray();
		List<Integer> codiciProvince = IntStream.of(provinceInt).boxed().collect(Collectors.toList());

		if (!StringUtils.hasText(dataDa) && !StringUtils.hasText(dataA)) {
			provinciali = provinciaMSer.getProvince(codiciProvince);
		} else if (StringUtils.hasText(dataDa) && StringUtils.hasText(dataA)) {
			provinciali = provinciaMSer.getProvince(codiciProvince, dataDa, dataA);
		} else if (StringUtils.hasText(dataDa)) {
			provinciali = provinciaMSer.getProvinceDa(codiciProvince, dataDa);
		} else if (StringUtils.hasText(dataA)) {
			provinciali = provinciaMSer.getProvinceA(codiciProvince, dataA);
		}

		LineChart chart = provinciaCSer.getLineChart(provinciali, codiciProvince);
		logger.info("chart json: " + chart.toJson());

		return ResponseEntity.ok(chart);
	}

}

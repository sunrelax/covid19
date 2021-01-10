package it.gc.covid19.be;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.ceau.chart.LineChart;
import it.gc.covid19.be.document.NazionaleDoc;
import it.gc.covid19.be.service.NazionaleCSer;
import it.gc.covid19.be.service.NazionaleMSer;
import it.gc.covid19.be.util.DatiE;

@SpringBootTest
public class ChartServTests {

	Logger logger = LoggerFactory.getLogger(ChartServTests.class);

	@Autowired
	private NazionaleMSer nazionaleMSer;
	@Autowired
	private NazionaleCSer nazionaleCSer;

	@Test
	public void getLineChart() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException {
		List<NazionaleDoc> nazionali = nazionaleMSer.getNazionaliDa("2020-12-20T17:00:00");
		LineChart chart = nazionaleCSer.getLineChart(nazionali, DatiE.nuovi_positivi);
		logger.info(chart.toJson());
	}

	@Test
	public void getData() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException {
		List<NazionaleDoc> nazionali = nazionaleMSer.getNazionaliDa("2020-12-20T17:00:00");
		LineChart chart = nazionaleCSer.getLineChart(nazionali, DatiE.nuovi_positivi);
		logger.info(chart.toJson());
	}

}

package it.gc.covid19;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.ceau.chart.LineChart;
import it.gc.covid19.document.NazionaleDoc;
import it.gc.covid19.service.NazionaleCSer;
import it.gc.covid19.service.NazionaleMSer;
import it.gc.covid19.util.NazionaleE;

@SpringBootTest
public class ChartServTests {

	@Autowired
	private NazionaleMSer nazionaleMSer;
	@Autowired
	private NazionaleCSer nazionaleCSer;

	@Test
	public void getLineChart() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException {
		List<NazionaleDoc> nazionali = nazionaleMSer.getNazionaliDa("2020-12-20T17:00:00");
		LineChart chart = nazionaleCSer.getLineChart(nazionali, NazionaleE.nuovi_positivi);
		System.out.println(chart.toJson());
	}
	
	@Test
	public void getData() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException {
		List<NazionaleDoc> nazionali = nazionaleMSer.getNazionaliDa("2020-12-20T17:00:00");
		LineChart chart = nazionaleCSer.getLineChart(nazionali, NazionaleE.nuovi_positivi);
		System.out.println(chart.toJson());
	}

}

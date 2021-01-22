package it.gc.covid19.be.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import be.ceau.chart.LineChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.LineData;
import be.ceau.chart.dataset.LineDataset;
import be.ceau.chart.enums.BorderCapStyle;
import be.ceau.chart.enums.BorderJoinStyle;
import be.ceau.chart.options.LineOptions;
import be.ceau.chart.options.elements.Fill;
import be.ceau.chart.options.scales.LinearScale;
import be.ceau.chart.options.scales.LinearScales;
import it.gc.covid19.be.document.RegioneDoc;
import it.gc.covid19.be.util.DatiE;
import it.gc.covid19.be.util.RegioniE;

@Service
public class RegioneCSer {

	public LineChart getLineChart(List<Integer> codiciRegioni, List<RegioneDoc> regionali, List<DatiE> grafici)
			throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		
		regionali.stream().forEachOrdered(System.out::println);
		
		LineChart chart = new LineChart();
		LineData data = new LineData();
		int i = 1;
		for (DatiE grafico : grafici) {
			for (Integer codRegione : codiciRegioni) {
				String nomeReg = null;
				for (RegioniE re : RegioniE.values()) {
					if (re.getCodice().equals(codRegione)) {
						nomeReg = re.name();
						break;
					}
				}

				LineDataset dataset = createLineDataset(nomeReg + "_" + grafico.name(), Color.random());
				Method method = RegioneDoc.class.getMethod(grafico.getMetodo());

				for (RegioneDoc regionale : regionali) {
					Object ob = method.invoke(regionale);
					if (ob != null) {
						BigDecimal value = new BigDecimal(ob.toString());
						if (i == 1) {
							if (Integer.valueOf(regionale.getCodiceRegione()).equals(codiciRegioni.get(0))) {
								data.addLabel(regionale.getData());
							}
						}
						if (Integer.valueOf(regionale.getCodiceRegione()).equals(codRegione)) {
							dataset.addData(value);
						}
					}
				}
				data.addDataset(dataset);
				i++;
			}
		}

		chart.setData(data);
		LineOptions options = new LineOptions();
		LinearScales linearScales = new LinearScales();
		LinearScale linearScale = new LinearScale();
		linearScale.setStacked(false);
		linearScales.addyAxis(linearScale);
		options.setScales(linearScales);
		chart.setOptions(options);

		return chart;
	}

	public LineChart getLineChart(List<RegioneDoc> nazionali, DatiE nazionaleE)
			throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		LineChart chart = new LineChart();
		LineData data = new LineData();
		LineDataset dataset = createLineDataset(nazionaleE.name(), new Color(75, 192, 192, 1));
		Method method = RegioneDoc.class.getMethod(nazionaleE.getMetodo());
		for (RegioneDoc nazionale : nazionali) {

			Object ob = method.invoke(nazionale);
			if (ob != null) {
				BigDecimal value = new BigDecimal(ob.toString());
				data.addLabel(nazionale.getData());
				dataset.addData(value);
			}

		}
		data.addDataset(dataset);
		chart.setData(data);
		LineOptions options = new LineOptions();
		LinearScales linearScales = new LinearScales();
		LinearScale linearScale = new LinearScale();
		linearScale.setStacked(false);
		linearScales.addyAxis(linearScale);
		options.setScales(linearScales);
		chart.setOptions(options);

		return chart;
	}

	private LineDataset createLineDataset(String nazionaleE, Color color) {
		return new LineDataset().setLabel(nazionaleE).setFill(new Fill<Boolean>(true)).setLineTension(0.1f)
				.setBackgroundColor(new Color(75, 192, 192, 0.4)).setBorderColor(color)
				.setBorderCapStyle(BorderCapStyle.BUTT).setBorderDashOffset(0.0f)
				.setBorderJoinStyle(BorderJoinStyle.MITER).addPointBorderColor(color)
				.addPointBackgroundColor(new Color(255, 255, 255, 1)).addPointBorderWidth(1).addPointHoverRadius(5)
				.addPointHoverBackgroundColor(new Color(75, 192, 192, 1))
				.addPointHoverBorderColor(new Color(220, 220, 220, 1)).addPointHoverBorderWidth(2).addPointRadius(1)
				.addPointHitRadius(10).setSpanGaps(false);
	}

}

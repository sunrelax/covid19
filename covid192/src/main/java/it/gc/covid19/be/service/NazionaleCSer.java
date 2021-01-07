package it.gc.covid19.be.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

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
import it.gc.covid19.be.document.NazionaleDoc;
import it.gc.covid19.be.util.NazionaleE;

@Service
public class NazionaleCSer {

	public LineChart getLineChart(List<NazionaleDoc> nazionali, List<NazionaleE> nazionaliE)
			throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		LineChart chart = new LineChart();
		LineData data = new LineData();
		int i = 1;
		for (NazionaleE nazionaleE : nazionaliE) {

			LineDataset dataset = createLineDataset(nazionaleE, Color.random());
			Method method = NazionaleDoc.class.getMethod(nazionaleE.getMetodo());
			for (NazionaleDoc nazionale : nazionali) {

				Object ob = method.invoke(nazionale);
				if (ob != null) {
					BigDecimal value = new BigDecimal(ob.toString());
					if(i == 1) { 
						data.addLabel(nazionale.getData());
					}
					dataset.addData(value);
				}
				
			}
			data.addDataset(dataset);
			i++;
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

	public LineChart getLineChart(List<NazionaleDoc> nazionali, NazionaleE nazionaleE)
			throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		LineChart chart = new LineChart();
		LineData data = new LineData();
		LineDataset dataset = createLineDataset(nazionaleE, new Color(75, 192, 192, 1));
		Method method = NazionaleDoc.class.getMethod(nazionaleE.getMetodo());
		for (NazionaleDoc nazionale : nazionali) {

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

	private LineDataset createLineDataset(NazionaleE nazionaleE, Color color) {
		return new LineDataset().setLabel(nazionaleE.name()).setFill(new Fill<Boolean>(true)).setLineTension(0.1f)
				.setBackgroundColor(new Color(75, 192, 192, 0.4)).setBorderColor(color)
				.setBorderCapStyle(BorderCapStyle.BUTT).setBorderDashOffset(0.0f)
				.setBorderJoinStyle(BorderJoinStyle.MITER).addPointBorderColor(new Color(75, 192, 192, 1))
				.addPointBackgroundColor(new Color(255, 255, 255, 1)).addPointBorderWidth(1).addPointHoverRadius(5)
				.addPointHoverBackgroundColor(new Color(75, 192, 192, 1))
				.addPointHoverBorderColor(new Color(220, 220, 220, 1)).addPointHoverBorderWidth(2).addPointRadius(1)
				.addPointHitRadius(10).setSpanGaps(false);
	}

}

package it.gc.covid19.fe.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import it.gc.covid19.fe.bean.NazionaleB;
import it.gc.covid19.fe.validator.NazionaleVal;

@Controller
public class NazionaleCon {

	Logger logger = LoggerFactory.getLogger(NazionaleCon.class);

	@Value("#{${grafici}}")
	public List<String> grafici;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private NazionaleVal nazionaleVal;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "/nazionale", method = RequestMethod.GET)
	public String nazionaleForm(Model model) {
		NazionaleB nazionaleB = new NazionaleB();
		nazionaleB.setGrafici(grafici);
		model.addAttribute("nazionaleb", nazionaleB);
		return "nazionale";
	}

	@RequestMapping(value = "/nazionale/grafico", method = RequestMethod.GET)
	public String nazionaleForm(Model model, @ModelAttribute("nazionaleb") NazionaleB nazionaleb,
			BindingResult result) {
		logger.info("nazionaleb: " + nazionaleb);
		nazionaleb.setGrafici(grafici);
		model.addAttribute("nazionaleb", nazionaleb);
		nazionaleVal.validate(nazionaleb, result);
		if (result.hasErrors()) {
			return "nazionale";
		}
		String graficiSel = String.join(",", nazionaleb.getGraficiSelezionati());
		StringBuffer url = new StringBuffer(
				"http://localhost:8081/nazionale/line/" + graficiSel);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (nazionaleb.getDataDa() != null && nazionaleb.getDataA() == null) {
			url.append("?dataDa=" + sdf.format(nazionaleb.getDataDa()));
		} else if (nazionaleb.getDataDa() == null && nazionaleb.getDataA() != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(nazionaleb.getDataA());
			c.add(Calendar.DATE, 1);
			url.append("?dataA=" + sdf.format(c.getTime()));
		} else if (nazionaleb.getDataDa() != null && nazionaleb.getDataA() != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(nazionaleb.getDataA());
			c.add(Calendar.DATE, 1);
			url.append("?dataDa=" + sdf.format(nazionaleb.getDataDa()) + "&dataA=" + sdf.format(c.getTime()));
		}
		String linechart = restTemplate.getForObject(url.toString(), String.class);
		model.addAttribute("linechart", linechart);
		return "nazionale";
	}

}

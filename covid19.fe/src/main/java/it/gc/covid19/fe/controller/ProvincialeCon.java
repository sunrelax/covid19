package it.gc.covid19.fe.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import it.gc.covid19.fe.bean.ComboB;
import it.gc.covid19.fe.bean.ProvincialeB;
import it.gc.covid19.fe.validator.ProvincialeVal;

@Controller
public class ProvincialeCon {

	Logger logger = LoggerFactory.getLogger(ProvincialeCon.class);

	@Value("#{${grafici}}")
	public List<String> grafici;
	@Autowired
	@Qualifier("elencoProvince")
	private List<ComboB> province;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProvincialeVal provincialeVal;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "/provinciale", method = RequestMethod.GET)
	public String provincialeForm(Model model) {
		ProvincialeB provincialeB = new ProvincialeB();
		provincialeB.setGrafici(grafici);
		provincialeB.setProvince(province);
		model.addAttribute("provincialeb", provincialeB);
		return "provinciale";
	}

	@RequestMapping(value = "/provinciale/grafico", method = RequestMethod.GET)
	public String provincialeForm(Model model, @ModelAttribute("provincialeb") ProvincialeB provincialeb,
			BindingResult result) {
		logger.info("provincialeb: " + provincialeb);
		provincialeb.setGrafici(grafici);
		provincialeb.setProvince(province);
		model.addAttribute("provincialeb", provincialeb);
		provincialeVal.validate(provincialeb, result);
		if (result.hasErrors()) {
			return "provinciale";
		}
		String provinceSel = String.join(",", provincialeb.getProvinceSelezionate());
		StringBuffer url = new StringBuffer(
				"http://localhost:8081/provinciale/line/" + provinceSel);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (provincialeb.getDataDa() != null && provincialeb.getDataA() == null) {
			url.append("?dataDa=" + sdf.format(provincialeb.getDataDa()));
		} else if (provincialeb.getDataDa() == null && provincialeb.getDataA() != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(provincialeb.getDataA());
			c.add(Calendar.DATE, 1);
			url.append("?dataA=" + sdf.format(c.getTime()));
		} else if (provincialeb.getDataDa() != null && provincialeb.getDataA() != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(provincialeb.getDataA());
			c.add(Calendar.DATE, 1);
			url.append("?dataDa=" + sdf.format(provincialeb.getDataDa()) + "&dataA=" + sdf.format(c.getTime()));
		}
		String linechart = restTemplate.getForObject(url.toString(), String.class);
		model.addAttribute("linechart", linechart);
		return "provinciale";
	}

}

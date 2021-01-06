package it.gc.covid19.fe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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

//	@Value("#{${line}}")
//	public String line;
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
	public String nazionaleForm(Model model, @ModelAttribute("nazionaleb") @Valid NazionaleB nazionaleb,
			BindingResult result) {
		logger.info("nazionaleb: " + nazionaleb);
		nazionaleb.setGrafici(grafici);
		model.addAttribute("nazionaleb", nazionaleb);
		nazionaleVal.validate(nazionaleb, result);
		if(result.hasErrors()){
			return "nazionale";
		}
		StringBuffer url = new StringBuffer("http://localhost:8081/nazionale/line/"+ nazionaleb.getGraficoSelezionato());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(nazionaleb.getDataDa() != null && nazionaleb.getDataA() == null) {
			url.append("?dataDa=" + sdf.format(nazionaleb.getDataDa()));
		} else if (nazionaleb.getDataDa() == null && nazionaleb.getDataA() != null) {
			url.append("?dataA=" + sdf.format(nazionaleb.getDataA()));
		} else if (nazionaleb.getDataDa() != null && nazionaleb.getDataA() != null) {
			url.append("?dataDa=" + sdf.format(nazionaleb.getDataDa()) + "&dataA=" + sdf.format(nazionaleb.getDataA()));
		}
		String linechart = restTemplate.getForObject(url.toString(), String.class);
		model.addAttribute("linechart", linechart);
		model.addAttribute("nazionaleb", nazionaleb);
		return "nazionale";
	}

}

package it.gc.covid19.fe.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.ListUtils;

import it.gc.covid19.fe.bean.RegionaleB;

@Component
public class RegionaleVal implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RegionaleB.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegionaleB regionaleb = (RegionaleB) target;
		if (ListUtils.isEmpty(regionaleb.getGraficiSelezionati())) {
			errors.rejectValue("graficiSelezionati", "obbligatorio");
		}
		if (ListUtils.isEmpty(regionaleb.getRegioniSelezionate())) {
			errors.rejectValue("regioniSelezionate", "obbligatorio");
		}
		if (regionaleb.getDataDa() != null && regionaleb.getDataA() != null
				&& regionaleb.getDataDa().after(regionaleb.getDataA())) {
			errors.rejectValue("dataDa", "dataDa.superiore");
		}
	}
}

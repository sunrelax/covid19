/**
 * 
 */
package it.gc.covid19.fe.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.gc.covid19.fe.bean.NazionaleB;

@Component
public class NazionaleVal implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NazionaleB.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NazionaleB nazionaleb = (NazionaleB) target;
		if (nazionaleb.getGraficoSelezionato() == null) {
			errors.rejectValue("graficoSelezionato", "obbligatorio");
		}
		if (nazionaleb.getDataDa() != null && nazionaleb.getDataA() != null
				&& nazionaleb.getDataDa().after(nazionaleb.getDataA())) {
			errors.rejectValue("dataDa", "dataDa.superiore");
		}
	}
}

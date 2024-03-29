package it.gc.covid19.fe.bean;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RicercaB {

	public List<String> grafici;

	@NotNull
	public List<String> graficiSelezionati;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date dataDa;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date dataA;

}

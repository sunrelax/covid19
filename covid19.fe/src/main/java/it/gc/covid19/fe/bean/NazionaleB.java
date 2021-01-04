package it.gc.covid19.fe.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NazionaleB extends RicercaB {

	public List<String> grafici;

	public String graficoSelezionato;
}

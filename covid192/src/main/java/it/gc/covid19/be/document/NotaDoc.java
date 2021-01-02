package it.gc.covid19.be.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "note")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class NotaDoc {

	@Id
	private String id;
	@Getter
	@Setter
	private String data;
	@Getter
	@Setter
	private String note;

}

package br.com.apirest.opersms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "opersms")
@Data
public class OperSMS {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idsms;
	@NotNull
	@NotEmpty
	@Max(value = 10)
	private String datasms;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 160)
	private String textosms;
	
}

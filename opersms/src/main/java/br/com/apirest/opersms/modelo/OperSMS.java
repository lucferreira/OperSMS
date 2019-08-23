package br.com.apirest.opersms.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	private LocalDate datasms;
	@NotNull
	@NotEmpty
	@Max(value = 160)
	private String textosms;
}

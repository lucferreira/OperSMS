package br.com.apirest.opersms.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "opersms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperSMS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsms;
	@NotNull
	private LocalDateTime datasms;
	@Size(min = 1, max = 160)
	@NotNull
	private String textosms;
	
}

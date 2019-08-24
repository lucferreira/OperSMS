package br.com.apirest.opersms.service;

import java.util.List;
import java.util.Optional;

import br.com.apirest.opersms.model.OperSMS;

public interface OperSMSService {
	
	Optional<OperSMS> findById(Long id);
	List<OperSMS> findAll();
	OperSMS save(OperSMS operSMS);

}

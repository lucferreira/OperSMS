package br.com.apirest.opersms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.opersms.model.OperSMS;
import br.com.apirest.opersms.repository.OperSMSRepository;

@Service
public class OperSMSServiceImpl implements OperSMSService{

	@Autowired
	private OperSMSRepository operSMSRepository;

	@Override
	public Optional<OperSMS> findById(Long id) {
		return operSMSRepository.findById(id);
	}

	@Override
	public List<OperSMS> findAll() {
		return operSMSRepository.findAll();
	}

	@Override
	public OperSMS save(OperSMS operSMS) {
		return operSMSRepository.save(operSMS);
	}
	
}

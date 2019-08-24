package br.com.apirest.opersms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.opersms.model.OperSMS;

public interface OperSMSRepository extends JpaRepository<OperSMS, Long> {
}

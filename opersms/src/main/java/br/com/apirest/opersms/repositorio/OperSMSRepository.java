package br.com.apirest.opersms.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.opersms.modelo.OperSMS;

public interface OperSMSRepository extends JpaRepository<OperSMS, Long> {
}

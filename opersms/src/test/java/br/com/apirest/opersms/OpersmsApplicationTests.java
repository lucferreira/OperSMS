package br.com.apirest.opersms;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.apirest.opersms.controller.OperSMSController;
import br.com.apirest.opersms.model.OperSMS;
import br.com.apirest.opersms.service.OperSMSService;

@RunWith(MockitoJUnitRunner.class)
public class OpersmsApplicationTests {
	
	@Mock
	OperSMSService operSMSService;
	
	@InjectMocks
	OperSMSController OperSMSController;
	
	List<OperSMS> operSMSLista;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		OperSMS operSMS = new OperSMS();
		operSMS.setIdsms(4l);
		operSMS.setDatasms(LocalDateTime.of(2019, 8, 26, 00, 00));
		operSMS.setTextosms("Texto4");
		
		operSMS.setIdsms(5l);
		operSMS.setDatasms(LocalDateTime.of(2019, 8, 26, 00, 00));
		operSMS.setTextosms("Texto5");
		
		operSMS.setIdsms(6l);
		operSMS.setDatasms(LocalDateTime.of(2019, 8, 26, 00, 00));
		operSMS.setTextosms("Texto6");
	}
	
	@Test
	public void testGetOperSMS() {
		
	}
	
	public void testPostOperSMS() {
		
	}
	

}

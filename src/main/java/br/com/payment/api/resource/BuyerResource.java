package br.com.payment.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.payment.api.event.RecursoCriadoEvent;
import br.com.payment.api.model.Buyer;
import br.com.payment.api.repository.BuyerRepository;
import br.com.payment.api.services.BuyerServices;

@RestController // Importando o Controlador REST
@RequestMapping("/buyers") // Mapeamento da requisição, uri padrão
public class BuyerResource {

	@Autowired
	private BuyerRepository buyerRepository;	
	
	@Autowired
	private BuyerServices  buyerServices;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Buyer> listBuyers() {
		return buyerRepository.findAll();

	}
	
	/*@PostMapping("/buyers")
	@ResponseStatus(HttpStatus.CREATED)
	public void createBuyer(@RequestBody Buyer buyer) {
		return buyerRepository.save(buyer);
	}*/
	
	//Cadas
	@PostMapping
	public ResponseEntity<Buyer>create(@RequestBody Buyer buyer, HttpServletResponse response){
		Buyer buyerSave = buyerServices.save(buyer);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, buyerSave.getIdBuyer()));
		return ResponseEntity.status(HttpStatus.CREATED).body(buyerSave);
		
	}

}
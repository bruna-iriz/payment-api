package br.com.payment.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.payment.api.event.ResourceCreateEvent;
import br.com.payment.api.model.Buyer;
import br.com.payment.api.repository.BuyerRepository;
import br.com.payment.api.services.BuyerServices;

@RestController // Importando o Controlador REST
@RequestMapping("/buyers") // Mapeamento da requisição, uri padrão
public class BuyerResource {

	@Autowired
	private BuyerRepository buyerRepository;

	@Autowired
	private BuyerServices buyerServices;

	@Autowired
	private ApplicationEventPublisher publisher;

	// Listando todos os Buyers
	@GetMapping
	public List<Buyer> listBuyers() {
		return buyerRepository.findAll();

	}

	// Listando Buyers por ID
	@GetMapping("/{id}")
	public Buyer searchBuyerId(@PathVariable(value = "id") Long id) {
		return buyerRepository.findOne(id);
	}

	// Criando Buyer
	@PostMapping
	public ResponseEntity<Buyer> create(@Valid @RequestBody Buyer buyer, HttpServletResponse response) {
		Buyer buyerSave = buyerServices.save(buyer);
		publisher.publishEvent(new ResourceCreateEvent(this, response, buyerSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(buyerSave);
	}

	// Atualizando Buyer
	@PutMapping("/{id}")
	public ResponseEntity<Buyer> update(@PathVariable Long id, @Valid @RequestBody Buyer buyer) {
		Buyer buyerSave = buyerServices.update(id, buyer);
		return ResponseEntity.ok(buyerSave);

	}

	// Atualizando Buyer Parcial
	@PutMapping("/{id}/emailbuyer")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePropertyEmaill(@PathVariable Long id, @RequestBody String emailBuyer) {

		buyerServices.updatePropertyEmail(id, emailBuyer);

	}

	// Deletando Buyer
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		buyerRepository.delete(id);
	}

}

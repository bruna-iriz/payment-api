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
import br.com.payment.api.model.Card;
import br.com.payment.api.repository.CardRepository;
import br.com.payment.api.services.CardServices;

@RestController // Importando o Controlador REST
@RequestMapping("/cards") // Mapeamento da requisição, uri padrão
public class CardResource {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardServices cardServices;

	// Disparando publicador de eventos
	@Autowired
	private ApplicationEventPublisher publisher;

	// Listando todos os Cards
	@GetMapping
	public List<Card> listCards() {
		return cardRepository.findAll();

	}

	// Listando Cards por ID
	@GetMapping("/{id}")
	public Card searchCardId(@PathVariable Long id) {
		return cardRepository.findOne(id);
	}

	// Criando Card
	@PostMapping
	public ResponseEntity<Card> create(@Valid @RequestBody Card card, HttpServletResponse response) {
		Card cardSave = cardServices.save(card);
		publisher.publishEvent(new ResourceCreateEvent(this, response, cardSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(cardSave);
	}

	// Deletando Card
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cardRepository.delete(id);
	}

	// Atualizando Card
	@PutMapping("/{id}")
	public ResponseEntity<Card> update(@PathVariable Long id, @Valid @RequestBody Card card) {
		Card cardSave = cardServices.update(id, card);
		return ResponseEntity.ok(cardSave);

	}
}
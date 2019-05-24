package br.com.payment.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.payment.api.model.Card;
import br.com.payment.api.repository.CardRepository;

@Service
public class CardServices {

	@Autowired
	private CardRepository cardRepository;

	public Card save(Card card) {
		return cardRepository.save(card);
	}

}

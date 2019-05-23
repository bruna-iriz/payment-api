package br.com.payment.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.payment.api.model.Buyer;
import br.com.payment.api.repository.BuyerRepository;

@Service
public class BuyerServices {

	@Autowired
	private BuyerRepository buyerRepository;
	
	public Buyer save(Buyer buyer) {
		return buyerRepository.save(buyer);
	}
	
	
	
}
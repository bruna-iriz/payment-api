package br.com.payment.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	public Buyer update(Long id, Buyer buyer) {
		Buyer buyerSave = buyerRepository.findOne(id);
		if (buyerSave == null) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(buyer, buyerSave, "id");
		return buyerRepository.save(buyerSave);
	}

	public void updatePropertyEmail(Long id, String emailBuyer) {
		Buyer buyerSave = buyerRepository.findOne(id);
		buyerSave.setEmailBuyer(emailBuyer);
		buyerRepository.save(buyerSave);

	}
}
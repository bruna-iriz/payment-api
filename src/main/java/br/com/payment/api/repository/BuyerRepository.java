package br.com.payment.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.payment.api.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
	
	List<Buyer> findAll();
}
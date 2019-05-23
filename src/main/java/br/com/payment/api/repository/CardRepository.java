package br.com.payment.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.payment.api.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	List<Card> findAll();

}

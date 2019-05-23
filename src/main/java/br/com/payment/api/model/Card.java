package br.com.payment.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "card")

public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCard;

	@NotNull
	@Size(min = 3, max = 50)
	private String cardHolderName;

	@NotNull
	@Size(min = 16, max = 19)
	private String cardNumber;

	@DateTimeFormat
	@NotNull
	private LocalDateTime cardExpirationDate;

	@NotNull
	@Size(min = 3, max = 3)
	private Integer cardCVV;
}
package br.com.payment.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "card")

public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	private String cardholdername;

	@NotNull
	private String cardNumber;

	@NotNull
	private String cardexpirationdate;

	@NotNull
	private String cardcvv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getcardholdername() {
		return cardholdername;
	}

	public void setCardHolderName(String cardholdername) {
		this.cardholdername = cardholdername;
	}

	public String getcardnumber() {
		return cardNumber;
	}

	public void setcardnumber(String cardnumber) {
		this.cardNumber = cardnumber;
	}

	public String getcardexpirationdate() {
		return cardexpirationdate;
	}

	public void setcardexpirationdate(String cardexpirationdate) {
		this.cardexpirationdate = cardexpirationdate;
	}

	public String getcardcvv() {
		return cardcvv;
	}

	public void setCardCVV(String cardcvv) {
		this.cardcvv = cardcvv;
	}
}
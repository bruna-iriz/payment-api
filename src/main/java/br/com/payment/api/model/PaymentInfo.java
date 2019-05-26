package br.com.payment.api.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.payment.api.model.enums.StatusPayment;

public class PaymentInfo {

	@Enumerated(EnumType.STRING)
	private StatusPayment statusPayment;

}

package br.com.payment.api.model;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.payment.api.model.enums.TypePayment;

@Entity
@Table(name = "payment")

public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private TypePayment typePayment;

	@NotNull
	private BigDecimal amountPayment;

	@NotNull
	private String infoCardNumber;

	@Embedded
	private PaymentInfo paymentInfo;
}

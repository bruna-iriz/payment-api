package br.com.payment.api.services;

public class PaymentServices {

	void BoletoPayment(String boletoNumber) {
		// Mocked value
		boletoNumber = "25090504004934033014830008109739036540000019900";

		System.out.println(boletoNumber);

	}

	public static Boolean PaymentSuccessful() {
		// Mocked value
		boolean PaymentSuccessful = true;
		return PaymentSuccessful;
	}

}

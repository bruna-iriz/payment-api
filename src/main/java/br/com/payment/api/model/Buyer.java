package br.com.payment.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")

public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBuyer;

	private String nameBuyer;
	private String emailBuyer;
	private String cpfBuyer;

	public Long getIdBuyer() {
		return idBuyer;
	}

	public void setIdBuyer(Long idBuyer) {
		this.idBuyer = idBuyer;
	}

	public String getNameBuyer() {
		return nameBuyer;
	}

	public void setNameBuyer(String nameBuyer) {
		this.nameBuyer = nameBuyer;
	}

	public String getEmailBuyer() {
		return emailBuyer;
	}

	public void setEmailBuyer(String emailBuyer) {
		this.emailBuyer = emailBuyer;
	}

	public String getCpfBuyer() {
		return cpfBuyer;
	}

	public void setCpfBuyer(String cpfBuyer) {
		this.cpfBuyer = cpfBuyer;
	}
}

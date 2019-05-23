package br.com.payment.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "buyer")

public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	private String nameBuyer;

	private String emailBuyer;

	@NotNull
	@Size(min = 11, max = 11)
	private String cpfBuyer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
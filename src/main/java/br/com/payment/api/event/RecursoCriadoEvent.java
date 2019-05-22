package br.com.payment.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent  extends ApplicationEvent{
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Long idBuyer;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long idBuyer) {
		super(source);
		this.response = response;
		this.idBuyer = idBuyer;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	
	
	public Long getidBuyer() {
		return idBuyer;
	}
}

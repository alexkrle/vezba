package rs.ac.uns.ftn.eo.students.web.dto;

import rs.ac.uns.ftn.eo.students.model.Administrator;

public class AdministratorDTO {
	
	private long id;
	
	public AdministratorDTO() {
		
	}
	
	public AdministratorDTO (Administrator administrator) {
		this(administrator.getId());
	}
	
	public AdministratorDTO (Long id) {
		this.id = id;

	}

	public Long getId() {
		return id;
	}



}

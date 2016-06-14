package rs.ac.uns.ftn.eo.students.web.dto;

import rs.ac.uns.ftn.eo.students.model.PredajePredmet;

public class PredajePredmetDTO {
	
	private Long id;
	private String uloga;
	
	public PredajePredmetDTO() {
		
	}
	
	public PredajePredmetDTO (PredajePredmet predajePredmet) {
		this(predajePredmet.getId(),predajePredmet.getUloga());
	}
	
	public PredajePredmetDTO (Long id,String uloga) {
		this.id = id;
		this.uloga = uloga;

	}

	public Long getId() {
		return id;
	}
	
	public String getUloga() {
		return uloga;
	}


}

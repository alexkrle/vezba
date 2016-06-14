package rs.ac.uns.ftn.eo.students.web.dto;

import java.util.Date;


import rs.ac.uns.ftn.eo.students.model.UplateStudenta;

public class UplateStudentaDTO {
	
	private Long id;
	
	private Date datumUplate;
	
	private String svrhaUplate;
	
	public UplateStudentaDTO() {
		
	}
	
	public UplateStudentaDTO (UplateStudenta uplateStudenta) {
		this(uplateStudenta.getId(),uplateStudenta.getDatumUplate(),uplateStudenta.getSvrhaUplate());
	}
	
	public UplateStudentaDTO (Long id,Date datumUplate,String svrhaUplate) {
		this.id = id;
		this.datumUplate = datumUplate;
		this.svrhaUplate = svrhaUplate;

	}

	public Long getId() {
		return id;
	}
	
	public String getSvrhaUplate() {
		return svrhaUplate;
	}
	
	public Date getDatumUplate() {
		return datumUplate;
	}

}

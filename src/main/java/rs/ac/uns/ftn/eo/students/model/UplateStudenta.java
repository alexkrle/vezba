package rs.ac.uns.ftn.eo.students.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UplateStudenta {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Date datumUplate;
	
	private String svrhaUplate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatumUplate() {
		return datumUplate;
	}
	public void setDatumUplate(Date datumUplate) {
		this.datumUplate = datumUplate;
	}
	public String getSvrhaUplate() {
		return svrhaUplate;
	}
	public void setSvrhaUplate(String svrhaUplate) {
		this.svrhaUplate = svrhaUplate;
	}

}

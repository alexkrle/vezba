package rs.ac.uns.ftn.eo.students.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PolaganjeIspita {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private boolean polozen;
	private boolean prijavljen;
	private String kolokvijum;
	private String vezbe;
	private String prisustvno;
	private Number ocena;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isPolozen() {
		return polozen;
	}
	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}
	public boolean isPrijavljen() {
		return prijavljen;
	}
	public void setPrijavljen(boolean prijavljen) {
		this.prijavljen = prijavljen;
	}
	public String getKolokvijum() {
		return kolokvijum;
	}
	public void setKolokvijum(String kolokvijum) {
		this.kolokvijum = kolokvijum;
	}
	public String getVezbe() {
		return vezbe;
	}
	public void setVezbe(String vezbe) {
		this.vezbe = vezbe;
	}
	public String getPrisustvno() {
		return prisustvno;
	}
	public void setPrisustvno(String prisustvno) {
		this.prisustvno = prisustvno;
	}
	public Number getOcena() {
		return ocena;
	}
	public void setOcena(Number ocena) {
		this.ocena = ocena;
	}
	
	

}

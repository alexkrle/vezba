package rs.ac.uns.ftn.eo.students.web.dto;

import rs.ac.uns.ftn.eo.students.model.Student;

public class StudentDTO {
	private Long id;
	String brIndexa;
	private String ime;
	private String prezime;
	private String adresa;
	private String mail;
	private int godina;
	private int semestar;
	private String budzet;
	
	public StudentDTO(){
		
	}

	public StudentDTO(Student student) {
		this(student.getId(), student.getBrIndexa(), student.getIme(),
				student.getPrezime(), student.getAdresa(), student.getMail(), student.getGodina(), student.getSemestar(), student.getBudzet());
	}

	public StudentDTO(Long id, String brIndexa, String ime,
			String prezime, String adresa, String mail, int godina, int semestar, String budzet) {
		this.id = id;
		this.brIndexa = brIndexa;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.mail = mail;
		this.godina = godina;
		this.semestar = semestar;
		this.budzet = budzet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrIndexa() {
		return brIndexa;
	}

	public void setBrIndexa(String brIndexa) {
		this.brIndexa = brIndexa;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public String getBudzet() {
		return budzet;
	}

	public void setBudzet(String budzet) {
		this.budzet = budzet;
	}

	
	
}

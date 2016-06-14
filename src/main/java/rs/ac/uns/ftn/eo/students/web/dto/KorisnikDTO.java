package rs.ac.uns.ftn.eo.students.web.dto;

import rs.ac.uns.ftn.eo.students.model.Korisnik;

public class KorisnikDTO {
	
	private long id;
	private String username;
	private String password;
	
	public KorisnikDTO() {
		
	}
	
	public KorisnikDTO (Korisnik korisnik) {
		this(korisnik.getId(),korisnik.getUsername(),korisnik.getPassword());
	}
	
	public KorisnikDTO (Long id,String username,String password) {
		this.id = id;
		this.username = username;
		this.password = password;

	}

	public Long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}


}

package rs.ac.uns.ftn.eo.students.web.dto;


import rs.ac.uns.ftn.eo.students.model.PolaganjeIspita;

public class PolaganjeIspitaDTO {
	
	private long id;
	private boolean polozen;
	private boolean prijavljen;
	private String kolokvijum;
	private String vezbe;
	private String prisustvno;
	private Number ocena;
	
	public PolaganjeIspitaDTO() {
		
	}
	
	public PolaganjeIspitaDTO (PolaganjeIspita polaganjeIspita) {
		this(polaganjeIspita.getId(),polaganjeIspita.isPolozen(),polaganjeIspita.isPrijavljen(),polaganjeIspita.getKolokvijum(),polaganjeIspita.getVezbe(),polaganjeIspita.getPrisustvno(),polaganjeIspita.getOcena());
	}
	
	public PolaganjeIspitaDTO (Long id,boolean polozen,boolean prijavljen,String kolokvijum,String vezbe,String prisustvno,Number ocena) {
		this.id = id;
		this.polozen = polozen;
		this.prijavljen = prijavljen;
		this.kolokvijum = kolokvijum;
		this.vezbe= vezbe;
		this.prisustvno = prisustvno;
		this.ocena = ocena;

	}

	public Long getId() {
		return id;
	}
	
	public boolean isPolozen() {
		return polozen;
	}
	
	public boolean isPrijavljen() {
		return prijavljen;
	}
	
	public String getKolokvijum(){
		return kolokvijum;
	}
	
	public String getVezbe(){
		return vezbe;
	}
	
	public String getPrisustvno(){
		return prisustvno;
	}
	
	public Number getOcena(){
		return ocena;
	}
	
	
	

}

package rs.ac.uns.ftn.eo.students.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.eo.students.model.Korisnik;
import rs.ac.uns.ftn.eo.students.service.KorisnikService;
import rs.ac.uns.ftn.eo.students.web.dto.KorisnikDTO;

@RestController
@RequestMapping(value="api/korisnici")
public class KorisnikController {
	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KorisnikDTO>> getKorisnici() {
		List<Korisnik> korisnici = korisnikService.findAll();
		//convert courses to DTOs
		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		for (Korisnik k : korisnici) {
			korisniciDTO.add(new KorisnikDTO(k));
		}
		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable Long id){
		Korisnik korisnik = korisnikService.findOne(id);
		if(korisnik == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<KorisnikDTO> saveKorisnik(@RequestBody KorisnikDTO korisnikDTO){
		Korisnik korisnik = new Korisnik();
		korisnik.setUsername(korisnikDTO.getUsername());
		korisnik.setPassword(korisnikDTO.getPassword());
	
		korisnik = korisnikService.save(korisnik);
		return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<KorisnikDTO> updateKorisnik(@RequestBody KorisnikDTO korisnikDTO){
		//a korisnik must exist
		Korisnik korisnik = korisnikService.findOne(korisnikDTO.getId()); 
		if (korisnik == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		korisnik.setId(korisnikDTO.getId());
		korisnik.setPassword(korisnikDTO.getPassword());
		korisnik.setUsername(korisnikDTO.getUsername());
	
		korisnik = korisnikService.save(korisnik);
		return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.OK);	
	}
	

	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id){
		Korisnik korisnik = korisnikService.findOne(id);
		if (korisnik != null){
			korisnikService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}

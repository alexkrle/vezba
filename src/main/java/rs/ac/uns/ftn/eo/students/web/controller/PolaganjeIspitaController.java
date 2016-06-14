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

import rs.ac.uns.ftn.eo.students.model.PolaganjeIspita;

import rs.ac.uns.ftn.eo.students.service.PolaganjeIspitaService;
import rs.ac.uns.ftn.eo.students.web.dto.PolaganjeIspitaDTO;


@RestController
@RequestMapping(value="api/polaganjaispita")
public class PolaganjeIspitaController {
	@Autowired
	private PolaganjeIspitaService polaganjeIspitaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PolaganjeIspitaDTO>> getPolaganjaIspita() {
		List<PolaganjeIspita> polaganjaIspita = polaganjeIspitaService.findAll();

		List<PolaganjeIspitaDTO> polaganjaIspitaDTO = new ArrayList<>();
		for (PolaganjeIspita pi : polaganjaIspita) {
			polaganjaIspitaDTO.add(new PolaganjeIspitaDTO(pi));
		}
		return new ResponseEntity<>(polaganjaIspitaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PolaganjeIspitaDTO> getPolaganjeIspita(@PathVariable Long id){
		PolaganjeIspita polaganjeIspita = polaganjeIspitaService.findOne(id);
		if(polaganjeIspita == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PolaganjeIspitaDTO(polaganjeIspita), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PolaganjeIspitaDTO> savePolaganjeIspita(@RequestBody PolaganjeIspitaDTO polaganjeIspitaDTO){
		PolaganjeIspita polaganjeIspita = new PolaganjeIspita();
		polaganjeIspita.setKolokvijum(polaganjeIspitaDTO.getKolokvijum());
		polaganjeIspita.setOcena(polaganjeIspitaDTO.getOcena());
		polaganjeIspita.setPolozen(polaganjeIspitaDTO.isPolozen());
		polaganjeIspita.setPrijavljen(polaganjeIspitaDTO.isPrijavljen());
		polaganjeIspita.setPrisustvno(polaganjeIspitaDTO.getPrisustvno());
		polaganjeIspita.setVezbe(polaganjeIspitaDTO.getVezbe());
	
		polaganjeIspita = polaganjeIspitaService.save(polaganjeIspita);
		return new ResponseEntity<>(new PolaganjeIspitaDTO(polaganjeIspita), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PolaganjeIspitaDTO> updatePolaganjeIspita(@RequestBody PolaganjeIspitaDTO polaganjeIspitaDTO){
		//a course must exist
		PolaganjeIspita polaganjeIspita = polaganjeIspitaService.findOne(polaganjeIspitaDTO.getId()); 
		if (polaganjeIspita == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		polaganjeIspita.setId(polaganjeIspitaDTO.getId());
		polaganjeIspita.setKolokvijum(polaganjeIspitaDTO.getKolokvijum());
		polaganjeIspita.setOcena(polaganjeIspita.getOcena());
		polaganjeIspita.setPrisustvno(polaganjeIspita.getPrisustvno());
		polaganjeIspita.setVezbe(polaganjeIspita.getVezbe());
	
		polaganjeIspita = polaganjeIspitaService.save(polaganjeIspita);
		return new ResponseEntity<>(new PolaganjeIspitaDTO(polaganjeIspita), HttpStatus.OK);	
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePolaganjeIspita(@PathVariable Long id){
		PolaganjeIspita polaganjeIspita = polaganjeIspitaService.findOne(id);
		if (polaganjeIspita != null){
			polaganjeIspitaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}

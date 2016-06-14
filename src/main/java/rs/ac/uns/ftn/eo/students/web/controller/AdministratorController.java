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

import rs.ac.uns.ftn.eo.students.model.Administrator;
import rs.ac.uns.ftn.eo.students.service.AdministratorService;

import rs.ac.uns.ftn.eo.students.web.dto.AdministratorDTO;


@RestController
@RequestMapping(value="api/administratori")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<AdministratorDTO>> getAllAdministratori() {
		List<Administrator> administrators = administratorService.findAll();

		List<AdministratorDTO> administratorsDTO = new ArrayList<>();
		for (Administrator a : administrators) {
			administratorsDTO.add(new AdministratorDTO(a));
		}
		return new ResponseEntity<>(administratorsDTO, HttpStatus.OK);
	}
	

		
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<AdministratorDTO> getAdministrator(@PathVariable Long id){
			Administrator administrator = administratorService.findOne(id);
			if(administrator == null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(new AdministratorDTO(administrator), HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.POST, consumes="application/json")
		public ResponseEntity<AdministratorDTO> saveAdministrator(@RequestBody AdministratorDTO administratorDTO){
			Administrator administrator = new Administrator();
			
			administrator = administratorService.save(administrator);
			return new ResponseEntity<>(new AdministratorDTO(administrator), HttpStatus.CREATED);	
		}
		
		@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
		public ResponseEntity<AdministratorDTO> updateAdministrator(@RequestBody AdministratorDTO administratorDTO){
			//a course must exist
			Administrator administrator = administratorService.findOne(administratorDTO.getId()); 
			if (administrator == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			administrator.setId(administratorDTO.getId());
		
			administrator = administratorService.save(administrator);
			return new ResponseEntity<>(new AdministratorDTO(administrator), HttpStatus.OK);	
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id){
			Administrator administrator = administratorService.findOne(id);
			if (administrator != null){
				administratorService.remove(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {		
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		

		
		

}

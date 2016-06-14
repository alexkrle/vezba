package rs.ac.uns.ftn.eo.students.web.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.eo.students.model.Enrollment;
import rs.ac.uns.ftn.eo.students.model.Profesor;
import rs.ac.uns.ftn.eo.students.service.ProfesorService;
import rs.ac.uns.ftn.eo.students.web.dto.CourseDTO;
import rs.ac.uns.ftn.eo.students.web.dto.EnrollmentDTO;
import rs.ac.uns.ftn.eo.students.web.dto.ProfesorDTO;


@RestController
@RequestMapping(value="api/profesors")
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTO>> getAllProfesors() {
		List<Profesor> profesors = profesorService.findAll();
		//convert students to DTOs
		List<ProfesorDTO> profesorsDTO = new ArrayList<>();
		for (Profesor p : profesors) {
			profesorsDTO.add(new ProfesorDTO(p));
		}
		return new ResponseEntity<>(profesorsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTO>> getProfesorsPage(Pageable page) {
		//page object holds data about pagination and sorting
		//the object is created based on the url parameters "page", "size" and "sort" 
		Page<Profesor> profesors = profesorService.findAll(page);
	
		//convert students to DTOs
		List<ProfesorDTO> profesorsDTO = new ArrayList<>();
		for (Profesor p : profesors) {
			profesorsDTO.add(new ProfesorDTO(p));
		}
			return new ResponseEntity<>(profesorsDTO, HttpStatus.OK);
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<ProfesorDTO> getProfesor(@PathVariable Long id){
			Profesor profesor = profesorService.findOne(id);
			if(profesor == null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(new ProfesorDTO(profesor), HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.POST, consumes="application/json")
		public ResponseEntity<ProfesorDTO> saveProfesor(@RequestBody ProfesorDTO profesorDTO){
			Profesor profesor = new Profesor();
			profesor.setIme(profesorDTO.getIme());
			profesor.setPrezime(profesorDTO.getPrezime());
			profesor.setUloga(profesorDTO.getUloga());
			profesor.setMail(profesorDTO.getMail());

			
			profesor = profesorService.save(profesor);
			return new ResponseEntity<>(new ProfesorDTO(profesor), HttpStatus.CREATED);	
		}
		
		@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
		public ResponseEntity<ProfesorDTO> updateProfesor(@RequestBody ProfesorDTO profesorDTO){
			//a profesor must exist
			Profesor profesor = profesorService.findOne(profesorDTO.getId()); 
			if (profesor == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			profesor.setId(profesorDTO.getId());
			profesor.setIme(profesorDTO.getIme());
			profesor.setMail(profesorDTO.getMail());
			profesor.setPrezime(profesorDTO.getPrezime());
			profesor.setUloga(profesorDTO.getUloga());
			
			profesor = profesorService.save(profesor);
			return new ResponseEntity<>(new ProfesorDTO(profesor), HttpStatus.OK);	
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteProfesor(@PathVariable Long id){
			Profesor profesor = profesorService.findOne(id);
			if (profesor != null){
				profesorService.remove(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {		
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		@RequestMapping(value = "/findIme", method = RequestMethod.GET)
		public ResponseEntity<List<ProfesorDTO>> getProfesorsByIme(
				@RequestParam String Ime) {
			List<Profesor> profesors = profesorService.findByIme(Ime);
			//convert students to DTOs
			List<ProfesorDTO> profesorsDTO = new ArrayList<>();
			for (Profesor p : profesors) {
				profesorsDTO.add(new ProfesorDTO(p));
			}
			return new ResponseEntity<>(profesorsDTO, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/findPrezime", method = RequestMethod.GET)
		public ResponseEntity<List<ProfesorDTO>> getProfesorsByPrezime(
				@RequestParam String Prezime) {
			List<Profesor> profesors = profesorService.findByIme(Prezime);
			//convert students to DTOs
			List<ProfesorDTO> profesorsDTO = new ArrayList<>();
			for (Profesor p : profesors) {
				profesorsDTO.add(new ProfesorDTO(p));
			}
			return new ResponseEntity<>(profesorsDTO, HttpStatus.OK);
		} 
		
		@RequestMapping(value = "/{profesorId}/courses", method = RequestMethod.GET)
		public ResponseEntity<List<EnrollmentDTO>> getProfesorCourses(
				@PathVariable Long profesorId) {
			Profesor profesor = profesorService.findOne(profesorId);
			Set<Enrollment> enrollments = profesor.getEnrollments();
			List<EnrollmentDTO> enrollmentsDTO = new ArrayList<>();
			for (Enrollment e: enrollments) {
				EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
				enrollmentDTO.setId(e.getId());
				enrollmentDTO.setStartDate(e.getStartDate());
				enrollmentDTO.setEndDate(e.getEndDate());
				enrollmentDTO.setCourse(new CourseDTO(e.getCourse()));
				//we leave student field empty
				
				enrollmentsDTO.add(enrollmentDTO);
			}
			return new ResponseEntity<>(enrollmentsDTO, HttpStatus.OK);
		}
}

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
import rs.ac.uns.ftn.eo.students.model.Student;
import rs.ac.uns.ftn.eo.students.service.StudentService;
import rs.ac.uns.ftn.eo.students.web.dto.CourseDTO;
import rs.ac.uns.ftn.eo.students.web.dto.EnrollmentDTO;
import rs.ac.uns.ftn.eo.students.web.dto.StudentDTO;

@RestController
@RequestMapping(value="api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
		List<Student> students = studentService.findAll();
		//convert students to DTOs
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentsPage(Pageable page) {
		//page object holds data about pagination and sorting
		//the object is created based on the url parameters "page", "size" and "sort" 
		Page<Student> students = studentService.findAll(page);
		
		//convert students to DTOs
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
		Student student = new Student();
		student.setBrIndexa(studentDTO.getBrIndexa());
		student.setIme(studentDTO.getIme());
		student.setPrezime(studentDTO.getPrezime());
		student.setAdresa(studentDTO.getAdresa());
		student.setMail(studentDTO.getMail());
		student.setGodina(studentDTO.getGodina());
		student.setSemestar(studentDTO.getSemestar());
		student.setBudzet(studentDTO.getBudzet());
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
		//a student must exist
		Student student = studentService.findOne(studentDTO.getId()); 
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		student.setBrIndexa(studentDTO.getBrIndexa());
		student.setIme(studentDTO.getIme());
		student.setPrezime(studentDTO.getPrezime());
		student.setAdresa(studentDTO.getAdresa());
		student.setMail(studentDTO.getMail());
		student.setGodina(studentDTO.getGodina());
		student.setSemestar(studentDTO.getSemestar());
		student.setBudzet(studentDTO.getBudzet());
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if (student != null){
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/findBrIndexa", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudentByCard(
			@RequestParam String BrIndexa) {
		Student student = studentService.findByCard(BrIndexa);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findPrezime", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentsByPrezime(
			@RequestParam String prezime) {
		List<Student> students = studentService.findByPrezime(prezime);
		//convert students to DTOs
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}
		return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/{studentId}/courses", method = RequestMethod.GET)
	public ResponseEntity<List<EnrollmentDTO>> getStudentCourses(
			@PathVariable Long studentId) {
		Student student = studentService.findOne(studentId);
		Set<Enrollment> enrollments = student.getEnrollments();
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

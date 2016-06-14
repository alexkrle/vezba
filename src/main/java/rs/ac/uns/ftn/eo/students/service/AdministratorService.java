package rs.ac.uns.ftn.eo.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.eo.students.model.Administrator;
import rs.ac.uns.ftn.eo.students.repository.AdministratorRepository;


@Service
public class AdministratorService {
	@Autowired
	AdministratorRepository administratorRepository;
	
	public Administrator findOne(Long id) {
		return administratorRepository.findOne(id);
	}

	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	public Administrator save(Administrator administrator) {
		return administratorRepository.save(administrator);
	}

	public void remove(Long id) {
		administratorRepository.delete(id);
	}
}

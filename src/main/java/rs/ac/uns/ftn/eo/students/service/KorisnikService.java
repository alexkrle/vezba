package rs.ac.uns.ftn.eo.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.eo.students.model.Korisnik;
import rs.ac.uns.ftn.eo.students.repository.KorisnikRepository;

@Service
public class KorisnikService {
	@Autowired
	KorisnikRepository korisnikRepository;
	
	public Korisnik findOne(Long id) {
		return korisnikRepository.findOne(id);
	}

	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}

	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	public void remove(Long id) {
		korisnikRepository.delete(id);
	}
}

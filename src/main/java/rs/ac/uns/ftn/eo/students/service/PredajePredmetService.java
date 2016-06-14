package rs.ac.uns.ftn.eo.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import rs.ac.uns.ftn.eo.students.model.PredajePredmet;
import rs.ac.uns.ftn.eo.students.repository.PredajePredmetRepository;

@Service
public class PredajePredmetService {
	@Autowired
	PredajePredmetRepository predajePredmetRepository;
	
	public PredajePredmet findOne(Long id) {
		return predajePredmetRepository.findOne(id);
	}

	public List<PredajePredmet> findAll() {
		return predajePredmetRepository.findAll();
	}

	public PredajePredmet save(PredajePredmet predajePredmet) {
		return predajePredmetRepository.save(predajePredmet);
	}

	public void remove(Long id) {
		predajePredmetRepository.delete(id);
	}
}
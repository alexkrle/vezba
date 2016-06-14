package rs.ac.uns.ftn.eo.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.eo.students.model.Administrator;


public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
package fr.demos.formation.data;

import org.springframework.stereotype.Repository;

import fr.demos.formation.model.Compte;

@Repository
public interface CompteDAO {

	void insert (Compte a) throws Exception;
	
}

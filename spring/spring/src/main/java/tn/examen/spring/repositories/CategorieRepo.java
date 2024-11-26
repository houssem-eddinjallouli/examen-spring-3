package tn.examen.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.examen.spring.entities.Categorie;

public interface CategorieRepo extends JpaRepository<Categorie,Long> {
}

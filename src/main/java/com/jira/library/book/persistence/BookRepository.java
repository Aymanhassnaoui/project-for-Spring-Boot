package com.jira.library.book.persistence;
 // Attention à la casse du nom (doit correspondre à ton fichier)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jira.library.book.model.BooKEntity;

@Repository
public interface BookRepository extends JpaRepository<BooKEntity, Long> {

    /**
     * Cette méthode est dérivée par Spring Data JPA.
     * Elle va générer la requête SQL : 
     * SELECT count(*) > 0 FROM book WHERE page_number = ? AND title = ?
     */
    boolean existsByPageNumberAndTitle(Integer pageNumber, String title);
    
}

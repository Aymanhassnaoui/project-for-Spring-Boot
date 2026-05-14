package com.jira.library.book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Table(name = "book") // Dit à MySQL : "Crée une table qui s'appelle 'book' pour stocker les livres"
@Entity
public class BooKEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // <-- Mets un L majuscule ici !

    @NotBlank(message = "Le titre ne peut pas être vide")
    String title;


    @Min(value = 1, message = "Le nombre de pages doit être au moins 1")
    Integer pageNumber;

    @Min(value = 0, message = "Le prix ne peut pas être négatif")
    // Cette ligne force MySQL à refuser les prix < 0 au niveau de la base
    @Column(columnDefinition = "INT CHECK (price >= 0)")
    Integer price;

}

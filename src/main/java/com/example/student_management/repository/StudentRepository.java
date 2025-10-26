package com.example.student_management.repository;

import com.example.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Recherche d'un étudiant par son identifiant
    Optional<Student> findById(int id);

    // Recherche d'étudiants par nom
    Collection<Student> findByNom(String nom);

    // Recherche d'étudiants par prénom
    Collection<Student> findByPrenom(String prenom);

    // Requête personnalisée pour compter les étudiants par année de naissance
    @Query("SELECT YEAR(s.dateNaissance), COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance) ORDER BY YEAR(s.dateNaissance)")
    Collection<Object[]> findNbrStudentByYear();


}

package com.example.student_management.service;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Sauvegarder ou mettre à jour un étudiant
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Supprimer un étudiant par son ID
    public boolean delete(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        } else {
            return false;
        }
    }

    // Récupérer tous les étudiants
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Compter le nombre total d'étudiants
    public long countStudents() {
        return studentRepository.count();
    }

    // Récupérer les statistiques par année de naissance
    public Collection<Object[]> findNbrStudentByYear() {
        return studentRepository.findNbrStudentByYear();
    }

    // Récupérer un étudiant par son ID
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    // Récupérer les étudiants par nom
    public Collection<Student> findByNom(String nom) {
        return studentRepository.findByNom(nom);
    }

    // Récupérer les étudiants par prénom
    public Collection<Student> findByPrenom(String prenom) {
        return studentRepository.findByPrenom(prenom);
    }
}
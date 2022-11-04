package ism.inscriptions.repositories;

import java.util.List;

import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Professeur;

public interface IProfesseurRepository {
    public Professeur insert(Professeur prof);
    public Professeur findById(int id);
    public List<Professeur> findAll();
    public Professeur findByNci(String nci);
    public List<Professeur> findAllByClasse(Classe classe);
}

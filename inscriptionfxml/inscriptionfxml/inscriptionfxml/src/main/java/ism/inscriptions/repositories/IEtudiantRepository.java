package ism.inscriptions.repositories;

import java.util.List;

import ism.inscriptions.entities.Etudiant;

public interface IEtudiantRepository {
    public Etudiant insert(Etudiant etu);
    public List<Etudiant> findAll();
    public List<Etudiant> findAll(String annee);
    public Etudiant findByMatricule(String matricule);
    public List<Etudiant> findAll(String annee,int idclasse);

}

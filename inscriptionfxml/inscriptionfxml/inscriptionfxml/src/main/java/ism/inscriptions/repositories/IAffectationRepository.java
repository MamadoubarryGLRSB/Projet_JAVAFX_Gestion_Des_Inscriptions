package ism.inscriptions.repositories;

import java.util.List;

import ism.inscriptions.entities.AffectationClasse;

public interface IAffectationRepository {
    public AffectationClasse insert(AffectationClasse  affClasse);
    public List<AffectationClasse > findByProfesseur(int id_prof);
}

package ism.inscriptions.repositories;

import java.util.List;

import ism.inscriptions.entities.Classe;
public interface IClasseRepository {
    public Classe insert(Classe classe);
    public int  update(Classe classe);
    public Classe findById(int id);
    public List<Classe> findAll();
    public Classe findByLibelle(String libelle);
    
}

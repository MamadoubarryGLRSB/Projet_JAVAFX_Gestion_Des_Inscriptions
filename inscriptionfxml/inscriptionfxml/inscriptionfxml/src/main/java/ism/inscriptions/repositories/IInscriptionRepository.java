package ism.inscriptions.repositories;

import java.util.List;

import ism.inscriptions.entities.Inscription;

public interface IInscriptionRepository {
    public Inscription insert(Inscription insc);
    public List<Inscription> findAll();
}

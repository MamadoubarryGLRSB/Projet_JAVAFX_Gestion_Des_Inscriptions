package ism.inscriptions.services;

import java.util.List;

import ism.inscriptions.entities.AffectationClasse;
import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Inscription;
import ism.inscriptions.entities.Professeur;
import ism.inscriptions.entities.User;

public interface IInscriptionService {
   public Inscription inscription(Inscription ins);
   public Classe ajouterClasse(Classe cl);
   public List<Classe> listerClasse();
   public boolean modifierClasse(Classe cl);
   public List<Etudiant>  ListerInscristUneClasse(int idClasse,String annee);
   public Professeur ajouterProfesseur(Professeur prof);
   public List<Professeur> listerProfesseur();
   public List<Etudiant> listerEtudiant();
   public AffectationClasse affecter(AffectationClasse affec);
   public List<Classe> listerClasseUnProfesseur(int idProf,String anne);
   public User connexion(String login,String password);
   public List<String> listerAnneeScolaire();
   public Classe rechercherClasseParLibelle(String libelle);
   public Professeur rechercherProfesseurParNci(String nci);
   public Etudiant rechercherEtudiantParMatricule(String matricule);
   public List<Etudiant>  ListerInscristAnne(String annee);
   public Etudiant ajouterEtudiant(Etudiant etudiant);
   public Inscription ajouterInscription(Inscription inscription);
   public  List<Professeur> listerProfesseur(Classe classe);
   public  List<Etudiant> listerEtudiants(Classe classe);
   
     
}

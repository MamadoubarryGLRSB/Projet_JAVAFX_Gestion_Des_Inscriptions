package ism.inscriptions.services;
import java.util.List;

import ism.inscriptions.entities.AffectationClasse;
import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Inscription;
import ism.inscriptions.entities.Professeur;
import ism.inscriptions.entities.User;
import ism.inscriptions.repositories.IAffectationRepository;
import ism.inscriptions.repositories.IAnneeRepository;
import ism.inscriptions.repositories.IClasseRepository;
import ism.inscriptions.repositories.IEtudiantRepository;
import ism.inscriptions.repositories.IInscriptionRepository;
import ism.inscriptions.repositories.IProfesseurRepository;
import ism.inscriptions.repositories.IUserRepository;


public class InscriptionService implements IInscriptionService{
    IAffectationRepository iAffectationRepository;
    IAnneeRepository iAnneeRepository;
    IClasseRepository iClasseRepository;
    IEtudiantRepository iEtudiantRepository;
    IInscriptionRepository iInscriptionRepository;
    IProfesseurRepository iProfesseurRepository;
    IUserRepository iUserRepository;
    

    
    
    public InscriptionService() {
    }

    public InscriptionService(IAffectationRepository iAffectationRepository, IAnneeRepository iAnneeRepository,
            IClasseRepository iClasseRepository, IEtudiantRepository iEtudiantRepository,
            IInscriptionRepository iInscriptionRepository, IProfesseurRepository iProfesseurRepository,
            IUserRepository iUserRepository) {
        this.iAffectationRepository = iAffectationRepository;
        this.iAnneeRepository = iAnneeRepository;
        this.iClasseRepository = iClasseRepository;
        this.iEtudiantRepository = iEtudiantRepository;
        this.iInscriptionRepository = iInscriptionRepository;
        this.iProfesseurRepository = iProfesseurRepository;
        this.iUserRepository = iUserRepository;
    }

    

    @Override
    public Classe ajouterClasse(Classe cl) {
        return iClasseRepository.insert(cl);
    }

    @Override
    public List<Classe> listerClasse() {
        return iClasseRepository.findAll();
    }

    @Override
    public boolean modifierClasse(Classe cl) {
        return iClasseRepository.update(cl)!=0;
    }

    @Override
    public List<Etudiant> ListerInscristUneClasse(int idClasse, String annee) {
        return iEtudiantRepository.findAll(annee, idClasse);
    }

    @Override
    public Professeur ajouterProfesseur(Professeur prof) {
        return iProfesseurRepository.insert(prof);
    }

    @Override
    public List<Professeur> listerProfesseur() {
        return iProfesseurRepository.findAll();
    }

    @Override
    public List<Etudiant> listerEtudiant() {
        return iEtudiantRepository.findAll();
    }

    

    @Override
    public List<Classe> listerClasseUnProfesseur(int idProf, String anne) {
        return iClasseRepository.findAll();
    }

    @Override
    public User connexion(String login, String password) {
        return iUserRepository.findLoginAndPassword(login, password);
    }

    @Override
    public List<String> listerAnneeScolaire() {
        return iAnneeRepository.findAll();
    }

    @Override
    public Classe rechercherClasseParLibelle(String libelle) {
        return iClasseRepository.findByLibelle(libelle);
    }

    @Override
    public Professeur rechercherProfesseurParNci(String nci) {
        return iProfesseurRepository.findByNci(nci);
    }

    @Override
    public Etudiant rechercherEtudiantParMatricule(String matricule) {
        return iEtudiantRepository.findByMatricule(matricule);
    }

    @Override
    public List<Etudiant> ListerInscristAnne(String annee) {
       return iEtudiantRepository.findAll(annee);
    }

    @Override
    public Inscription inscription(Inscription ins) {
        
        return iInscriptionRepository.insert(ins);
    }

    @Override
    public AffectationClasse affecter(AffectationClasse affec) {
        
        return iAffectationRepository.insert(affec);
    }

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        // TODO Auto-generated method stub
        return iEtudiantRepository.insert(etudiant);
    }

    @Override
    public Inscription ajouterInscription(Inscription inscription) {
        // TODO Auto-generated method stub
        return iInscriptionRepository.insert(inscription);
    }

    
    
}


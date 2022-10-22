package ism.inscriptions.core;

import ism.inscriptions.repositories.IAffectationRepository;
import ism.inscriptions.repositories.IAnneeRepository;
import ism.inscriptions.repositories.IClasseRepository;
import ism.inscriptions.repositories.IEtudiantRepository;
import ism.inscriptions.repositories.IInscriptionRepository;
import ism.inscriptions.repositories.IProfesseurRepository;
import ism.inscriptions.repositories.IUserRepository;
import ism.inscriptions.repositories.bd.AffectationRepository;
import ism.inscriptions.repositories.bd.AnneeRepository;
import ism.inscriptions.repositories.bd.ClasseRepository;
import ism.inscriptions.repositories.bd.EtudiantRepository;
import ism.inscriptions.repositories.bd.InscriptionRepository;
import ism.inscriptions.repositories.bd.ProfesseurRepository;
import ism.inscriptions.repositories.bd.UserRepository;
import ism.inscriptions.services.IInscriptionService;
import ism.inscriptions.services.InscriptionService;

public class Fabrique {
    public static IInscriptionService getService(){
        IAffectationRepository affectationRepository=new AffectationRepository();
        IAnneeRepository anneeRepository=new AnneeRepository();
        IClasseRepository classeRepository=new ClasseRepository();
        IEtudiantRepository etudiantRepository=new EtudiantRepository();
        IInscriptionRepository inscriptionRepository=new InscriptionRepository();
        IProfesseurRepository professeurRepository=new ProfesseurRepository();
        IUserRepository userRepository=new UserRepository();
        return new InscriptionService(affectationRepository, anneeRepository, classeRepository, etudiantRepository, inscriptionRepository, professeurRepository, userRepository);
        
    }
    
}

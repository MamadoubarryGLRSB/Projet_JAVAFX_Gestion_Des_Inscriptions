package ism.inscriptions.entities;

public class Etudiant extends User{
   

    private String matricule;
    private String tuteur;
    private Classe classe;

    


    public Etudiant(String nom_complet, String matricule, String tuteur, Classe classe) {
        super(nom_complet);
        this.matricule = matricule;
        this.tuteur = tuteur;
        this.classe = classe;
    }



    public Etudiant(String nom_complet, String matricule, String tuteur) {
        super(nom_complet);
        this.matricule = matricule;
        this.tuteur = tuteur;
        role="ROLE_ETUDIANT";
    }



    public Etudiant(int id, String nom_complet, String matricule, String tuteur) {
        super(id, nom_complet);
        this.matricule = matricule;
        this.tuteur = tuteur;
        role="ROLE_ETUDIANT";
    }



    public Etudiant(String nom_complet, String login, String password, String role, String matricule, String tuteur) {
        super(nom_complet, login, password, role);
        this.matricule = matricule;
        this.tuteur = tuteur;
        role="ROLE_ETUDIANT";
    }



    public Etudiant(int id, String nom_complet, String login, String password, String role, String matricule,
            String tuteur) {
        super(id, nom_complet, login, password, role);
        this.matricule = matricule;
        this.tuteur = tuteur;
        role="ROLE_ETUDIANT";
        
    }



    


    public Etudiant() {
    }

    

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    
    

    

    
    
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }



    @Override
    public String toString() {
        return  matricule;
    }

    



    



    
    
    
    
}

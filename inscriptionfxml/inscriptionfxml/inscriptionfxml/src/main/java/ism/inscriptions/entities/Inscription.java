package ism.inscriptions.entities;


public class Inscription {
    private int id;
    private String dateInscription;
    private String annee;
    private Etudiant etu;
    private static int nbr;

   

   

    public Inscription(String dateInscription, String annee, Etudiant etu) {
        this.dateInscription = dateInscription;
        this.annee = annee;
        this.etu = etu;
    }

    public Inscription(int id, String dateInscription, String annee) {
        this.id = id;
        this.dateInscription = dateInscription;
        this.annee = annee;
    }

    public Inscription(String annee, Classe classe, Etudiant etu) {
        this.annee = annee;
        
        this.etu = etu;
        nbr+=1;
        id=nbr;
    }

    public int getId() {
        return id;
    }

    public Inscription() {
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    

    public Etudiant getEtu() {
        return etu;
    }

    public void setEtu(Etudiant etu) {
        this.etu = etu;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public static int getNbr() {
        return nbr;
    }

    public static void setNbr(int nbr) {
        Inscription.nbr = nbr;
    }
    
}

package ism.inscriptions.entities;
import java.util.ArrayList;
import java.util.List;


public class Professeur extends User {
    
    private String nci;
    private String grade;
    private List<AffectationClasse> classesEns=new ArrayList<>();

   

   







    public Professeur(String nom_complet, String nci, String grade) {
        super(nom_complet);
        this.nci = nci;
        this.grade = grade;
        this.role="ROLE_PROFESSEUR";
    }






    public Professeur(int id, String nom_complet, String nci, String grade) {
        super(id, nom_complet);
        this.nci = nci;
        this.grade = grade;
        this.role="ROLE_PROFESSEUR";
    }






    public Professeur(String nom_complet, String login, String password, String role, String nci, String grade) {
        super(nom_complet, login, password, role);
        this.nci = nci;
        this.grade = grade;
        this.role="ROLE_PROFESSEUR";
    }






    public Professeur(int id, String nom_complet, String login, String password, String role, String nci,
            String grade) {
        super(id, nom_complet, login, password, role);
        this.nci = nci;
        this.grade = grade;
        this.role="ROLE_PROFESSEUR";
    }



    public Professeur() {
       
    }

   

    public List<AffectationClasse> getClasseEnseignees() {
        return classesEns;
    }

    public void setClasseEnseignees(List<AffectationClasse> classeEnseignees) {
        this.classesEns = classeEnseignees;
    }

    

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }






    



    public List<AffectationClasse> getClassesEns() {
        return classesEns;
    }



    public void setClassesEns(List<AffectationClasse> classesEns) {
        this.classesEns = classesEns;
    }
    
    
    
}

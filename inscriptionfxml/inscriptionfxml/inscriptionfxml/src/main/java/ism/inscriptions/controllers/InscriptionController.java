package ism.inscriptions.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Inscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class InscriptionController implements Initializable{

    @FXML
    private TextField textMatricule;

    @FXML
    private TextField textNomPrenom;

    @FXML
    private TextField textTuteur;

    @FXML
    private TextField textSeach;

    @FXML
    private TextField textDateIns;

    @FXML
    private TextField textAnee;

    @FXML
    private TableView<Etudiant> tbEtudiant=new TableView<>();

    @FXML
    private TableColumn<Etudiant,String> tbMatricule=new TableColumn<>();

    @FXML
    private TableColumn<Etudiant,String> tbTuteur=new TableColumn<>();

    @FXML
    private TableColumn<Etudiant,String> tbNomComplet=new TableColumn<>();
    Etudiant etudiant;
    Inscription inscription;
    @FXML
    ComboBox <Classe> cbox;
    Classe classe;
    private ObservableList<Etudiant> obAetudiant=FXCollections.observableList(Fabrique.getService().listerEtudiant());

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        tbMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        tbTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));
        tbNomComplet.setCellValueFactory(new PropertyValueFactory<>("nom_complet"));
        tbEtudiant.setItems(obAetudiant);
        List<Classe>classes=Fabrique.getService().listerClasse();
        for (Classe classe : classes) {
            cbox.getItems().add(classe);
            
        }
        cbox.setOnAction(this::selectClasse);
        
    }
    public void selectClasse(ActionEvent event){
        classe=cbox.getValue();

    }

    public void hanlInscription(){
        String matricule=textMatricule.getText().trim();
        String tuteur=textTuteur.getText().trim();
        String nomPrenom=textNomPrenom.getText().trim();
        String date=textDateIns.getText().trim();
        String annee=textAnee.getText().trim();
        etudiant=new Etudiant(nomPrenom, matricule, tuteur);
        etudiant.setClasse(classe);
        Fabrique.getService().ajouterEtudiant(etudiant);
        inscription=new Inscription(annee, date, etudiant);
        Fabrique.getService().ajouterInscription(inscription);
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion D'inscription");
        alert.setContentText("Un Etudiant a été ajouter avec succès et vient d'etre inscrit");
        alert.show();
        

    }
    public void seachEtudiantByMatricule(){
        String matriseach=textSeach.getText().trim();
        etudiant=Fabrique.getService().rechercherEtudiantParMatricule(matriseach);
        if(etudiant==null){
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion D'inscription");
        alert.setContentText("Cet etudiant n'existe pas !");
        alert.show();
        }else{
            textMatricule.setText(etudiant.getMatricule());
            textTuteur.setText(etudiant.getTuteur());
            textNomPrenom.setText(etudiant.getNom_complet());
            

        }


    }
    public void handlReinscription(){
        if(etudiant!=null){
            String date=textDateIns.getText().trim();
            String annee=textAnee.getText().trim();
            inscription=new Inscription(annee, date, etudiant);
            Fabrique.getService().ajouterInscription(inscription);
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion D'inscription");
            alert.setContentText("Vous a éte réinscrit avec succès");
            alert.show();

        }

    }

}

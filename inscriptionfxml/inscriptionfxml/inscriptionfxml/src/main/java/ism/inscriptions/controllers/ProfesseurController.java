package ism.inscriptions.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.AffectationClasse;
import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Professeur;
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

public class ProfesseurController implements Initializable{
  @FXML
  TableView<Professeur> tblProf=new TableView<>();
  @FXML
  TableColumn<Professeur,String> tbNci=new TableColumn<>();
  @FXML
  TableColumn<Professeur,String> tbNomPrenom=new TableColumn<>();
  @FXML
  TableColumn<Professeur,String> tbGrade=new TableColumn<>();
  private ObservableList<Professeur> obAprofesseur=FXCollections.observableList(Fabrique.getService().listerProfesseur());
  @FXML
  TextField textNci;
  @FXML
  TextField textGrade;
  @FXML
  TextField textNomPrenom,textLibelleProf,textAnnee;
  Professeur professeur;
  @FXML
  ComboBox <Classe> cbox;
  Classe classe;
  
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    tbNci.setCellValueFactory(new PropertyValueFactory<>("nci"));
    tbGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
    tbNomPrenom.setCellValueFactory(new PropertyValueFactory<>("nom_complet"));
    
    tblProf.setItems(obAprofesseur);
    List<Classe>classes=Fabrique.getService().listerClasse();
        for (Classe classe : classes) {
          cbox.getItems().add(classe);
            
        }
        cbox.setOnAction(this::selectClasse);
    
}
public void selectClasse(ActionEvent event){
  classe=cbox.getValue();

}
public void handleCreerProf(){
    String nci=textNci.getText().trim();
    String grade=textGrade.getText().trim();
    String nomPrenom=textNomPrenom.getText().trim();
    String annee=textAnnee.getText().trim();
    if(classe!=null){
      professeur=new Professeur(nomPrenom, nci, grade);
      Fabrique.getService().ajouterProfesseur(professeur);
      Fabrique.getService().affecter(new AffectationClasse(classe, professeur, annee));
      Alert alert=new Alert(AlertType.INFORMATION);
      alert.setTitle("Gestion D'inscription");
      alert.setContentText("Un professeur a été ajouter avec succès");
      alert.show();
      obAprofesseur.add(professeur);
      textNci.clear();
      textGrade.clear();
      textNomPrenom.clear();

    }else{
      Alert alert=new Alert(AlertType.INFORMATION);
      alert.setTitle("Gestion D'inscription");
      alert.setContentText("Oups Cette classe n'existe pas !");
      alert.show();
    }
    
    
    
    
    
    
    
    
}
}

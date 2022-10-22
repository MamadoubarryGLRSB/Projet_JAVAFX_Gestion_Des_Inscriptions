package ism.inscriptions.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.Classe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ClasseController implements Initializable {
  private Classe selected;

  @FXML
  TableView<Classe> tbClass=new TableView<>();
  @FXML
  TableColumn<Classe,String> tbId=new TableColumn<>();
  @FXML
  TableColumn<Classe,String> tbLibell=new TableColumn<>();
  private ObservableList<Classe> obAclasses=FXCollections.observableList(Fabrique.getService().listerClasse());
  @FXML
  TextField textLibelle;
  @FXML
  Text lblError;


  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
      tbId.setCellValueFactory(new PropertyValueFactory<>("id"));
      tbLibell.setCellValueFactory(new PropertyValueFactory<>("libelle"));
      tbClass.setItems(obAclasses);

      tbClass.getSelectionModel().selectedItemProperty().addListener((obv, old, newv) -> {
        if( newv != null) {
            this.selected = newv;
        }
      } );
      
  }
  public void handleCreerClass(){
      String libelle=textLibelle.getText().trim();
      Classe classe=Fabrique.getService().ajouterClasse(new Classe(libelle));
      Alert alert=new Alert(AlertType.INFORMATION);
      alert.setTitle("Gestion D'inscription");
      alert.setContentText("Une classe a été ajouter avec succès");
      alert.show();
      obAclasses.add(classe);
      textLibelle.clear();
      if(textLibelle.getText().trim().isEmpty()  ){
          lblError.setText("Libelle est Obligatoire");
          lblError.setVisible(true);
      }
      
      
      
  }
  public void handlEditClasse(){

    String libelle=textLibelle.getText().trim();
    
    selected.setLibellle(libelle);
    Fabrique.getService().modifierClasse(selected);
    obAclasses.set(obAclasses.indexOf(selected), selected);

  }
  
  

 
  
}

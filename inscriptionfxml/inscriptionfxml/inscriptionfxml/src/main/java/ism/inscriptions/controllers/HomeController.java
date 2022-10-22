package ism.inscriptions.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscriptions.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class HomeController implements Initializable {
    @FXML
    AnchorPane anchorContent;
    @FXML
    Button IdInscription,idEtudiant,idProf,idClasse;

    public void handleDeconnexion() throws IOException{
        App.setRoot("connexion");
    }
    public void handleViewClasses() throws IOException{
        this.loadViews("classe");
        

    }
   
    public void handleViewInscription() throws IOException{
        this.loadViews("inscription");
        

    }
    public void handleViewProf() throws IOException{
        this.loadViews("professeur");
        

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String root;
        if(ConnexionController.user.getRole().compareTo("ROLE_RP")==0){
            IdInscription.setDisable(true);
            root="classe";
        }else{
            idClasse.setDisable(true);
            idProf.setDisable(true);
            root="inscription";

        }
        try {
            this.loadViews(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public void loadViews(String fxml) throws IOException{
        AnchorPane root=(AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);


    }
}

package ism.inscriptions.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscriptions.App;
import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable {

    @FXML
    Text lbEr;
    @FXML
    TextField textLogin;
    @FXML
    TextField textPassword;
    public static User user;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lbEr.setVisible(false);
        
    }
    public void handConnexion() throws IOException{
        String login=textLogin.getText().trim();
        String password=textPassword.getText().trim();
        User u=Fabrique.getService().connexion(login, password);
        if(u==null){
            lbEr.setVisible(true);
        }else{
             user=u;

            lbEr.setVisible(false);
            App.setRoot("home");
        }

    }

}
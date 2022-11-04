package ism.inscriptions.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscriptions.App;
import ism.inscriptions.core.Fabrique;
import ism.inscriptions.core.Validator;
import ism.inscriptions.entities.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable {

    @FXML
    Text lbEr,lbErrorPassword,lbErrorLogin;
    @FXML
    TextField textLogin;
    @FXML
    TextField textPassword;
    @FXML
    Button btnConnexion;
    //observable
    SimpleBooleanProperty smpl=new SimpleBooleanProperty(false);
    // desactiver le button
    // faire un listener c'est a dire au moment ou le gars tape, on lui demande
    // d'entrer un email. Si le gars tape autre chose que du mail, on active un
    // message d'erreur. pour cela on cree un ecouteur

    public static User user;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lbEr.setVisible(false);
        lbErrorLogin.setVisible(false);
        lbErrorPassword.setVisible(false);
        // ecouteur d'evenement
        textLogin.textProperty().addListener((obv,old,newV) -> {
            if (newV.isEmpty()) {
                lbErrorLogin.setVisible(true);
            } else {

                if(!Validator.isEmail(newV)){
                    lbErrorLogin.setText("Entrer un email");
                    lbErrorLogin.setVisible(true);
                }else{
                    smpl.set(textPassword.getText().isEmpty());
                    lbErrorLogin.setVisible(false);
                }
                
            }
        });
        textPassword.textProperty().addListener((obv,old,newV)->{
            if(newV.isEmpty()){
                lbErrorPassword.setVisible(true);
            }
            else{
                smpl.set(!Validator.isEmail(textLogin.getText()));
                lbErrorPassword.setVisible(false);
            }
        });
        //on a fait du baidning des que la valeur de smpl change, automatiquement le statu du boutton change
        
        //si smpl est a true, le button sera desactive sinon active
        btnConnexion.disableProperty().bind(smpl);
        
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
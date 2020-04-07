package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.DataBaseHandler;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpLoginField;

    @FXML
    private PasswordField signUpPasswordField;

    @FXML
    private Button SignUpSignUpBtn;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpSurname;

    @FXML
    private TextField signUpLocation;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        SignUpSignUpBtn.setOnAction(event -> {
            dbHandler.signUpUser(signUpName.getText(), signUpSurname.getText(), signUpLoginField.getText(), signUpPasswordField.getText(), signUpLocation.getText(),"Male");

        });
    }
}


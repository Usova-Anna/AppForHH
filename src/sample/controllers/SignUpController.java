package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.model.DataBaseHandler;
import sample.User;
import sample.model.UserModel;
import sample.model.UserModelFactory;

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

        SignUpSignUpBtn.setOnAction(event -> {
            signUpNewUser();


        });
    }

    private void signUpNewUser() {
        UserModel dbHandler = UserModelFactory.getUM();
        String firstName = signUpName.getText();
        String lastName = signUpSurname.getText();
        String userName = signUpLoginField.getText();
        String password = signUpPasswordField.getText();
        String location = signUpLocation.getText();
        String gender = "";
        if (signUpCheckBoxMale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        User user = new User(firstName, lastName, userName, password, location, gender);
        dbHandler.signUpUser(user);

    }
}


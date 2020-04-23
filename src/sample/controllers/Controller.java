package sample.controllers;
/*
Авторизация в приложении
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animations.Shake;
import sample.model.UserModel;
import sample.model.UserModelFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    void initialize() {
        signInBtn.setOnAction(event -> {
            String loginText = loginField.getText().trim(); //удаляем лишние пробелы
            String loginPassword = passwordField.getText().trim();
            if (!"".equals(loginText) && !"".equals(loginPassword)) {
                loginUser(loginText, loginPassword);
            } else {
                System.out.println("Login/Password is empty");
            }
        });
        signUpBtn.setOnAction(event -> {
            openNewScene("/sample/view/SignUp.fxml");

        });

    }

    private void loginUser(String loginText, String loginPassword) {
        UserModel userModel = UserModelFactory.getUM();

        if (userModel.checkUser(loginText, loginPassword)) {
            openNewScene("/sample/view/app.fxml");
        } else {
            Shake userLoginAnim = new Shake(loginField);
            Shake userPassAnim = new Shake(passwordField);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }

    public void openNewScene(String window) {
        signUpBtn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

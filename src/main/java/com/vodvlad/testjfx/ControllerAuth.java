package com.vodvlad.testjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ControllerAuth {

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    public void handleBtn1() throws Exception{
        String loginLogin = login_field.getText().trim();
        String loginPassword = password_field.getText().trim();
        if(loginLogin.equals("") && loginPassword.equals("")){
            loginUser(loginLogin, loginPassword);
        } else {
            System.out.println("ERROR!");
        }
    }

    private void loginUser(String loginLogin, String loginPassword) {

    }

    public void handleBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage window = (Stage) loginSignUpButton.getScene().getWindow();
        window.setScene(new Scene(root,700,400));
    }

}

package com.vodvlad.testjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerSignUp {

    @FXML
    private Button SignUpBack;

    @FXML
    private Button SignUpCreateAccount;

    @FXML
    private TextField SignUpEmail;

    @FXML
    private CheckBox SignUpGanderFemale;

    @FXML
    private CheckBox SignUpGenderMale;

    @FXML
    private TextField SignUpLastName;

    @FXML
    private TextField SignUpName;

    @FXML
    private TextField SignUpPassword;

    @FXML
    private TextField SignUpPassword2;

    @FXML
    private TextField SignUpPhoneNumber;

    @FXML
    private TextField SignUpUsername;

    @FXML
    void initialize(){


    }
    public void handleBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage window = (Stage) SignUpBack.getScene().getWindow();
        window.setScene(new Scene(root,700,400));
    }
    public void handleBtn1() throws Exception{
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.signUpUser(SignUpName.getText(), SignUpLastName.getText(), SignUpUsername.getText(), SignUpPassword.getText(),
                SignUpEmail.getText(), SignUpPhoneNumber.getText(), "Male");

    }
}




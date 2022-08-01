package com.vodvlad.testjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    private PasswordField SignUpPassword;

    @FXML
    private PasswordField SignUpPassword2;

    @FXML
    private TextField SignUpPhoneNumber;

    @FXML
    private Text error_text;

    @FXML
    private TextField SignUpUsername;


    public void handleBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage window = (Stage) SignUpBack.getScene().getWindow();
        window.setScene(new Scene(root,700,400));
    }
    public void handleBtn1() throws Exception{
        if(signUpNewUser().equals(true)){
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage window = (Stage) SignUpCreateAccount.getScene().getWindow();
            window.setScene(new Scene(root,700,400));
        } else {
            if(error_text.getText().equals("")){
                error_text.setText("Error");
            }
            System.out.println("loh");
        }

    }

    private Boolean signUpNewUser() {
        if(!SignUpName.getText().equals("") && !SignUpLastName.getText().equals("") && !SignUpUsername.getText().equals("") && !SignUpEmail.getText().equals("") && !SignUpPhoneNumber.getText().equals("")){
            DatabaseHandler dbHandler = new DatabaseHandler();
            String firstname = SignUpName.getText();
            String lastname = SignUpLastName.getText();
            String username = SignUpUsername.getText();
            String email = SignUpEmail.getText();
            String phonenumber = SignUpPhoneNumber.getText();
            String gender = "";
            if(SignUpPassword.getText().equals(SignUpPassword2.getText()) && SignUpPassword.getText().length() >= 8){

                String password = SignUpPassword.getText();

                if(SignUpGenderMale.isSelected()){
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                User user = new User(firstname, lastname, username, password, email, phonenumber, gender);
                dbHandler.signUpUser(user);

                return true;

            } else {
                error_text.setText("Password do not match.");
                SignUpPassword.setStyle("-fx-border-color: #FF0000");
                SignUpPassword2.setStyle("-fx-border-color: #FF0000");
                return false;
            }

        } else{
                error_text.setText("Empty input field.");
                SignUpPassword.setStyle("");
                SignUpPassword2.setStyle("");
                return false;
        }




    }
}




package com.vodvlad.testjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerAuth {

    @FXML
    private Button authSignInButton;

    @FXML
    private Text error_log;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;



    public void handleBtn1() throws Exception{
        String loginLogin = login_field.getText().trim();
        String loginPassword = password_field.getText().trim();
        if(!loginLogin.equals("")){
            if(!loginPassword.equals("")){
                loginUser(loginLogin, loginPassword);
            } else {
                System.out.println("ERROR!");
                password_field.setStyle("-fx-border-color: #FF0000");
                error_log.setText("Empty login or password!");
            }

        } else {
            System.out.println("ERROR!");
            login_field.setStyle("-fx-border-color: #FF0000");
            password_field.setStyle("-fx-border-color: #FF0000");
            error_log.setText("Empty login or password!");
        }
    }

    private void loginUser(String loginLogin, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginLogin);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try{
            while(result.next()){
                counter++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(counter >= 1){
            System.out.println("Success!");
        } else {
            System.out.println("Bad login or pass");
            login_field.setStyle("-fx-border-color: #FF0000");
            password_field.setStyle("-fx-border-color: #FF0000");
            error_log.setText("Wrong login or password!");
        }
    }

    public void handleBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage window = (Stage) loginSignUpButton.getScene().getWindow();
        window.setScene(new Scene(root,700,400));
    }

}

package com.example.controllers;

import java.io.IOException;
import java.util.EventObject;
import java.util.Vector;

import com.example.classes.Pharmacie;
import com.example.database.PharmacieDao;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class controllerSignIn {
    private Vector<Pharmacie> dataLogin;

    // @FXML
    // void btnSignInClicked(ActionEvent event) throws IOException {
    // // Recevoir les donnee de l'utilisateur.
    // String email = login.getText();
    // String password = password.getText();

    // // Verifier l'existance des Informations.
    // if (search(eml,pas)) {
    // Node node = (Node) event.getSource();
    // stageVerification = (Stage) node.getScene().getWindow();

    // root =
    // FXMLLoader.load(getClass().getResource("/com/example/view/scene2.fxml"));
    // scene2 = new Scene(root);
    // stageVerification.setScene(scene2);
    // stageVerification.show();
    // } else {
    // // Animation de Button de sing In.
    // TranslateTransition translate = new
    // TranslateTransition(Duration.seconds(0.12), btnSingIn);
    // translate.setByX(30);
    // TranslateTransition translate2 = new
    // TranslateTransition(Duration.seconds(0.12), btnSingIn);
    // translate2.setByX(-60);
    // TranslateTransition translate3 = new
    // TranslateTransition(Duration.seconds(0.12), btnSingIn);
    // translate3.setByX(30);

    // translate.setOnFinished(finishedEvent -> {
    // translate2.play();
    // });

    // translate.play();

    // translate2.setOnFinished(finishedEvent -> {
    // translate3.play();
    // });
    // // set component Faild visible
    // paneFaild.setVisible(true);
    // messageFaild.setVisible(true);
    // iconFaild.setVisible(true);
    // }
    // }

    @FXML
    private Button btnSignIn;

    @FXML
    private TextField emailField;

    @FXML
    private ImageView iconFaild;

    @FXML
    private Text messageFaild;

    @FXML
    private Button buttonBack;

    @FXML
    private AnchorPane paneFaild;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private RadioButton radioPassword;

    public void initialize() {
        // Load Data from PharmacieDao;
        PharmacieDao pharmacieDao = new PharmacieDao();
        dataLogin = pharmacieDao.getdataLogin();
        // set component Faild Invisible
        paneFaild.setVisible(false);
        messageFaild.setVisible(false);
        iconFaild.setVisible(false);
        passwordTextField.setVisible(false);

        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), btnSignIn);
        transition.setByX(-230);
        transition.play();
    }

    @FXML
    void showPassword(ActionEvent event) {
        String password;
        if (passwordField.isVisible()) {
            password = passwordField.getText();
        } else {
            password = passwordTextField.getText();
        }
        if (radioPassword.isSelected()) {
            passwordField.setVisible(false);
            passwordTextField.setVisible(true);
            passwordTextField.setText(password);
        } else {
            passwordField.setVisible(true);
            passwordTextField.setVisible(false);
            passwordField.setText(password);
        }
    }

    // Chercher si les donnee de l'utilisateur dans la base de donnee.
    public boolean searchDonnee(String email, String password) {
        for (int i = 0; i < dataLogin.size(); i++) {
            if (dataLogin.get(i).getLogin().equals(email) &&
                    dataLogin.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    void signIn(ActionEvent event) throws IOException {
        // Recevoir les donnee de l'utilisateur.
        String email = emailField.getText();
        String password = passwordField.getText();
        ;
        if (passwordField.isVisible()) {
            password = passwordField.getText();
        } else {
            password = passwordTextField.getText();
        }

        // Verifier l'existance des Informations.
        if (searchDonnee(email, password)) {
            Parent root = new FXMLLoader().load(getClass().getResource("/com/example/view/home.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();
        } else {
        }
        // Animation de Button de sing In.
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.12), btnSignIn);
        translate.setByX(30);
        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(0.12), btnSignIn);
        translate2.setByX(-60);
        TranslateTransition translate3 = new TranslateTransition(Duration.seconds(0.12), btnSignIn);
        translate3.setByX(30);

        translate.play();
        translate.setOnFinished(finishedEvent -> {
            translate2.play();
        });
        translate2.setOnFinished(finishedEvent -> {
            translate3.play();
        });

        // set component Faild visible
        paneFaild.setVisible(true);
        messageFaild.setVisible(true);
        iconFaild.setVisible(true);
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = new FXMLLoader().load(getClass().getResource("/com/example/view/startPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

}
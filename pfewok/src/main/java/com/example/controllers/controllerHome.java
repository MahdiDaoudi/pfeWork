package com.example.controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class controllerHome {

    @FXML
    private Button logbtn;

    @FXML
    private Label dateLabel;

    @FXML
    private AnchorPane homePage;

    @FXML
    private AnchorPane salePage;

    @FXML
    private AnchorPane medicinePage;

    @FXML
    private AnchorPane settingsPage;

    @FXML
    private Label titlePage;

    @FXML
    private ImageView iconPage;

    @FXML
    private Button homeButton;

    @FXML
    private Button saleButton;

    @FXML
    private Button medicineButton;

    @FXML
    private Button settingsButton;

    @FXML
    public void initialize() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> updateDateTime()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        homePage.setVisible(true);
        homeButton.setStyle("-fx-background-color: #123321");
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Alert verification = new Alert(AlertType.CONFIRMATION);
        verification.setContentText("Are you sur?");
        verification.showAndWait();
        Parent root = new FXMLLoader().load(getClass().getResource("/com/example/view/signIn.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void updateDateTime() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy HH:mm:ss");
        dateLabel.setText(date.format(formatter));
    }

    @FXML
    public void toHome(ActionEvent event) {
        salePage.setVisible(false);
        medicinePage.setVisible(false);
        settingsPage.setVisible(false);
        homePage.setVisible(true);
        titlePage.setText("Home");
        Image image = new Image(getClass().getResourceAsStream("/com/example/icons/home.png"));
        iconPage.setImage(image);
        // Style
        homeButton.setStyle("-fx-background-color: #123321; -fx-padding: 0 0 0 25;");
        saleButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
        medicineButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
        settingsButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
    }

    @FXML
    public void toSale(ActionEvent event) {
        homePage.setVisible(false);
        medicinePage.setVisible(false);
        settingsPage.setVisible(false);
        salePage.setVisible(true);
        titlePage.setText("Sale");
        Image image = new Image(getClass().getResourceAsStream("/com/example/icons/sale.png"));
        iconPage.setImage(image);
        // Style
        homeButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
        saleButton.setStyle("-fx-background-color: #123321; -fx-padding: 0 0 0 25;");
        medicineButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
        settingsButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
    }

    @FXML
    public void toMedicine() {
        homePage.setVisible(false);
        salePage.setVisible(false);
        settingsPage.setVisible(false);
        medicinePage.setVisible(true);
        titlePage.setText("Medicine");
        Image image = new Image(getClass().getResourceAsStream("/com/example/icons/medicine.png"));
        iconPage.setImage(image);
        // Style
        homeButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
        saleButton.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        medicineButton.setStyle("-fx-background-color: #123321; -fx-padding: 0 0 0 25;");
        settingsButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
    }

    @FXML
    public void toSettings() {
        homePage.setVisible(false);
        salePage.setVisible(false);
        medicinePage.setVisible(false);
        settingsPage.setVisible(true);
        titlePage.setText("Settings");
        Image image = new Image(getClass().getResourceAsStream("/com/example/icons/settings.png"));
        iconPage.setImage(image);
        // Style
        homeButton.setStyle("-fx-background-color: taransparent; -fx-padding: 0;");
        saleButton.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        medicineButton.setStyle("-fx-background-color: taransparent -fx-padding: 0;");
        settingsButton.setStyle("-fx-background-color: #123321 -fx-padding: 0 0 0 25;");
    }

}

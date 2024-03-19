package com.example.controllers;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;

public class controllerStartPage {

    @FXML
    private Button btnStart;

    @FXML
    private ImageView view;

    TranslateTransition transition1;
    TranslateTransition transition2;
    public void initialize() {
        transition1 = new TranslateTransition(Duration.seconds(2), view);
        transition1.setByY(-20);
        transition2 = new TranslateTransition(Duration.seconds(2), view);
        transition2.setByY(20);

        transition1.play();
        transition1.setOnFinished(e1 -> {
            transition2.playFromStart();
        });
        transition2.setOnFinished(e2 -> {
            transition1.playFromStart();
        });

    }

    @FXML
    void letsStart(MouseEvent event) throws IOException {
        transition1.stop();
        transition2.stop();
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), btnStart);
        transition.setByX(-400);
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/view/signIn.fxml"));
        transition.play();
        transition.setOnFinished(e1 -> {
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
        });
    }

}

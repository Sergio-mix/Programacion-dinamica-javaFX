package co.edu.unbosque.programacindinmicajava.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, DraggedScene {

    @FXML
    private HBox barmenu;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(barmenu);
    }

    @FXML
    public void floydRood(ActionEvent event) throws IOException {
        Main.setRoot(Main.packageS("floyd"));
    }

    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }
}
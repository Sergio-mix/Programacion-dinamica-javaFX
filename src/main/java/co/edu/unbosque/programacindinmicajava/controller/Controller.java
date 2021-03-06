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
        Main.setRoot("floyd");
    }

    @FXML
    public void viajero(ActionEvent event) throws IOException {
        Main.setRoot("viajero");
    }
    @FXML
    public void asignacionRood(ActionEvent actionEvent) throws IOException {
        Main.setRoot("asignacionTareas");
    }

    @FXML
    public void binomiales(ActionEvent actionEvent) throws IOException {
        Main.setRoot("binomiales");
    }

    @FXML
    public void matrices(ActionEvent actionEvent) throws IOException {
        Main.setRoot("matrices");
    }

    @FXML
    public void exit(ActionEvent event) {
        Main.exit();
    }

}
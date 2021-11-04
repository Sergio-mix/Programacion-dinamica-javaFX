package co.edu.unbosque.programacindinmicajava.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller {

    @FXML
    public void floydRood(ActionEvent event) throws IOException {
        Main.setRoot("/co/edu/unbosque/programacindinmicajava/floyd");
    }
}
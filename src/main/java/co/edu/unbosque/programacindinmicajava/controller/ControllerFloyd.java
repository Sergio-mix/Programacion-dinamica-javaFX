package co.edu.unbosque.programacindinmicajava.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFloyd implements Initializable, DraggedScene {
    @FXML
    private Pane barmenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(barmenu);
    }

    @FXML
    public void exit(ActionEvent event) {
        Main.exit();
    }
}

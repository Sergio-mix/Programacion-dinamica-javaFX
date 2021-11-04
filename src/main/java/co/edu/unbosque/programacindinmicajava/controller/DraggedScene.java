package co.edu.unbosque.programacindinmicajava.controller;

import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public interface DraggedScene {
    default void onDraggedScene(Node panelFather) {
        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);

        panelFather.setOnMousePressed(e -> {
            Stage stage = (Stage) panelFather.getScene().getWindow();
            xOffset.set(stage.getX() - e.getScreenX());
            yOffset.set(stage.getY() - e.getScreenY());

        });

        panelFather.setOnMouseDragged(e -> {
            Stage stage = (Stage) panelFather.getScene().getWindow();
            stage.setX(e.getScreenX() + xOffset.get());
            stage.setY(e.getScreenY() + yOffset.get());
            panelFather.setStyle("-fx-cursor: CLOSED_HAND;");
        });

        panelFather.setOnMouseReleased(e -> panelFather.setStyle("-fx-cursor: DEFAULT;"));
    }
}

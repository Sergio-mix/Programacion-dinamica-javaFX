package co.edu.unbosque.programacindinmicajava.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Methods {
    public Methods() {

    }

    public static EventHandler<KeyEvent> handlerNumbers = new EventHandler<KeyEvent>() {
        private boolean willConsume = false;

        @Override
        public void handle(KeyEvent event) {
            if (willConsume) {
                event.consume();
            }
            if (!event.getText().matches("[0-9]") && event.getCode() != KeyCode.BACK_SPACE) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    willConsume = true;
                } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                    willConsume = false;
                }
            }
        }
    };

    /**
     * Alerta de error
     *
     * @param text texto de la alerta
     */
    @FXML
    public static void mostrarAlertError(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(text);
        alert.showAndWait();
    }

    /**
     * Alert de info
     *
     * @param text de la alerta
     */
    @FXML
    public static void mostrarAlertInfo(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText(text);
        alert.showAndWait();
    }

    /**
     * Alert de advertencia
     *
     * @param text texto de la alerta
     */
    @FXML
    public static void mostrarAlertWarning(String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Advertencia");
        alert.setContentText(text);
        alert.showAndWait();
    }
}

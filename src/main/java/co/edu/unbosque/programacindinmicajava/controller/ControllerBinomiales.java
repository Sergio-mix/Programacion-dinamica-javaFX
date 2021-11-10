package co.edu.unbosque.programacindinmicajava.controller;

import co.edu.unbosque.programacindinmicajava.components.ObjectView;
import co.edu.unbosque.programacindinmicajava.model.AlgoritmoFloyd;
import co.edu.unbosque.programacindinmicajava.model.Binomial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;


public class ControllerBinomiales implements Initializable, DraggedScene {
    @FXML
    private Pane barmenu;

    @FXML
    private VBox container;

    @FXML
    private TextField txtTamanio;

    @FXML
    private TextField txtTamanio1;
    private int[][] array;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(barmenu);
        txtTamanio.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtTamanio1.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
    }

    @FXML
    public void exit(ActionEvent event) {
        Main.exit();
    }

    @FXML
    public void home() throws IOException {
        Main.setRoot("view");
    }

    @FXML
    private void binomial() {
        try {
            int n = Integer.parseInt(txtTamanio.getText());
            int m = Integer.parseInt(txtTamanio1.getText());

            GridPane gridPane = ObjectView.gridPane();

            if (n >= m) {
                Map<String, Object> map = Binomial.getBinomialCoefficient(n, m);
                array = (int[][]) map.get("matriz");

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        Text text = null;
                        if (array[i][j] == 0) {
                            text = ObjectView.text("", 13);
                        } else {
                            text = ObjectView.text(array[i][j], 13);
                        }

                        gridPane.add(text, j, i);
                    }
                }

                HBox hBox = ObjectView.hBox_v1();
                hBox.getChildren().add(gridPane);
                hBox.getChildren().add(
                        ObjectView.text(
                                "El coeficiente binomial de " + n + " y " + m + " es: "
                                        + map.get("coeficienteBinomial"), 18));

                add(hBox);
            } else {
                Methods.mostrarAlertWarning("Ingrese correctamente los datos");
            }
            txtTamanio1.setText("");
            txtTamanio.setText("");
        } catch (Exception ex) {
            txtTamanio1.setText("");
            txtTamanio.setText("");
            Methods.mostrarAlertError("Error");
        }
    }


    private void add(Object object) {
        container.getChildren().add((Node) object);
    }

}

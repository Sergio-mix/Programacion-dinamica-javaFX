package co.edu.unbosque.programacindinmicajava.controller;

import co.edu.unbosque.programacindinmicajava.components.ObjectView;
import co.edu.unbosque.programacindinmicajava.model.AlgoritmoFloyd;
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
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFloyd implements Initializable, DraggedScene {
    @FXML
    private Pane barmenu;

    @FXML
    private VBox container;

    @FXML
    private HBox panelABC;

    @FXML
    private Button buttonInt;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtC;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtTamanio;

    @FXML
    private Text textAUX;

    private int[][] array;

    private int aux = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(barmenu);
        txtA.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtB.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtC.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtNumero.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtTamanio.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
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
    private void panelDisable() {
        if (!txtTamanio.getText().equals("")
                && !txtNumero.getText().equals("")) {

            array = floyd();

            if (array != null) {
                panelABC.setDisable(false);
                txtTamanio.setDisable(true);
                txtNumero.setDisable(true);
                buttonInt.setDisable(true);
            } else {
                Methods.mostrarAlertError("Error en el proceso");
            }
        } else {
            panelABC.setDisable(true);
            buttonInt.setDisable(false);
        }
    }

    public void addArray() {
        try {
            int n = Integer.parseInt(txtTamanio.getText());
            int m = Integer.parseInt(txtNumero.getText());
            if (aux <= m) {
                int a = Integer.parseInt(txtA.getText());
                int b = Integer.parseInt(txtB.getText());
                int c = Integer.parseInt(txtC.getText());
                if (a <= n && b <= n) {
                    array[a][b] = c;
                    textAUX.setText(aux + " de " + m);
                    aux++;
                    txtA.setText("");
                    txtB.setText("");
                    txtC.setText("");

                    array = AlgoritmoFloyd.floyd(n, array);

                    if (array == null) {
                        aux = 1;
                        Methods.mostrarAlertError("Error en el proceso");
                        return;
                    }

                    GridPane gridPane = ObjectView.gridPane();

                    for (int i = 1; i <= Integer.parseInt(txtTamanio.getText()); i++) {
                        for (int j = 1; j <= Integer.parseInt(txtTamanio.getText()); j++) {
                            Text text = null;
                            if (array[i][j] == 99999999) {
                                text = ObjectView.text("∞", 13);
                            } else {
                                text = ObjectView.text(array[i][j], 13);
                            }

                            char chaR1 = (char) ('A' + (i - 1));
                            Text letra1 = ObjectView.text("#2073f7", chaR1, 14);
                            gridPane.add(letra1, 0, i);

                            char chaR2 = (char) ('A' + (j - 1));
                            Text letra2 = ObjectView.text("#2073f7", chaR2, 14);
                            gridPane.add(letra2, j, 0);

                            gridPane.add(text, j, i);
                        }
                    }

                    HBox hBox = ObjectView.hBox_v1();
                    hBox.getChildren().add(ObjectView.text("D(" + (aux - 2) + ") =", 18));
                    hBox.getChildren().add(gridPane);
                    add(hBox);

                    if (aux + 1 > m + 1) {
                        panelABC.setDisable(true);
                        textAUX.setText("");

                        txtTamanio.setDisable(false);
                        txtNumero.setDisable(false);
                        txtTamanio.setText("");
                        txtNumero.setText("");
                        buttonInt.setDisable(false);
                    }
                } else {
                    Methods.mostrarAlertWarning("Los valores no concuerda con el tamaño array");
                }
            }
        } catch (Exception ex) {
            container.getChildren().clear();
            panelABC.setDisable(true);
            txtTamanio.setDisable(false);
            txtNumero.setDisable(false);
            txtTamanio.setText("");
            txtNumero.setText("");
            buttonInt.setDisable(false);
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            aux = 1;
            Methods.mostrarAlertError("Error en el proceso");
        }
    }

    @FXML
    private int[][] floyd() {
        try {
            container.getChildren().clear();
            aux = 1;
            int n = Integer.parseInt(txtTamanio.getText());
            int m = Integer.parseInt(txtNumero.getText());
            int[][] e = new int[n * n][n * n];

            return AlgoritmoFloyd.initial(m, n, e);
        } catch (Exception ex) {
            return null;
        }
    }

    private void add(Object Object) {
        container.getChildren().add((Node) Object);
    }
}

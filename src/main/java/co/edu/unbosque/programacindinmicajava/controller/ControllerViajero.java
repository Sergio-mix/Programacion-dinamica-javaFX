package co.edu.unbosque.programacindinmicajava.controller;

import co.edu.unbosque.programacindinmicajava.components.ObjectView;
import co.edu.unbosque.programacindinmicajava.model.Viajero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControllerViajero implements Initializable, DraggedScene {

    @FXML
    private Pane barmenu;


    @FXML
    private Button buttonInt;

    @FXML
    private VBox container;

    @FXML
    private HBox panelABC;

    @FXML
    private Text textAUX;

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

    private int aux = 1;

    private double[][] array;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(barmenu);
    }

    @FXML
    public void home() throws IOException {
        Main.setRoot("view");
    }

    @FXML
    public void exit(ActionEvent event) {
        Main.exit();
    }

    @FXML
    private void panelDisable() {
        if (!txtTamanio.getText().equals("")
                && !txtNumero.getText().equals("")) {

            array = viajero();

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

                    array = Viajero.initialize(array);

                    if (array == null) {
                        aux = 1;
                        textAUX.setText("");
                        Methods.mostrarAlertError("Error en el proceso");
                        return;
                    }

                    String[][] arrayAux = new String[n + 1][n + 1];

                    try {
                        for (int i = 0; i < array.length; i++) {
                            for (int j = 0; j < array.length; j++) {
                                if (j == 0) {
                                    arrayAux[i][j] = "";
                                }
                                if (i == 0) {
                                    arrayAux[i][j] = "";
                                }
                                arrayAux[i + 1][j + 1] = "" + (array[i][j]);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    GridPane gridPane = ObjectView.gridPane();

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            Text text = null;
                            if (arrayAux[i][j].equals("10000.0")) {
                                text = ObjectView.text("∞", 13);
                            } else {
                                text = ObjectView.text(arrayAux[i][j], 13);
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
                    hBox.getChildren().add(ObjectView.text("#3bd464", "Valor costo:" + Viajero.getTourCost(), 16));
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
            textAUX.setText("");
            System.out.println(ex.getMessage());
            Methods.mostrarAlertError("Error en el proceso");
        }
    }


    private double[][] viajero() {
        container.getChildren().clear();
        aux = 1;
        try {
            int n = Integer.parseInt(txtTamanio.getText());

            double[][] distanceMatrix = new double[n][n];
            for (double[] row : distanceMatrix) java.util.Arrays.fill(row, 10000);
            return distanceMatrix;
        } catch (Exception ex) {
            return null;
        }
    }

    private void add(Object object) {
        container.getChildren().add((Node) object);
    }
}

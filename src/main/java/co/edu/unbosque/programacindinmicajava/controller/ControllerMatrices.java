package co.edu.unbosque.programacindinmicajava.controller;

import co.edu.unbosque.programacindinmicajava.components.ObjectView;
import co.edu.unbosque.programacindinmicajava.model.Matriz;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMatrices implements Initializable, DraggedScene {

    @FXML
    private Pane barmenu;

    @FXML
    private VBox container;

    @FXML
    private TextField txtColumna1;

    @FXML
    private TextField txtColumna2;

    @FXML
    private TextField txtFila1;

    @FXML
    private TextField txtFila2;

    private boolean aux = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(barmenu);
        txtColumna1.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtColumna2.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtFila1.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtFila2.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
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
    public void addArray() {
        try {
            container.getChildren().clear();
            aux = false;

            int f1 = Integer.parseInt(txtFila1.getText());
            int c1 = Integer.parseInt(txtColumna1.getText());

            int f2 = Integer.parseInt(txtFila2.getText());
            int c2 = Integer.parseInt(txtColumna2.getText());

            if (c1 == f1) {
                txtColumna1.setText("");
                txtColumna2.setText("");
                txtFila1.setText("");
                txtFila2.setText("");

                TextField[][] list1 = new TextField[f1][c1];
                TextField[][] list2 = new TextField[f2][c2];

                for (int i = 0; i < f1; i++) {
                    for (int j = 0; j < c1; j++) {
                        TextField file = ObjectView.textField_v1();
                        list1[i][j] = file;
                    }
                }

                for (int i = 0; i < f2; i++) {
                    for (int j = 0; j < c2; j++) {
                        TextField file = ObjectView.textField_v1();
                        list2[i][j] = file;
                    }
                }

                GridPane gridPane1 = ObjectView.gridPane_3();
                for (int i = 0; i < f1; i++) {
                    for (int j = 0; j < c1; j++) {
                        gridPane1.add(list1[i][j], j, i);
                    }
                }

                GridPane gridPane2 = ObjectView.gridPane_3();
                for (int i = 0; i < f2; i++) {
                    for (int j = 0; j < c2; j++) {
                        gridPane2.add(list2[i][j], j, i);
                    }
                }

                HBox hBox = ObjectView.hBox_v1();
                hBox.getChildren().add(gridPane1);
                Button button = ObjectView.button_v1("X", "#03a1fc", 20);
                button.setOnAction(
                        event -> matriz(list1, list2, f1, c1, f2, c2)
                );
                hBox.getChildren().add(button);
                hBox.getChildren().add(gridPane2);

                add(hBox);
            } else {
                Methods.mostrarAlertWarning("Verifique los datos ingresados");
            }
        } catch (Exception e) {
            Methods.mostrarAlertError(e.getMessage());
        }
    }

    @FXML
    private void matriz(TextField[][] list1, TextField[][] list2, int f1, int c1, int f2, int c2) {
        try {
            if (!aux) {
                int[][] matriz1 = new int[f1][c1];
                int[][] matriz2 = new int[f2][c2];

                for (int i = 0; i < f1; i++) {
                    for (int j = 0; j < c1; j++) {
                        matriz1[i][j] = Integer.parseInt(list1[i][j].getText());
                    }
                }

                for (int i = 0; i < f2; i++) {
                    for (int j = 0; j < c2; j++) {
                        matriz2[i][j] = Integer.parseInt(list2[i][j].getText());
                    }
                }

                int[][] matriz = Matriz.matrix_multiply(matriz1, matriz2, f1, c2, c1);
                if (matriz != null) {
                    GridPane gridPane = ObjectView.gridPane_v2();

                    for (int i = 0; i < f1; i++) {
                        for (int j = 0; j < c2; j++) {
                            gridPane.add(ObjectView.text(matriz[i][j], 20), j, i);
                        }
                    }

                    HBox hBox = ObjectView.hBox_v1();
                    hBox.getChildren().add(gridPane);

                    add(hBox);
                    aux = true;
                } else {
                    Methods.mostrarAlertError("Error en el proceso");
                }
            }
        } catch (Exception e) {
            Methods.mostrarAlertError(e.getMessage());
        }
    }

    @FXML
    private void add(Object Object) {
        container.getChildren().add((Node) Object);
    }
}

package co.edu.unbosque.programacindinmicajava.controller;

import co.edu.unbosque.programacindinmicajava.components.ObjectView;
import co.edu.unbosque.programacindinmicajava.model.AsignacionT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControllerAsignacionT implements Initializable, DraggedScene {
    @FXML
    private Pane barmenu;

    @FXML
    private VBox container;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtTamanio;

    private int[] array;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(barmenu);
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
    private void execution() {
        try {
            int m = Integer.parseInt(txtNumero.getText());
            if (!txtTamanio.getText().equals("")
                    && !txtNumero.getText().equals("")) {
                array = AsignacionT();
                System.out.println(Arrays.toString(array));

                GridPane gridPane = ObjectView.gridPane_v2();
                Text text1 = ObjectView.text("Tarea", 24);
                gridPane.add(text1, 0, 0);

                Text text2 = ObjectView.text("Agente", 24);
                gridPane.add(text2, 1, 0);

                for (int i = 0; i < m; i++) {
                    Text textOb1 = ObjectView.text((i + 1), 18);
                    gridPane.add(textOb1, 0, i + 1);

                    Text textOb2 = ObjectView.text(array[i], 18);
                    gridPane.add(textOb2, 1, i + 1);
                }

                HBox hBox = ObjectView.hBox_v1();
                hBox.getChildren().add(gridPane);

                VBox vBox = ObjectView.vbox_v1();
                Text agentes = ObjectView.text(
                        "#3a81f2", "Cantidad agentes: "
                                + txtTamanio.getText(), 18);
                vBox.getChildren().add(agentes);

                Text tareas = ObjectView.text(
                        "#3fd16d", "Cantidad tareas: "
                                + txtNumero.getText(), 18);

                vBox.getChildren().add(tareas);
                hBox.getChildren().add(vBox);

                add(hBox);
            } else {
                Methods.mostrarAlertWarning("Los valores no son validos");
            }
        } catch (Exception e) {
            Methods.mostrarAlertWarning("Los valores no son validos");
        }

    }


    @FXML
    private int[] AsignacionT() {
        try {
            int n = Integer.parseInt(txtTamanio.getText());
            int m = Integer.parseInt(txtNumero.getText());
            int a = Math.max(n, m);

            return AsignacionT.asignacionTareas(n, m, a);
        } catch (Exception ex) {
            return null;
        }
    }

    private void add(Object Object) {
        container.getChildren().add((Node) Object);
    }
}

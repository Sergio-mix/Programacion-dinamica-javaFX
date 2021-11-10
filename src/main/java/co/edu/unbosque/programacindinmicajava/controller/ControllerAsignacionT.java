package co.edu.unbosque.programacindinmicajava.controller;

import co.edu.unbosque.programacindinmicajava.components.ObjectView;
import co.edu.unbosque.programacindinmicajava.model.AlgoritmoFloyd;
import co.edu.unbosque.programacindinmicajava.model.AsignacionT;
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
import java.util.Arrays;
import java.util.ResourceBundle;
public class ControllerAsignacionT implements Initializable, DraggedScene {
    @FXML
    private Pane barmenu;

    @FXML
    private VBox container;

    @FXML
    private HBox panelABC;

    @FXML
    private Button buttonInt;

    @FXML
    private Button buttonAleatory;

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

    private int[] array;

    private int aux = 1;

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
            int n = Integer.parseInt(txtTamanio.getText());
            int m = Integer.parseInt(txtNumero.getText());
            if (!txtTamanio.getText().equals("")
                    && !txtNumero.getText().equals("")) {
                array=AsignacionT();
                System.out.println(Arrays.toString(array));
                GridPane gridPane = ObjectView.gridPane();

                for(int i = 0; i< m;i++){
                    HBox hBox = ObjectView.hBox_v1();
                    hBox.getChildren().add(ObjectView.text("Tarea "+(i+1)+" Realizada por agente: "+array[i], 18));
                    add(hBox);
                }





            } else {
                Methods.mostrarAlertWarning("Los valores no son validos");
            }
        }catch (Exception e){
            Methods.mostrarAlertWarning("Los valores no son validos");
        }

    }



    @FXML
    private int[] AsignacionT() {
        try {
            container.getChildren().clear();
            aux = 1;
            int n = Integer.parseInt(txtTamanio.getText());
            int m = Integer.parseInt(txtNumero.getText());
            int a = 0;
            if(n<m)
                a=m;
            else
                a=n;

            int[][] e = new int[n * n][n * n];

            return AsignacionT.asignacionTareas(n, m, a );
        } catch (Exception ex) {
            return null;
        }
    }

    private void add(Object Object) {
        container.getChildren().add((Node) Object);
    }
}

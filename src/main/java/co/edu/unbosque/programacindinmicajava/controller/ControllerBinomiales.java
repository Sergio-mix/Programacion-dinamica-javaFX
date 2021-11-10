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
import java.util.ResourceBundle;


public class ControllerBinomiales implements Initializable, DraggedScene {
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
    private TextField txtTamanio;

    @FXML
    private TextField txtTamanio1;
    private int [][] array;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.onDraggedScene(barmenu);
        txtTamanio.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
        txtTamanio1.addEventFilter(KeyEvent.ANY, Methods.handlerNumbers);
    }

    private int aux = 1;

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

        binomial();
        //panelABC.setDisable(false);
        txtTamanio.setDisable(false);
        txtTamanio1.setDisable(false);
        //panelABC.setDisable(true);
        buttonInt.setDisable(false);
        txtTamanio.setText("");
        txtTamanio1.setText("");


    }

    @FXML
    private int binomial() {
        try {
            container.getChildren().clear();
            int n = Integer.parseInt(txtTamanio.getText());
            int m = Integer.parseInt(txtTamanio1.getText());


            GridPane gridPane = ObjectView.gridPane();

            if (n >= m) {
                array= Binomial.getBinomialCoefficient(n,m);
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        Text text = null;
                        if (array[i][j] == 0) {
                            text = ObjectView.text("", 13);
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
                hBox.getChildren().add(gridPane);
                hBox.getChildren().add(ObjectView.text("El coeficiente binomial de "+n +" y " +m+" es: " + Main.coeficienteBinomial, 18));
                add(hBox);
            }
            else {
                Methods.mostrarAlertError("Ingrese correctamente los datos");
                txtTamanio1.setText("");
                txtTamanio.setText("");
            }


        } catch (Exception ex) {
            return 0;
        }
        return 0;
    }


    private void add(Object object) {
        container.getChildren().add((Node) object);
    }

}

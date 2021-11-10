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


//            GridPane gridPane = ObjectView.gridPane();
//            HBox hBox = ObjectView.hBox_v1();
//            hBox.getChildren().add(ObjectView.text("D(" + (aux - 2) + ") =", 18));
//            hBox.getChildren().add(gridPane);
//            VBox vBox = ObjectView.vbox_v1();
//            vBox.getChildren().add(ObjectView.text("#3bd464", Integer.parseInt("El coeficiente Binomial es: " + String.valueOf(Binomial.imprimirSolucion(n, m)))));
//            hBox.getChildren().add(vBox);
//            add(hBox);

            if (n >= m) {
                return Binomial.imprimirSolucion(n, m);



            } else {
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

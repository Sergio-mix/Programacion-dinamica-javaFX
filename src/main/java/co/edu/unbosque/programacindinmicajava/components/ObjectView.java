package co.edu.unbosque.programacindinmicajava.components;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ObjectView {

    public ObjectView() {

    }

    /**
     * Objeto Text
     *
     * @param t Objeto agregado
     * @return Objeto Text con y agregado
     */
    @FXML
    public static Text text(Object t, int size) {
        Text text = new Text();
        text.setText(String.valueOf(t));//add
        text.setEffect(new Glow(0.3));
        text.setFill(Color.web("#FFFFFF"));//Color
        text.setStyle(
                " -fx-font-size: " + size + "px;" + //Tamanio letra
                        "-fx-font-family: Arial;" //Forma
        );

        return text;
    }

    /**
     * Objeto Text
     *
     * @param color color del texto
     * @param t     Objeto agregado
     * @param size  tamanio letra
     * @return Objeto Text con y agregado
     */
    @FXML
    public static Text text(String color, Object t, int size) {
        Text text = new Text();
        text.setText(String.valueOf(t));//add
        text.setEffect(new Glow(0.3));
        text.setFill(Color.web(color));//color
        text.setStyle(
                " -fx-font-size: " + size + ";" +//Tamanio letra
                        "-fx-font-family: Arial;"//Forma
        );

        return text;
    }

    /**
     * Objeto GridPane
     *
     * @return Objeto GridPane
     */
    public static GridPane gridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);//Centrar
        gridPane.setHgap(5);//Espacio vertical
        gridPane.setVgap(5);//Espacio Horizontal
        gridPane.setPadding(new Insets(0, 20, 0, 20));//Distancia componente interno
        gridPane.setStyle(
                "-fx-border-color: #FFFFFF;" +//Color de fondo
                        "-fx-stroke-dash-offset: 2;" +//Borde
                        "-fx-border-style: solid;" +//Borde
                        " -fx-border-width: 0 4 0 4; ");//Borde

        return gridPane;
    }

    @FXML
    public static GridPane gridPane_v2() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);//Centrar
        gridPane.setVgap(20);//Espacio Horizontal
        gridPane.setHgap(50);//Espacio Horizontal
        gridPane.setPadding(new Insets(10, 50, 10, 50));//Distancia componente interno
        return gridPane;
    }

    public static GridPane gridPane_3() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);//Centrar
        gridPane.setHgap(5);//Espacio vertical
        gridPane.setVgap(5);//Espacio Horizontal
        gridPane.setPadding(new Insets(0, 20, 0, 20));//Distancia componente interno
        return gridPane;
    }

    /**
     * Objeto HBox version 1
     *
     * @return Objeto HBox
     */
    @FXML
    public static HBox hBox_v1() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);//Centrar
        hBox.setSpacing(70);//Espacio
        hBox.setPadding(new Insets(5, 10, 5, 10));//Distancia componente interno
        hBox.setStyle(
                "-fx-background-color:  #212121; " +
                        "-fx-background-radius: 10 10 10 10;" +
                        " -fx-effect: dropshadow(gaussian, #101010, 15, 0.5, 0.5, 0.5);"
        );

        return hBox;
    }


    @FXML
    public static VBox vbox_v1() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);//Centrar
        vbox.setSpacing(15);//Espacio
        return vbox;
    }

    @FXML
    public static TextField textField_v1() {
        TextField textField = new TextField();
        textField.setStyle(
                "-fx-background-color: #202020;"
                        + "-fx-font-size: 18;"
                        + "-fx-text-fill: #FFFFFF;"
                        + " -fx-effect: dropshadow(gaussian, #101010, 15, 0.5, 0.5, 0.5);"
        );

        return textField;
    }

    @FXML
    public static Button button_v1(Object text, String color, int size) {
        Button button = new Button();
        button.setText(String.valueOf(text));
        button.setStyle(
                "-fx-text-fill: #FFFFFF;"
                        + "-fx-background-color:" + color + ";"
                        + "-fx-background-radius:50 50 50 50;"
                        + "-fx-font-size: " + size + ";"
        );

        return button;
    }

}

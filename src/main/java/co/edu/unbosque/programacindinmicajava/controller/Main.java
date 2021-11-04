package co.edu.unbosque.programacindinmicajava.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(packageS("view")));
        scene.setFill(Color.TRANSPARENT);
        stage.getIcons().add(
                new Image(
                        String.valueOf(
                                getClass().getResource(
                                        packageS("icons/a.png"))
                        )
                )
        );
        stage.setTitle("Algoritmos dinamicos");
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(
                fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static String packageS(String text) {
        return "/co/edu/unbosque/programacindinmicajava/" + text;
    }

    public static void main(String[] args) {
        launch();
    }
}
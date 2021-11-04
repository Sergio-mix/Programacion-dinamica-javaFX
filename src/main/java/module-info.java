module co.edu.unbosque.programacindinmicajava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    exports co.edu.unbosque.programacindinmicajava.controller;
    exports co.edu.unbosque.programacindinmicajava.model;
    opens co.edu.unbosque.programacindinmicajava.controller to javafx.fxml;
    opens co.edu.unbosque.programacindinmicajava.model to javafx.fxml;
}
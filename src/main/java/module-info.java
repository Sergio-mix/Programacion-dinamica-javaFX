module co.edu.unbosque.programacindinmicajava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.unbosque.programacindinmicajava to javafx.fxml;
    exports co.edu.unbosque.programacindinmicajava;
}
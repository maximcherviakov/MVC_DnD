module com.example.mvc_dnd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mvc_dnd to javafx.fxml;
    exports com.example.mvc_dnd;
}
module com.example.mvc_dnd {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.mvc_dnd to javafx.fxml;
    exports com.example.mvc_dnd;
    exports com.example.mvc_dnd.Controller;
    opens com.example.mvc_dnd.Controller to javafx.fxml;
}
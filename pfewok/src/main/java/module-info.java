module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens com.example to javafx.fxml;
    exports com.example;
    exports com.example.controllers;
    opens com.example.controllers to javafx.fxml;
}

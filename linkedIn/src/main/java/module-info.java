module com.example.linkedin {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.linkedin to javafx.fxml;
    exports com.example.linkedin;
}
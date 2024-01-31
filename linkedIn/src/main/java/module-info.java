module com.example.linkedin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.linkedin to javafx.fxml;
    exports com.example.linkedin;
}
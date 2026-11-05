module com.example.zoomanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zoomanagementsystem to javafx.fxml;
    exports com.example.zoomanagementsystem;
}
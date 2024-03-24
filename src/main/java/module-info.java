module com.example.csc325_colorchooser {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc325_colorchooser to javafx.fxml;
    exports com.example.csc325_colorchooser;
}
module com.example.labyrinthe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labyrinthe to javafx.fxml;
    exports com.example.labyrinthe;
}
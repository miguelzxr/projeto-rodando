module com.example.testeprojeto {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.testeprojeto to javafx.fxml;
    opens com.example.testeprojeto.controller to javafx.fxml;
    opens com.example.testeprojeto.dominio to javafx.fxml;

    exports com.example.testeprojeto;
    exports com.example.testeprojeto.controller;
    exports com.example.testeprojeto.dominio;
}
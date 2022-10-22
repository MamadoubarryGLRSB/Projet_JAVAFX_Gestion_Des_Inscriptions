module ism.inscriptions {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires de.jensd.fx.glyphs.fontawesome;

    opens ism.inscriptions.controllers to javafx.fxml;
    exports ism.inscriptions;
    exports ism.inscriptions.entities;
}

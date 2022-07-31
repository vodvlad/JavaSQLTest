module com.vodvlad.testjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.vodvlad.testjfx to javafx.fxml;
    exports com.vodvlad.testjfx;
}
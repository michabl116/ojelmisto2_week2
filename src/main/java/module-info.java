module week2.demo5 {
    requires javafx.controls;
    requires javafx.fxml;

    opens week2.demo5 to javafx.fxml;
    exports week2.demo5;
}

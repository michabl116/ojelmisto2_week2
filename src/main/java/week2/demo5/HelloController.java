package week2.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML private Label lblWeight, lblHeight, lblResult;
    @FXML private TextField tfWeight, tfHeight;
    @FXML private Button btnCalculate;
    private ResourceBundle rb;

    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    public void setLanguage(Locale locale) {
        rb = ResourceBundle.getBundle("MessagesBundle", locale);
        lblWeight.setText(rb.getString("lblWeight.text"));
        lblHeight.setText(rb.getString("lblHeight.text"));
        btnCalculate.setText(rb.getString("btnCalculate.text"));
        lblResult.setText(rb.getString("lblResult.text"));
    }

    @FXML
    public void onCalculateClick() {
        try {
            double weight = Double.parseDouble(tfWeight.getText());
            double height = Double.parseDouble(tfHeight.getText()) / 100.0;
            double bmi = weight / (height * height);
            lblResult.setText(rb.getString("lblResult.text") + " " + String.format("%.2f", bmi));
        } catch (NumberFormatException e) {
            lblResult.setText(rb.getString("lblInvalid.text"));
        }
    }

    @FXML public void onENClick(ActionEvent event) { setLanguage(new Locale("en", "US")); }
    @FXML public void onFRClick(ActionEvent event) { setLanguage(new Locale("fr", "FR")); }
    @FXML public void onURClick(ActionEvent event) { setLanguage(new Locale("ur", "PA")); }
    @FXML public void onVIClick(ActionEvent event) { setLanguage(new Locale("vi", "VI")); }
}

package com.example.csc325_colorchooser;// Fig. 13.9: ColorChooserController.java
// Controller for the ColorChooser app
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
    // instance variables for interacting with GUI components
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize() {
        // Bind the TextField values to the corresponding Slider values bi-directionally
        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), conv);
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), conv);
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), conv);
        alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), alphaConv);

        // Bind the color rectangle's fill property to the slider values
        colorRectangle.fillProperty().bind(
                Bindings.createObjectBinding(() ->
                                Color.rgb(
                                        (int) redSlider.getValue(),
                                        (int) greenSlider.getValue(),
                                        (int) blueSlider.getValue(),
                                        alphaSlider.getValue()
                                ),
                        redSlider.valueProperty(),
                        greenSlider.valueProperty(),
                        blueSlider.valueProperty(),
                        alphaSlider.valueProperty()
                )
        );
    }

    // Converter for integer values (used for RGB)
    private final javafx.util.StringConverter<Number> conv = new javafx.util.StringConverter<>() {
        @Override
        public String toString(Number value) {
            return value.intValue() + "";
        }

        @Override
        public Number fromString(String string) {
            return Integer.parseInt(string);
        }
    };

    // Converter for double values (used for alpha)
    private final javafx.util.StringConverter<Number> alphaConv = new javafx.util.StringConverter<>() {
        @Override
        public String toString(Number value) {
            return String.format("%.2f", value.doubleValue());
        }

        @Override
        public Number fromString(String string) {
            return Double.parseDouble(string);
        }
    };
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

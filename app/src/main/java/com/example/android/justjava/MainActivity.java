package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int noOfCoffees=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        EditText nameText = (EditText) findViewById(R.id.name_input);
        String name = nameText.getText().toString();
        String priceMessage = calculateOrderSummary(name,noOfCoffees,hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);
    }

    /*
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+ number);
    }

    /*
    * This method is used to add the functionality to the increment button.
    * */
    public void increment(View view){
        noOfCoffees++;
        display(noOfCoffees);
    }

    /*
    * This method is used to add the functionality to the increment button.
    * */
    public void decrement(View view){
        noOfCoffees--;
        display(noOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /*
    This method canculate the price of the person
     */
    private String calculateOrderSummary(String name,int number, boolean hasOrNot, boolean hasChoco) {
        String output = "Name:" + name + "\nQuantity: " + number + "\nWhipped Cream Checked: " + hasOrNot + "\nChocolate Checked: " + hasChoco + "\nTotal: $" + (number*5) + "\nThank You!";
        return(output);
    }

}
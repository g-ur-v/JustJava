package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        String priceMessage = calculateOrderSummary(noOfCoffees,hasWhippedCream);
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
    private String calculateOrderSummary(int number, boolean hasOrNot) {
        return("Name: Kaptain Kunal\nQuantity: "+ number + "\nWhipped Cream Checked: "+ hasOrNot +"\nTotal: $"+ (number*5) + "\nThank You!");
    }

}
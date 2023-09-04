package com.myapp.currencyconverterapplication;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAmount;
    private Spinner spinnerFromCurrency;
    private Spinner spinnerToCurrency;
    private Button buttonConvert;
    private TextView textViewResult;

    private Map<String, Double> conversionRates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editTextAmount = findViewById(R.id.editTextAmount);
        spinnerFromCurrency = findViewById(R.id.spinnerFromCurrency);
        spinnerToCurrency = findViewById(R.id.spinnerToCurrency);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        // Initialize conversion rates (replace with actual data)
        initConversionRates();

        // Set up spinners
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFromCurrency.setAdapter(adapter);
        spinnerToCurrency.setAdapter(adapter);

        // Set up button click listener
        buttonConvert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency();
            }
        });
    }

    private void initConversionRates() {

        conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0);
        conversionRates.put("EUR", 0.85);
        conversionRates.put("GBP", 0.73);
        conversionRates.put("JPY", 110.45);  // Japanese Yen
        conversionRates.put("AUD", 1.35);    // Australian Dollar
        conversionRates.put("CAD", 1.26);    // Canadian Dollar
        conversionRates.put("INR", 73.50);   // Indian Rupee
        conversionRates.put("CNY", 6.45);    // Chinese Yuan
        conversionRates.put("NZD", 1.44);    // New Zealand Dollar
        conversionRates.put("SGD", 1.32);    // Singapore Dollar
        conversionRates.put("HKD", 7.79);    // Hong Kong Dollar
        conversionRates.put("KRW", 1181.50); // South Korean Won
        conversionRates.put("CHF", 0.92);    // Swiss Franc
        conversionRates.put("AED", 3.67);    // United Arab Emirates Dirham
        conversionRates.put("ZAR", 14.50);   // South African Rand
        conversionRates.put("SEK", 8.67);    // Swedish Krona
        conversionRates.put("NOK", 8.82);    // Norwegian Krone
        conversionRates.put("BRL", 5.22);    // Brazilian Real
        conversionRates.put("MXN", 20.05);   // Mexican Peso
        conversionRates.put("RUB", 73.12);   // Russian Ruble
        conversionRates.put("TRY", 13.12);   // Turkish Lira
        conversionRates.put("THB", 32.75);   // Thai Baht
        conversionRates.put("IDR", 14028.50);// Indonesian Rupiah
        conversionRates.put("MYR", 4.16);    // Malaysian Ringgit
        conversionRates.put("PHP", 50.12);   // Philippine Peso
        conversionRates.put("PLN", 3.82);    // Polish Złoty
        conversionRates.put("CZK", 21.85);   // Czech Koruna
    }

    private void convertCurrency() {
        String fromCurrency = spinnerFromCurrency.getSelectedItem().toString();
        String toCurrency = spinnerToCurrency.getSelectedItem().toString();

        double amount = Double.parseDouble(editTextAmount.getText().toString());
        double fromRate = conversionRates.get(fromCurrency);
        double toRate = conversionRates.get(toCurrency);

        double convertedAmount = (amount / fromRate) * toRate;

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String result = decimalFormat.format(convertedAmount) + " " + toCurrency;
        textViewResult.setText(result);
    }
}

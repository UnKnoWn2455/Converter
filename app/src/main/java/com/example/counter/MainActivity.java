package com.example.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView counterNumber;
    Button button;
    EditText weightInput;
    int counter = 0;
    final double CONVERSION_RATE = 2.205; // 1 kg = 2.205 pounds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        counterNumber = findViewById(R.id.counter_number);
        weightInput = findViewById(R.id.weight_input); // Assuming you added an EditText with id weight_input in your layout

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = weightInput.getText().toString().trim();

                if (!inputText.isEmpty()) {
                    try {
                        double weightKg = Double.parseDouble(inputText);
                        double weightPounds = weightKg * CONVERSION_RATE;
                        counterNumber.setText(String.format("%.2f lb", weightPounds)); // Format weightPounds to 2 decimal places
                        weightInput.setText(""); // Clear the input field after conversion
                        counter++; // Increment counter
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input! Please enter a number.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
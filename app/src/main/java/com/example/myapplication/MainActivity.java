package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Double input1 = Double.NaN;
    private Double input2;
    private final char UNDEFINED = 'U';
    private final char ADDING = 'A';
    private final char MULTIPLICATION = 'M';
    private final char DIVISION = 'D';
    private final char SUBTRACT = 'S';
    private char operation = UNDEFINED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button1.setOnClickListener(v -> addValue((Button) v));
        binding.button2.setOnClickListener(v -> addValue((Button) v));
        binding.button3.setOnClickListener(v -> addValue((Button) v));
        binding.button4.setOnClickListener(v -> addValue((Button) v));
        binding.button5.setOnClickListener(v -> addValue((Button) v));
        binding.button6.setOnClickListener(v -> addValue((Button) v));
        binding.button7.setOnClickListener(v -> addValue((Button) v));
        binding.button8.setOnClickListener(v -> addValue((Button) v));
        binding.button9.setOnClickListener(v -> addValue((Button) v));
        binding.button0.setOnClickListener(v -> addValue((Button) v));


        binding.buttonsum.setOnClickListener(v -> {
            calculate();
            operation = ADDING;
            binding.display.setText(null);

        });

        binding.buttonsub.setOnClickListener(v -> {
            calculate();
            operation = SUBTRACT;
            binding.display.setText(null);

        });

        binding.buttonmul.setOnClickListener(v -> {
            calculate();
            operation = MULTIPLICATION;
            binding.display.setText(null);

        });

        binding.buttondiv.setOnClickListener(v -> {
            calculate();
            operation = DIVISION;
            binding.display.setText(null);

        });

        binding.buttoneql.setOnClickListener(v -> {
            calculate();
            binding.display.setText(String.valueOf(input1));
            input1 = Double.NaN;
            operation = UNDEFINED;
        });

        binding.buttonClear.setOnClickListener(v -> {
            binding.display.setText("");
            input1 = Double.NaN;
            input2 = Double.NaN;
            operation = UNDEFINED;
        });
    }

    private void calculate() {
        if (Double.isNaN(input1)) {
            try {
                input1 = Double.parseDouble(binding.display.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            input2 = Double.parseDouble(binding.display.getText().toString());
            binding.display.setText(null);
            switch (operation) {
                case ADDING:
                    input1 = input1 + input2;
                    break;
                case SUBTRACT:
                    input1 = input1 - input2;
                    break;
                case MULTIPLICATION:
                    input1 = input1 * input2;
                    break;
                case DIVISION:
                    input1 = input1 / input2;
                    break;
            }
        }
    }

    private void addValue(Button button) {
        String value = binding.display.getText() + button.getText().toString();
        binding.display.setText(value);
    }
}
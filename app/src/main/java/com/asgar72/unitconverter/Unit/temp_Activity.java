package com.asgar72.unitconverter.Unit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asgar72.unitconverter.R;

public class temp_Activity extends AppCompatActivity {

    EditText txt_C, txt_F, txt_K, txt_R;
    Button btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        txt_C = findViewById(R.id.txt_C);
        txt_F = findViewById(R.id.txt_F);
        txt_K = findViewById(R.id.txt_K);
        txt_R = findViewById(R.id.txt_R);
        btn_clear = findViewById(R.id.btn_clear);

        // Add onFocusChangeListeners to dynamically change background color
        txt_C.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txt_C.setBackgroundResource(R.drawable.focused_background);
                } else {
                    txt_C.setBackgroundResource(R.drawable.default_background);
                }
            }
        });

        txt_F.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txt_F.setBackgroundResource(R.drawable.focused_background);
                } else {
                    txt_F.setBackgroundResource(R.drawable.default_background);
                }
            }
        });

        txt_K.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txt_K.setBackgroundResource(R.drawable.focused_background);
                } else {
                    txt_K.setBackgroundResource(R.drawable.default_background);
                }
            }
        });

        txt_R.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    txt_R.setBackgroundResource(R.drawable.focused_background);
                } else {
                    txt_R.setBackgroundResource(R.drawable.default_background);
                }
            }
        });

        // Set onClickListener for the Clear button
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_C.setText("");
                txt_F.setText("");
                txt_K.setText("");
                txt_R.setText("");
            }
        });

        // Add text change listeners for temperature conversions
        txt_C.addTextChangedListener(celsiusTextWatcher);
        txt_F.addTextChangedListener(fahrenheitTextWatcher);
        txt_K.addTextChangedListener(kelvinTextWatcher);
        txt_R.addTextChangedListener(rankineTextWatcher);
    }

    TextWatcher celsiusTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_F.removeTextChangedListener(fahrenheitTextWatcher);
            txt_K.removeTextChangedListener(kelvinTextWatcher);
            txt_R.removeTextChangedListener(rankineTextWatcher);
            convertCelsius();
            txt_F.addTextChangedListener(fahrenheitTextWatcher);
            txt_K.addTextChangedListener(kelvinTextWatcher);
            txt_R.addTextChangedListener(rankineTextWatcher);
        }
    };

    TextWatcher fahrenheitTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_C.removeTextChangedListener(celsiusTextWatcher);
            txt_K.removeTextChangedListener(kelvinTextWatcher);
            txt_R.removeTextChangedListener(rankineTextWatcher);
            convertFahrenheit();
            txt_C.addTextChangedListener(celsiusTextWatcher);
            txt_K.addTextChangedListener(kelvinTextWatcher);
            txt_R.addTextChangedListener(rankineTextWatcher);
        }
    };

    TextWatcher kelvinTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_C.removeTextChangedListener(celsiusTextWatcher);
            txt_F.removeTextChangedListener(fahrenheitTextWatcher);
            txt_R.removeTextChangedListener(rankineTextWatcher);
            convertKelvin();
            txt_C.addTextChangedListener(celsiusTextWatcher);
            txt_F.addTextChangedListener(fahrenheitTextWatcher);
            txt_R.addTextChangedListener(rankineTextWatcher);
        }
    };

    TextWatcher rankineTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_C.removeTextChangedListener(celsiusTextWatcher);
            txt_F.removeTextChangedListener(fahrenheitTextWatcher);
            txt_K.removeTextChangedListener(kelvinTextWatcher);
            convertRankine();
            txt_C.addTextChangedListener(celsiusTextWatcher);
            txt_F.addTextChangedListener(fahrenheitTextWatcher);
            txt_K.addTextChangedListener(kelvinTextWatcher);
        }
    };

    void convertCelsius() {
        String celsiusString = txt_C.getText().toString();
        if (!celsiusString.isEmpty() && !celsiusString.endsWith("°C")) {
            double celsius = Double.parseDouble(celsiusString);
            double fahrenheit = (celsius * 9 / 5) + 32;
            txt_F.setText(String.format("%.2f°F", fahrenheit));
            double kelvin = celsius + 273.15;
            txt_K.setText(String.format("%.2f°K", kelvin));
            double rankine = (celsius + 273.15) * 9 / 5;
            txt_R.setText(String.format("%.2f°R", rankine));
        }
    }

    void convertFahrenheit() {
        String fahrenheitString = txt_F.getText().toString();
        if (!fahrenheitString.isEmpty() && !fahrenheitString.endsWith("°F")) {
            double fahrenheit = Double.parseDouble(fahrenheitString);
            double celsius = (fahrenheit - 32) * 5 / 9;
            txt_C.setText(String.format("%.2f°C", celsius));
            double kelvin = (fahrenheit - 32) * 5 / 9 + 273.15;
            txt_K.setText(String.format("%.2f°K", kelvin));
            double rankine = fahrenheit + 459.67;
            txt_R.setText(String.format("%.2f°R", rankine));
        }
    }

    void convertKelvin() {
        String kelvinString = txt_K.getText().toString();

        if (!kelvinString.isEmpty() && !kelvinString.endsWith("°K")) {
            double kelvin = Double.parseDouble(kelvinString);
            double celsius = kelvin - 273.15;
            txt_C.setText(String.format("%.2f°C", celsius));
            double fahrenheit = (kelvin - 273.15) * 9 / 5 + 32;
            txt_F.setText(String.format("%.2f°F", fahrenheit));
            double rankine = kelvin * 9 / 5;
            txt_R.setText(String.format("%.2f°R", rankine));
        }
    }

    void convertRankine() {
        String rankineString = txt_R.getText().toString();
        if (!rankineString.isEmpty() && !rankineString.endsWith("°R")) {
            double rankine = Double.parseDouble(rankineString);
            double celsius = (rankine - 491.67) * 5 / 9;
            txt_C.setText(String.format("%.2f°C", celsius));
            double fahrenheit = rankine - 459.67;
            txt_F.setText(String.format("%.2f°F", fahrenheit));
            double kelvin = rankine * 5 / 9;
            txt_K.setText(String.format("%.2f°K", kelvin));
        }
    }
}

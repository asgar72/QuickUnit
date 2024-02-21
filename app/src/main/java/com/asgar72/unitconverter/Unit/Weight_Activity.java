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


public class Weight_Activity extends AppCompatActivity {
    Button btn_clear;
    EditText txt_mg, txt_g, txt_kg, txt_t, txt_lb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_mg.setText("");
                txt_g.setText("");
                txt_kg.setText("");
                txt_t.setText("");
                txt_lb.setText("");
            }
        });

        txt_mg = findViewById(R.id.txt_mg);
        txt_g = findViewById(R.id.txt_g);
        txt_kg = findViewById(R.id.txt_kg);
        txt_t = findViewById(R.id.txt_t);
        txt_lb = findViewById(R.id.txt_lb);


        txt_mg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not needed
            }

            @Override
            public void afterTextChanged(Editable s) {
                txt_g.removeTextChangedListener(GramsTextWatcher);
                txt_kg.removeTextChangedListener(KiloGramsTextWatcher);
                txt_t.removeTextChangedListener(TonsTextWatcher);
                convertMilliGrams();
                txt_g.addTextChangedListener(GramsTextWatcher);
                txt_kg.addTextChangedListener(KiloGramsTextWatcher);
                txt_t.addTextChangedListener(TonsTextWatcher);
            }
        });
        txt_g.addTextChangedListener(GramsTextWatcher);
        txt_kg.addTextChangedListener(KiloGramsTextWatcher);
        txt_t.addTextChangedListener(TonsTextWatcher);
    }

    TextWatcher MiligramsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Not needed
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Not needed
        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_g.removeTextChangedListener(GramsTextWatcher);
            txt_kg.removeTextChangedListener(KiloGramsTextWatcher);
            txt_t.removeTextChangedListener(TonsTextWatcher);
            convertMilliGrams();
            txt_g.addTextChangedListener(MiligramsTextWatcher);
            txt_kg.addTextChangedListener(KiloGramsTextWatcher);
            txt_t.addTextChangedListener(TonsTextWatcher);
        }
    };

    TextWatcher GramsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Not needed
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Not needed
        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_mg.removeTextChangedListener(MiligramsTextWatcher);
            txt_kg.removeTextChangedListener(KiloGramsTextWatcher);
            txt_t.removeTextChangedListener(TonsTextWatcher);
            convertGrams();
            txt_mg.addTextChangedListener(MiligramsTextWatcher);
            txt_kg.addTextChangedListener(KiloGramsTextWatcher);
            txt_t.addTextChangedListener(TonsTextWatcher);
        }
    };


    TextWatcher KiloGramsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Not needed
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Not needed
        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_mg.removeTextChangedListener(MiligramsTextWatcher);
            txt_g.removeTextChangedListener(GramsTextWatcher);
            txt_t.removeTextChangedListener(TonsTextWatcher);
            convertKilo();
            txt_mg.addTextChangedListener(MiligramsTextWatcher);
            txt_g.addTextChangedListener(GramsTextWatcher);
            txt_t.addTextChangedListener(TonsTextWatcher);
        }
    };

    TextWatcher TonsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Not needed
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Not needed
        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_mg.removeTextChangedListener(MiligramsTextWatcher);
            txt_g.removeTextChangedListener(GramsTextWatcher);
            txt_kg.removeTextChangedListener(KiloGramsTextWatcher);
            convertTons();
            txt_mg.addTextChangedListener(MiligramsTextWatcher);
            txt_g.addTextChangedListener(GramsTextWatcher);
            txt_kg.addTextChangedListener(KiloGramsTextWatcher);
        }
    };


    void convertMilliGrams() {
        String milliString = txt_mg.getText().toString();
        if (!milliString.isEmpty() && !milliString.endsWith("mg")) {
            double miligrams = Double.parseDouble(milliString);
            double gram = (miligrams / 1000);
            txt_g.setText(String.format("%.2f g", gram));
            double kilogram = miligrams / 1000000;
            txt_kg.setText(String.format("%.2f kg", kilogram));
            double tons = (miligrams / 1000000000);
            txt_t.setText(String.format("%.2f t", tons));
            double pounds = (miligrams / 453592.37);
            txt_lb.setText(String.format("%.2f lb", pounds));
        }
    }

    void convertGrams() {
        String gramsString = txt_g.getText().toString();
        if (!gramsString.isEmpty() && !gramsString.endsWith("g")) {
            double gram = Double.parseDouble(gramsString);
            double miligrams = (gram * 1000);
            txt_mg.setText(String.format("%.2f mg", miligrams));
            double kilogram = gram / 1000;
            txt_kg.setText(String.format("%.2f kg", kilogram));
            double tons = (gram / 1000000);
            txt_t.setText(String.format("%.2f t", tons));
            double pounds = (gram / 453.59237);
            txt_lb.setText(String.format("%.2f lb", pounds));
        }
    }

    void convertKilo() {
        String kiloString = txt_kg.getText().toString();
        if (!kiloString.isEmpty() && !kiloString.endsWith("kg")) {
            double kilograms = Double.parseDouble(kiloString);
            double miligrams = (kilograms * 1000000);
            txt_mg.setText(String.format("%.2f mg", miligrams));
            double gram = (kilograms * 1000);
            txt_g.setText(String.format("%.2f g", gram));
            double tons = (kilograms / 1000);
            txt_t.setText(String.format("%.2f t", tons));
            double pounds = (kilograms * 2.20462);
            txt_lb.setText(String.format("%.2f lb", pounds));
        }
    }

    void convertTons() {
        String tonsString = txt_t.getText().toString();
        if (!tonsString.isEmpty() && !tonsString.endsWith("t")) {
            double tons = Double.parseDouble(tonsString);
            double miligrams = (tons * 1000000000);
            txt_mg.setText(String.format("%.2f mg", miligrams));
            double grams = tons * 1000000;
            txt_g.setText(String.format("%.2f g", grams));
            double kilograms = (tons * 1000);
            txt_kg.setText(String.format("%.2f kg", kilograms));
            double pounds = (tons * 2204.62);
            txt_lb.setText(String.format("%.2f lb", pounds));
        }
    }

}
package com.asgar72.unitconverter.Calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.asgar72.unitconverter.MainActivity;
import com.asgar72.unitconverter.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.ArrayList;
import java.util.HashSet;

public class CalculatorActivity extends AppCompatActivity {

    // Declare ArrayList to store calculations
    ArrayList<String> calculations = new ArrayList<>();

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn00,
            btnClear, btnMod, btnDel, btnDiv, btnMul, btnSub, btnAdd, btnEqual;
    TextView OutputTxt, inputTxt;
    String data;
    ImageView btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        btnHistory = findViewById(R.id.btnHistory);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btn1 = findViewById(R.id.btn1);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btn00 = findViewById(R.id.btn00);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        btnMod = findViewById(R.id.btnMod);
        btnDel = findViewById(R.id.btnDel);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnSub = findViewById(R.id.btnSub);
        btnEqual = findViewById(R.id.btnEqual);
        inputTxt = findViewById(R.id.inputTxt);
        OutputTxt = findViewById(R.id.OutputTxt);

        // Inside onCreate() or wherever you initialize your ArrayList
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        calculations = new ArrayList<>(sharedPreferences.getStringSet("calculations", new HashSet<>()));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "0");
            }
        });

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "00");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTxt.setText("");
                OutputTxt.setText("");
            }
        });

//        btnDot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                data = inputTxt.getText().toString();
//                inputTxt.setText(data + ".");
//            }
//        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "×");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "÷");
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "%");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTxt.setText("");

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                data = data.replaceAll("×", "*");
                data = data.replaceAll("%", "/100");
                data = data.replaceAll("÷", "/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                Scriptable scriptable = rhino.initSafeStandardObjects();
                finalResult = rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();
                OutputTxt.setText(finalResult);

                // Create a string that contains both the user input and the solution
                String calculation = data + " = " + finalResult;

                // Add the calculation string to the ArrayList
                calculations.add(calculation);

                // Save the updated calculations ArrayList to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putStringSet("calculations", new HashSet<>(calculations));
                editor.apply();
            }
        });


        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this, HistoryActivity.class);
                intent.putStringArrayListExtra("calculations", calculations); // Assuming calculations is your ArrayList<String>
                startActivity(intent);
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // Set calc selected
        bottomNavigationView.setSelectedItemId(R.id.calc);
        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.calc:
                        return true;
                }
                return true;
            }
        });
    }
}
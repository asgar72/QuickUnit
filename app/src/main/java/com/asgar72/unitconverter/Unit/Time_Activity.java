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


public class Time_Activity extends AppCompatActivity {

    EditText txt_hr, txt_min, txt_sec, txt_ms, txt_day;
    Button btn_clear;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_hr.setText("");
                txt_min.setText("");
                txt_sec.setText("");
                txt_ms.setText("");
                txt_day.setText("");
            }
        });

        txt_hr = findViewById(R.id.txt_hr);
        txt_min = findViewById(R.id.txt_min);
        txt_sec = findViewById(R.id.txt_sec);
        txt_ms = findViewById(R.id.txt_ms);
        txt_day = findViewById(R.id.txt_day);

        txt_hr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                txt_min.removeTextChangedListener(MinTextWatcher);
                txt_sec.removeTextChangedListener(SecTextWatcher);
                txt_ms.removeTextChangedListener(MillisecTextWatcher);
                txt_day.removeTextChangedListener(DayTextWatcher);
                convertHours();
                txt_min.addTextChangedListener(MinTextWatcher);
                txt_sec.addTextChangedListener(SecTextWatcher);
                txt_ms.addTextChangedListener(MillisecTextWatcher);
                txt_day.addTextChangedListener(DayTextWatcher);
            }
        });
        txt_min.addTextChangedListener(MinTextWatcher);
        txt_sec.addTextChangedListener(SecTextWatcher);
        txt_ms.addTextChangedListener(MillisecTextWatcher);
        txt_day.addTextChangedListener(DayTextWatcher);
    }

    TextWatcher HoursTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_min.removeTextChangedListener(MinTextWatcher);
            txt_sec.removeTextChangedListener(SecTextWatcher);
            txt_ms.removeTextChangedListener(MillisecTextWatcher);
            txt_day.removeTextChangedListener(DayTextWatcher);
            convertHours();
            txt_min.addTextChangedListener(MinTextWatcher);
            txt_sec.addTextChangedListener(SecTextWatcher);
            txt_ms.addTextChangedListener(MillisecTextWatcher);
            txt_day.addTextChangedListener(DayTextWatcher);
        }
    };

    TextWatcher MinTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_hr.removeTextChangedListener(HoursTextWatcher);
            txt_sec.removeTextChangedListener(SecTextWatcher);
            txt_ms.removeTextChangedListener(MillisecTextWatcher);
            txt_day.removeTextChangedListener(DayTextWatcher);
            convertMin();
            txt_hr.addTextChangedListener(HoursTextWatcher);
            txt_sec.addTextChangedListener(SecTextWatcher);
            txt_ms.addTextChangedListener(MillisecTextWatcher);
            txt_day.addTextChangedListener(DayTextWatcher);

        }
    };

    TextWatcher SecTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_hr.removeTextChangedListener(HoursTextWatcher);
            txt_min.removeTextChangedListener(MinTextWatcher);
            txt_ms.removeTextChangedListener(MillisecTextWatcher);
            txt_day.removeTextChangedListener(DayTextWatcher);
            convertSec();
            txt_hr.addTextChangedListener(HoursTextWatcher);
            txt_min.addTextChangedListener(MinTextWatcher);
            txt_ms.addTextChangedListener(MillisecTextWatcher);
            txt_day.addTextChangedListener(DayTextWatcher);
        }
    };

    TextWatcher MillisecTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_hr.removeTextChangedListener(HoursTextWatcher);
            txt_min.removeTextChangedListener(MinTextWatcher);
            txt_sec.removeTextChangedListener(SecTextWatcher);
            txt_day.removeTextChangedListener(DayTextWatcher);
            convertMs();
            txt_hr.addTextChangedListener(HoursTextWatcher);
            txt_min.addTextChangedListener(MinTextWatcher);
            txt_sec.addTextChangedListener(SecTextWatcher);
            txt_day.addTextChangedListener(DayTextWatcher);
        }
    };

    TextWatcher DayTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_hr.removeTextChangedListener(HoursTextWatcher);
            txt_min.removeTextChangedListener(MinTextWatcher);
            txt_sec.removeTextChangedListener(SecTextWatcher);
            txt_ms.removeTextChangedListener(MillisecTextWatcher);
            convertDay();
            txt_hr.addTextChangedListener(HoursTextWatcher);
            txt_min.addTextChangedListener(MinTextWatcher);
            txt_sec.addTextChangedListener(SecTextWatcher);
            txt_ms.addTextChangedListener(MillisecTextWatcher);
        }
    };


    void convertHours() {
        String hoursString = txt_hr.getText().toString();
        if (!hoursString.isEmpty() && !hoursString.endsWith("h")) {
            double hrs = Double.parseDouble(hoursString);
            double min = hrs * 60;
            txt_min.setText(String.format("%.2f min", min));
            double sec = hrs * 3600;
            txt_sec.setText(String.format("%.2f s", sec));
            double milisec = hrs * 3600000;
            txt_ms.setText(String.format("%.2f ms", milisec));
            double day = hrs / 24;
            txt_day.setText(String.format("%.2f d", day));
        }
    }

    void convertMin() {
        String minString = txt_min.getText().toString();
        if (!minString.isEmpty() && !minString.endsWith("min")) {
            double min = Double.parseDouble(minString);
            double hrs = min / 60;
            txt_hr.setText(String.format("%.2f min", hrs));
            double sec = min * 60;
            txt_sec.setText(String.format("%.2f s", sec));
            double milisec = min * 60000;
            txt_ms.setText(String.format("%.2f ms", milisec));
            double day = min / 1440;
            txt_day.setText(String.format("%.2f d", day));
        }
    }

    void convertSec() {
        String secString = txt_sec.getText().toString();
        if (!secString.isEmpty() && !secString.endsWith("s")) {
            double sec = Double.parseDouble(secString);
            double hrs = sec / 3600;
            txt_hr.setText(String.format("%.2f h", hrs));
            double min = sec / 60;
            txt_min.setText(String.format("%.2f min", min));
            double milisec = sec * 1000;
            txt_ms.setText(String.format("%.2f ms", milisec));
            double day = sec / 86400;
            txt_day.setText(String.format("%.2f d", day));
        }
    }

    void convertMs() {
        String msString = txt_ms.getText().toString();
        if (!msString.isEmpty() && !msString.endsWith("ms")) {
            double ms = Double.parseDouble(msString);
            double hrs = ms / (1000 * 60 * 60);
            txt_hr.setText(String.format("%.2f h", hrs));
            double min = ms / 1000 * 60;
            txt_min.setText(String.format("%.2f min", min));
            double sec = ms / 1000;
            txt_sec.setText(String.format("%.2f s", sec));
            double day = ms / (1000 * 60 * 60 * 24);
            txt_day.setText(String.format("%.2f d", day));
        }
    }

    void convertDay() {
        String dayString = txt_day.getText().toString();
        if (!dayString.isEmpty() && !dayString.endsWith("d")) {
            double day = Double.parseDouble(dayString);
            double hrs = day * 24;
            txt_hr.setText(String.format("%.2f h", hrs));
            double min = day * 24 * 60;
            txt_min.setText(String.format("%.2f min", min));
            double sec = day * 24 * 60 * 60;
            txt_sec.setText(String.format("%.2f s", sec));
            double ms = day * 24 * 60 * 60 * 1000;
            txt_ms.setText(String.format("%.2f ms", ms));
        }
    }
}

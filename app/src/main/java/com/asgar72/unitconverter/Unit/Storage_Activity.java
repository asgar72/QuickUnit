package com.asgar72.unitconverter.Unit;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asgar72.unitconverter.R;


public class Storage_Activity extends AppCompatActivity {
    EditText txt_bt, txt_kb, txt_mb, txt_gb, txt_tb;
    Button btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        txt_bt = findViewById(R.id.txt_bt);
        txt_kb = findViewById(R.id.txt_kb);
        txt_mb = findViewById(R.id.txt_mb);
        txt_gb = findViewById(R.id.txt_gb);
        txt_tb = findViewById(R.id.txt_tb);
        btn_clear = findViewById(R.id.btn_clear);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_bt.setText("");
                txt_kb.setText("");
                txt_mb.setText("");
                txt_gb.setText("");
                txt_tb.setText("");
            }
        });

        txt_bt.addTextChangedListener(new TextWatcher() {
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
                txt_kb.removeTextChangedListener(kilobyteTextWatcher);
                txt_mb.removeTextChangedListener(MegabyteTextWatcher);
                txt_gb.removeTextChangedListener(GigabyteTextWatcher);
                convertBytes();
                txt_kb.addTextChangedListener(kilobyteTextWatcher);
                txt_mb.addTextChangedListener(MegabyteTextWatcher);
                txt_gb.addTextChangedListener(GigabyteTextWatcher);
            }
        });
        txt_kb.addTextChangedListener(kilobyteTextWatcher);
        txt_mb.addTextChangedListener(MegabyteTextWatcher);
        txt_gb.addTextChangedListener(GigabyteTextWatcher);
    }

    TextWatcher byteTextWatcher = new TextWatcher() {
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
            txt_kb.removeTextChangedListener(kilobyteTextWatcher);
            txt_mb.removeTextChangedListener(MegabyteTextWatcher);
            txt_gb.removeTextChangedListener(GigabyteTextWatcher);
            convertBytes();
            txt_kb.addTextChangedListener(kilobyteTextWatcher);
            txt_mb.addTextChangedListener(MegabyteTextWatcher);
            txt_gb.addTextChangedListener(GigabyteTextWatcher);
        }
    };

    TextWatcher kilobyteTextWatcher = new TextWatcher() {
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
            txt_bt.removeTextChangedListener(byteTextWatcher);
            txt_mb.removeTextChangedListener(MegabyteTextWatcher);
            txt_gb.removeTextChangedListener(GigabyteTextWatcher);
            convertKilobytes();
            txt_bt.addTextChangedListener(byteTextWatcher);
            txt_mb.addTextChangedListener(MegabyteTextWatcher);
            txt_gb.addTextChangedListener(GigabyteTextWatcher);
        }
    };


    TextWatcher MegabyteTextWatcher = new TextWatcher() {
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
            txt_bt.removeTextChangedListener(byteTextWatcher);
            txt_kb.removeTextChangedListener(kilobyteTextWatcher);
            txt_gb.removeTextChangedListener(GigabyteTextWatcher);
            convertMegabytes();
            txt_bt.addTextChangedListener(byteTextWatcher);
            txt_kb.addTextChangedListener(kilobyteTextWatcher);
            txt_gb.addTextChangedListener(GigabyteTextWatcher);
        }
    };

    TextWatcher GigabyteTextWatcher = new TextWatcher() {
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
            txt_bt.removeTextChangedListener(byteTextWatcher);
            txt_kb.removeTextChangedListener(kilobyteTextWatcher);
            txt_mb.removeTextChangedListener(MegabyteTextWatcher);
            convertGigabytes();
            txt_bt.addTextChangedListener(byteTextWatcher);
            txt_kb.addTextChangedListener(kilobyteTextWatcher);
            txt_mb.addTextChangedListener(MegabyteTextWatcher);
        }
    };


    void convertBytes() {
        String bytesString = txt_bt.getText().toString();
        if (!bytesString.isEmpty() && !bytesString.endsWith("B")) {
            double bytes = Double.parseDouble(bytesString);
            double kilobyte = (bytes / 1024.0);
            txt_kb.setText(String.format("%.2f KB", kilobyte));
            double megabytes = kilobyte / 1024.0;
            txt_mb.setText(String.format("%.2f MB", megabytes));
            double gigabyte = (megabytes / 1024.0);
            txt_gb.setText(String.format("%.2f GB", gigabyte));
            double terabyte = (gigabyte / 1024.0);
            txt_tb.setText(String.format("%.2f TB", terabyte));
        }
    }

    void convertKilobytes() {
        String kilobyteString = txt_kb.getText().toString();
        if (!kilobyteString.isEmpty() && !kilobyteString.endsWith("KB")) {
            double kilobytes = Double.parseDouble(kilobyteString);
            double bytes = (kilobytes * 1024.0);
            txt_bt.setText(String.format("%.2f B", bytes));
            double megabytes = kilobytes / 1024.0;
            txt_mb.setText(String.format("%.2f MB", megabytes));
            double gigabyte = (megabytes / 1024.0);
            txt_gb.setText(String.format("%.2f GB", gigabyte));
            double terabyte = (gigabyte / 1024.0);
            txt_tb.setText(String.format("%.2f TB", terabyte));
        }
    }

    void convertMegabytes() {
        String MegabyteString = txt_mb.getText().toString();
        if (!MegabyteString.isEmpty() && !MegabyteString.endsWith("MB")) {
            double megabytes = Double.parseDouble(MegabyteString);
            double bytes = (megabytes * 1048576);
            txt_bt.setText(String.format("%.2f B", bytes));
            double kilobytes = megabytes * 1024.0;
            txt_kb.setText(String.format("%.2f KB", kilobytes));
            double gigabyte = (megabytes / 1024.0);
            txt_gb.setText(String.format("%.2f GB", gigabyte));
            double terabyte = (gigabyte / 1048576.0);
            txt_tb.setText(String.format("%.2f TB", terabyte));
        }
    }

    void convertGigabytes() {
        String GigabyteString = txt_gb.getText().toString();
        if (!GigabyteString.isEmpty() && !GigabyteString.endsWith("GB")) {
            double gigabytes = Double.parseDouble(GigabyteString);
            double bytes = (gigabytes * 1073741824);
            txt_bt.setText(String.format("%.2f B", bytes));
            double kilobytes = gigabytes * 1048576;
            txt_kb.setText(String.format("%.2f KB", kilobytes));
            double megabyte = (gigabytes * 1024.0);
            txt_mb.setText(String.format("%.2f MB", megabyte));
            double terabyte = (gigabytes / 1000.0);
            txt_tb.setText(String.format("%.2f TB", terabyte));
        }
    }
}
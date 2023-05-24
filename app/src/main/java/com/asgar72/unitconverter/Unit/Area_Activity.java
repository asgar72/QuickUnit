package com.asgar72.unitconverter.Unit;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asgar72.unitconverter.R;

public class Area_Activity extends AppCompatActivity {

    EditText txt_m2,txt_feet,txt_yt,txt_ac,txt_ha;
    Button btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_m2.setText("");
                txt_feet.setText("");
                txt_yt.setText("");
                txt_ac.setText("");
                txt_ha.setText("");
            }
        });

        txt_m2 = findViewById(R.id.txt_m2);
        txt_feet = findViewById(R.id.txt_feet);
        txt_yt = findViewById(R.id.txt_yt);
        txt_ac = findViewById(R.id.txt_ac);
        txt_ha = findViewById(R.id.txt_ha);

        txt_m2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                txt_feet.removeTextChangedListener(FeetTextWatcher);
                txt_yt.removeTextChangedListener(YtTextWatcher);
                txt_ac.removeTextChangedListener(AcTextWatcher);
                txt_ha.removeTextChangedListener(HaTextWatcher);
                convertM2();
                txt_feet.addTextChangedListener(FeetTextWatcher);
                txt_yt.addTextChangedListener(YtTextWatcher);
                txt_ac.addTextChangedListener(AcTextWatcher);
                txt_ha.addTextChangedListener(HaTextWatcher);
            }
        });
        txt_feet.addTextChangedListener(FeetTextWatcher);
        txt_yt.addTextChangedListener(YtTextWatcher);
        txt_ac.addTextChangedListener(AcTextWatcher);
        txt_ha.addTextChangedListener(HaTextWatcher);
    }



    TextWatcher M2TextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_feet.removeTextChangedListener(FeetTextWatcher);
            txt_yt.removeTextChangedListener(YtTextWatcher);
            txt_ac.removeTextChangedListener(AcTextWatcher);
            txt_ha.removeTextChangedListener(HaTextWatcher);
            convertM2();
            txt_feet.addTextChangedListener(FeetTextWatcher);
            txt_yt.addTextChangedListener(YtTextWatcher);
            txt_ac.addTextChangedListener(AcTextWatcher);
            txt_ha.addTextChangedListener(HaTextWatcher);
        }
    };

    TextWatcher FeetTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_m2.removeTextChangedListener(M2TextWatcher);
            txt_yt.removeTextChangedListener(YtTextWatcher);
            txt_ac.removeTextChangedListener(AcTextWatcher);
            txt_ha.removeTextChangedListener(HaTextWatcher);
            convertFeet();
            txt_m2.addTextChangedListener(M2TextWatcher);
            txt_yt.addTextChangedListener(YtTextWatcher);
            txt_ac.addTextChangedListener(AcTextWatcher);
            txt_ha.addTextChangedListener(HaTextWatcher);
        }
    };

    TextWatcher YtTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_m2.removeTextChangedListener(M2TextWatcher);
            txt_feet.removeTextChangedListener(FeetTextWatcher);
            txt_ac.removeTextChangedListener(AcTextWatcher);
            txt_ha.removeTextChangedListener(HaTextWatcher);
            convertYt();
            txt_m2.addTextChangedListener(M2TextWatcher);
            txt_feet.addTextChangedListener(FeetTextWatcher);
            txt_ac.addTextChangedListener(AcTextWatcher);
            txt_ha.addTextChangedListener(HaTextWatcher);
        }
    };


    TextWatcher AcTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_m2.removeTextChangedListener(M2TextWatcher);
            txt_feet.removeTextChangedListener(FeetTextWatcher);
            txt_yt.removeTextChangedListener(YtTextWatcher);
            txt_ha.removeTextChangedListener(HaTextWatcher);
            convertAc();
            txt_m2.addTextChangedListener(M2TextWatcher);
            txt_feet.addTextChangedListener(FeetTextWatcher);
            txt_yt.addTextChangedListener(YtTextWatcher);
            txt_ha.addTextChangedListener(HaTextWatcher);

        }
    };

    TextWatcher HaTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_m2.removeTextChangedListener(M2TextWatcher);
            txt_feet.removeTextChangedListener(FeetTextWatcher);
            txt_yt.removeTextChangedListener(YtTextWatcher);
            txt_ac.removeTextChangedListener(AcTextWatcher);
            convertHa();
            txt_m2.addTextChangedListener(M2TextWatcher);
            txt_feet.addTextChangedListener(FeetTextWatcher);
            txt_yt.addTextChangedListener(YtTextWatcher);
            txt_ac.addTextChangedListener(AcTextWatcher);
        }
    };



    void convertM2(){
        String m2String = txt_m2.getText().toString();
        if(!m2String.isEmpty() && !m2String.endsWith("m²")){
            double m2 = Double.parseDouble(m2String);
            double feet = m2 * 10.764;
            txt_feet.setText(String.format("%.2f ft²",feet));
            double yt = m2 * 1.196;
            txt_yt.setText(String.format("%.2f yt²",yt));
            double ac = m2 * 0.0002471;
            txt_ac.setText(String.format("%.2f ac",ac));
            double ha = m2 *0.0001;
            txt_ha.setText(String.format("%.2f ha",ha));
        }
    }
    void convertFeet(){
        String feetString = txt_feet.getText().toString();
        if(!feetString.isEmpty() && !feetString.endsWith("ft²")) {
            double feet2 = Double.parseDouble(feetString);
            double m2 = feet2  / 10.764;
            txt_m2.setText(String.format("%.2f m²", m2));
            double yt = feet2 / 9;
            txt_yt.setText(String.format("%.2f yt²", yt));
            double ac = feet2 / 43560;
            txt_ac.setText(String.format("%.2f ac", ac));
            double ha = feet2 / 107639.104;
            txt_ha.setText(String.format("%.2f ha", ha));
        }
    }
    void convertYt(){
        String ytString = txt_yt.getText().toString();
        if(!ytString.isEmpty() && !ytString.endsWith("yt²")) {
            double yt2 = Double.parseDouble(ytString);
            double m2 = yt2  * 0.83612736;
            txt_m2.setText(String.format("%.2f m²", m2));
            double feet = yt2 * 9;
            txt_feet.setText(String.format("%.2f ft²", feet));
            double ac = yt2 * 0.00020661157;
            txt_ac.setText(String.format("%.2f ac", ac));
            double ha = yt2 * 0.000083612736;
            txt_ha.setText(String.format("%.2f ha", ha));
        }
    }
    void convertAc(){
        String acString = txt_ac.getText().toString();
        if(!acString.isEmpty() && !acString.endsWith("ac")) {
            double ac = Double.parseDouble(acString);
            double m2 = ac  * 4046.86;
            txt_m2.setText(String.format("%.2f m²", m2));
            double feet = ac * 43560;
            txt_feet.setText(String.format("%.2f ft²", feet));
            double yt2 = ac * 4840;
            txt_yt.setText(String.format("%.2f yt²", yt2));
            double ha = ac * 4840;
            txt_ha.setText(String.format("%.2f ha", ha));
        }
    }
    void convertHa(){
        String haString = txt_ha.getText().toString();
        if(!haString.isEmpty() && !haString.endsWith("ha")) {
            double ha = Double.parseDouble(haString);
            double m2 = ha  * 10000;
            txt_m2.setText(String.format("%.2f m²", m2));
            double feet = ha * 107639.1;
            txt_feet.setText(String.format("%.2f ft²", feet));
            double yt2 = ha * 11959.9;
            txt_yt.setText(String.format("%.2f yt²", yt2));
            double ac = ha * 2.47105;
            txt_ac.setText(String.format("%.2f ac", ac));
        }

    }

}
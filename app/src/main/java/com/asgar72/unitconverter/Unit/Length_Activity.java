package com.asgar72.unitconverter.Unit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asgar72.unitconverter.R;


public class Length_Activity extends AppCompatActivity {
    EditText txt_mt,txt_km,txt_in,txt_ft1,txt_y ;
    Button btn_Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        btn_Clear = findViewById(R.id.btn_clear);
        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_mt.setText("");
                txt_km.setText("");
                txt_in.setText("");
                txt_ft1.setText("");
                txt_y.setText("");
            }
        });

        txt_mt = findViewById(R.id.txt_mt);
        txt_km = findViewById(R.id.txt_km);
        txt_in = findViewById(R.id.txt_in);
        txt_ft1 = findViewById(R.id.txt_ft1);
        txt_y = findViewById(R.id.txt_y);

        txt_mt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                txt_km.removeTextChangedListener(KmTextWatcher);
                txt_in.removeTextChangedListener(InTextWatcher);
                txt_ft1.removeTextChangedListener(FeetTextWatcher);
                txt_y.removeTextChangedListener(YardTextWatcher);
                convertMtr();
                txt_km.addTextChangedListener(KmTextWatcher);
                txt_in.addTextChangedListener(InTextWatcher);
                txt_ft1.addTextChangedListener(FeetTextWatcher);
                txt_y.addTextChangedListener(YardTextWatcher);
            }
        });
        txt_km.addTextChangedListener(KmTextWatcher);
        txt_in.addTextChangedListener(InTextWatcher);
        txt_ft1.addTextChangedListener(FeetTextWatcher);
        txt_y.addTextChangedListener(YardTextWatcher);
    }


    TextWatcher MtrTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_km.removeTextChangedListener(KmTextWatcher);
            txt_in.removeTextChangedListener(InTextWatcher);
            txt_ft1.removeTextChangedListener(FeetTextWatcher);
            txt_y.removeTextChangedListener(YardTextWatcher);
            convertMtr();
            txt_km.addTextChangedListener(KmTextWatcher);
            txt_in.addTextChangedListener(InTextWatcher);
            txt_ft1.addTextChangedListener(FeetTextWatcher);
            txt_y.addTextChangedListener(YardTextWatcher);
        }
    };


    TextWatcher KmTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_mt.removeTextChangedListener(MtrTextWatcher);
            txt_in.removeTextChangedListener(InTextWatcher);
            txt_ft1.removeTextChangedListener(FeetTextWatcher);
            txt_y.removeTextChangedListener(YardTextWatcher);
            convertKm();
            txt_mt.addTextChangedListener(MtrTextWatcher);
            txt_in.addTextChangedListener(InTextWatcher);
            txt_ft1.addTextChangedListener(FeetTextWatcher);
            txt_y.addTextChangedListener(YardTextWatcher);
        }
    };

    TextWatcher InTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_mt.removeTextChangedListener(MtrTextWatcher);
            txt_km.removeTextChangedListener(KmTextWatcher);
            txt_ft1.removeTextChangedListener(FeetTextWatcher);
            txt_y.removeTextChangedListener(YardTextWatcher);
            convertIn();
            txt_mt.addTextChangedListener(MtrTextWatcher);
            txt_km.addTextChangedListener(KmTextWatcher);
            txt_ft1.addTextChangedListener(FeetTextWatcher);
            txt_y.addTextChangedListener(YardTextWatcher);
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
            txt_mt.removeTextChangedListener(MtrTextWatcher);
            txt_km.removeTextChangedListener(KmTextWatcher);
            txt_in.removeTextChangedListener(InTextWatcher);
            txt_y.removeTextChangedListener(YardTextWatcher);
            convertFeet();
            txt_mt.addTextChangedListener(MtrTextWatcher);
            txt_km.addTextChangedListener(KmTextWatcher);
            txt_in.addTextChangedListener(InTextWatcher);
            txt_y.addTextChangedListener(YardTextWatcher);
        }
    };

    TextWatcher YardTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt_mt.removeTextChangedListener(MtrTextWatcher);
            txt_km.removeTextChangedListener(KmTextWatcher);
            txt_in.removeTextChangedListener(InTextWatcher);
            txt_ft1.removeTextChangedListener(FeetTextWatcher);
            convertYard();
            txt_mt.addTextChangedListener(MtrTextWatcher);
            txt_km.addTextChangedListener(KmTextWatcher);
            txt_in.addTextChangedListener(InTextWatcher);
            txt_ft1.addTextChangedListener(FeetTextWatcher);
        }
    };



    void convertMtr(){
        String mtrString = txt_mt.getText().toString();
        if(!mtrString.isEmpty() && !mtrString.endsWith("m")){
            double mtr = Double.parseDouble(mtrString);
            double km = mtr /1000;
            txt_km.setText(String.format("%.2f km",km));
            double in = mtr /0.0254;
            txt_in.setText(String.format("%.2f in",in));
            double ft = mtr /0.3048;
            txt_ft1.setText(String.format("%.2f ft",ft));
            double yard = mtr /0.9144;
            txt_y.setText(String.format("%.2f y",yard));
        }
    }
    void  convertKm() {
        String kmString = txt_km.getText().toString();
        if (!kmString.isEmpty() && !kmString.endsWith("km")) {
            double km = Double.parseDouble(kmString);
            double mtr = km * 1000;
            txt_mt.setText(String.format("%.2f m", mtr));
            double in = km * 39370.1;
            txt_in.setText(String.format("%.2f in", in));
            double ft = km * 3280.84;
            txt_ft1.setText(String.format("%.2f ft", ft));
            double yard = km * 1093.61;
            txt_y.setText(String.format("%.2f y", yard));
        }
    }
    void  convertIn() {
        String inString = txt_in.getText().toString();
        if (!inString.isEmpty() && !inString.endsWith("in")) {
            double in = Double.parseDouble(inString);
            double mtr = in * 0.0254;
            txt_mt.setText(String.format("%.2f m", mtr));
            double km = in * 0.0000254;
            txt_km.setText(String.format("%.2f km", km));
            double ft = in * 0.083333;
            txt_ft1.setText(String.format("%.2f ft", ft));
            double yard = in * 0.027778;
            txt_y.setText(String.format("%.2f y", yard));
        }
    }
    void convertFeet(){
        String ftString = txt_ft1.getText().toString();
        if (!ftString.isEmpty() && !ftString.endsWith("ft")) {
            double ft = Double.parseDouble(ftString);
            double mtr = ft * 0.3048;
            txt_mt.setText(String.format("%.2f m", mtr));
            double km = ft * 0.0003048;
            txt_km.setText(String.format("%.2f km", km));
            double in = ft * 12;
            txt_in.setText(String.format("%.2f in", in));
            double yard = ft / 3;
            txt_y.setText(String.format("%.2f y", yard));
        }
    }
    void convertYard(){
        String yardString = txt_y.getText().toString();
        if (!yardString.isEmpty() && !yardString.endsWith("y")) {
            double yard = Double.parseDouble(yardString);
            double mtr = yard * 0.9144;
            txt_mt.setText(String.format("%.2f m", mtr));
            double km = yard / 1093.61;
            txt_km.setText(String.format("%.2f km", km));
            double in = yard * 36;
            txt_in.setText(String.format("%.2f in", in));
            double ft = yard * 3;
            txt_ft1.setText(String.format("%.2f ft", ft));
        }
    }
}
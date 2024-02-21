package com.asgar72.unitconverter.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.asgar72.unitconverter.R;

import java.util.ArrayList;
import java.util.HashSet;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ListView listView = findViewById(R.id.listView);


        // Get the list of calculations from intent extras
        // ArrayList<String> calculations = getIntent().getStringArrayListExtra("calculations");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ArrayList<String> calculations = new ArrayList<>(sharedPreferences.getStringSet("calculations", new HashSet<>()));

        // Check if calculations ArrayList is received correctly
        if (calculations != null) {
            Log.d("HistoryActivity", "Calculations received: " + calculations.toString());
        } else {
            Log.d("HistoryActivity", "Calculations ArrayList is null");
        }


        // Display calculations in ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, calculations);
        listView.setAdapter(adapter);
    }
}

package com.example.nicklin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "Translation";
    public String choice = "";
    private LinearLayout contentView;
    String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = getResources().getStringArray(R.array.Languages);

        contentView = findViewById(R.id.landingPage);

        TextView title = findViewById(R.id.appTitle);
        title.animate().translationYBy(-300).setDuration(3000).start();
        contentView.animate().alphaBy(100).setDuration(10000).start();

        Spinner spinner = findViewById(R.id.spinner3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    default:
                        //start activity on selection of any item you want, here I am assuming first item.
                        Intent intent = new Intent(MainActivity.this, Camira.class);
                        choice = spinner.getSelectedItem().toString();
                        intent.putExtra("LANG", choice);
                        Log.e(TAG, "made it");
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}

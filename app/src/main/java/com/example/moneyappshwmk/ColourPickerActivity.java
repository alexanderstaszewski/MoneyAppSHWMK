package com.example.moneyappshwmk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ColourPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_picker);
    }


    // I will just use onclick for the back buttons since it gets the job done fast
    public void onBackClick(View view) {
        finish();
    }
}

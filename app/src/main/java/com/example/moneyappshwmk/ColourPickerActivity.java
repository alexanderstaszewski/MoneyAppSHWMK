package com.example.moneyappshwmk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ColourPickerActivity extends AppCompatActivity {

    SharedPreferences prefs;
    ImageButton backButton;

    //Create an arraylist to store the buttons so that if the user changes colours we can access these easily
    ArrayList<ImageButton> buttons = new ArrayList<ImageButton>();
    //Create another arraylist to store the drawables for the buttons
    ArrayList<Integer> drawables = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_picker);

        prefs = getApplicationContext().getSharedPreferences(
                "com.example.moneyappshwmk", 0);
        SharedPreferences.Editor editor = prefs.edit();

        backButton = (ImageButton) findViewById(R.id.buttonBack);

        //add the back button and drawable into the arraylists
        buttons.add(backButton);
        drawables.add(R.drawable.button_back_shape);

        for (int i = 0; i < buttons.size(); i++)
        {
            ImageButton button = buttons.get(i);

            LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(this, drawables.get(i));
            button.setBackground(layerDrawable);

            GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.background_item);

            gradientDrawable.setColor(prefs.getInt("button_color",-1));


        }
    }


    // I will just use onclick for the back buttons since it gets the job done fast
    public void onBackClick(View view) {

        finish();
    }
}

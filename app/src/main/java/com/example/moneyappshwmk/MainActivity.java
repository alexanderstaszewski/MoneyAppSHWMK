package com.example.moneyappshwmk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getApplicationContext().getSharedPreferences(
                "com.example.moneyappshwmk", 0);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("button_color", getResources().getColor(R.color.colorAccent)); // Storing integer
        editor.commit();



//        //getWindow().getDecorView().setBackgroundColor(prefs.getInt("button_color",-1));
//        ImageButton button = (ImageButton) findViewById(R.id.buttonBalance);
//        LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.button_speaker_shape);
//        button.setBackground(layerDrawable);
//
//        GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.background_item);
//
//        gradientDrawable.setColor(prefs.getInt("button_color",-1));
    }


    //Add items to the action bar from res/menu/menu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Function that listens to whenever an icon is pressed on the app bar, so we don't need to use onClick
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.colourSettings:
                //Get the colour picker activity, so we can edit the colours of the buttons
                Intent colourPickerIntent = new Intent(this, ColourPickerActivity.class);
                //Set a flag to clear the activity stack (you cannot go back to this using the back button then)
                colourPickerIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                //Start the colour picker activity
                startActivity(colourPickerIntent);

                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}

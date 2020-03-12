package com.example.moneyappshwmk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorListener;

import java.util.ArrayList;

public class ColourPickerActivity extends AppCompatActivity {

    SharedPreferences prefs;
    ImageButton backButton;
    ImageButton undoButton;
    ColorPickerView colorPickerView;
    Integer buttonColour;
    ChangeColour changeColour = new ChangeColour();
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
        undoButton = (ImageButton) findViewById(R.id.buttonUndo);
        colorPickerView = (ColorPickerView) findViewById(R.id.colorPickerView);

        //If no colour has been chosen then make the colour picker go to the default button colour
        //Otherwise make the colour picker go to the last colour
        buttonColour = prefs.getInt("button_color",-1);

        if (buttonColour == -1)
        {
            editor.putInt("lastColour", R.color.colorButton);
            editor.commit();
        }
        else
        {
            editor.putInt("lastColour", buttonColour);
            editor.commit();
        }

        //add the back button and drawable into the arraylists
        buttons.add(backButton);
        buttons.add(undoButton);
        drawables.add(R.drawable.button_back_shape);
        drawables.add(R.drawable.button_undo_shape);

        changeColour.setButtons(buttons);
        changeColour.setDrawables(drawables);
        changeColour.changeColours(this, prefs.getInt("button_color",-1));

        //Listener to check when the user presses on the colour wheel
        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(int color, boolean fromUser) {

                prefs = getApplicationContext().getSharedPreferences(
                        "com.example.moneyappshwmk", 0);
                SharedPreferences.Editor editor = prefs.edit();

                //change the button colours in real time
                changeColour.changeColours(getApplicationContext(), color);
                //and then save the colour so that the rest of the buttons throughout the app change
                editor.putInt("button_color", color);
                editor.commit();
            }
        });

    }

    @Override
    protected void onResume()
    {
        super.onResume();

        //Change the colours when switching through activities if necessary
        changeColour.setButtons(buttons);
        changeColour.setDrawables(drawables);
        changeColour.changeColours(this, prefs.getInt("button_color",-1));
    }


    // I will just use onclick for the back buttons since it gets the job done fast
    public void onBackClick(View view) {

        finish();
    }
}

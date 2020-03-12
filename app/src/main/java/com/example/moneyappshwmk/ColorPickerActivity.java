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
import android.widget.Toast;

import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.listeners.ColorListener;
import com.skydoves.colorpickerview.preference.ColorPickerPreferenceManager;

import java.util.ArrayList;

public class ColorPickerActivity extends AppCompatActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    ImageButton backButton;
    ImageButton undoButton;
    ColorPickerView colorPickerView;
    Integer buttonColor;
    Integer defaultButtonColor;
    ChangeColor changeColor = new ChangeColor();
    //Create an arraylist to store the buttons so that if the user changes colors we can access these easily
    ArrayList<ImageButton> buttons = new ArrayList<ImageButton>();
    //Create another arraylist to store the drawables for the buttons
    ArrayList<Integer> drawables = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        prefs = getApplicationContext().getSharedPreferences(
                "com.example.moneyappshwmk", 0);
        editor = prefs.edit();


        backButton = (ImageButton) findViewById(R.id.buttonBack);
        undoButton = (ImageButton) findViewById(R.id.buttonUndo);
        colorPickerView = (ColorPickerView) findViewById(R.id.colorPickerView);

        //If no color has been chosen then make the color picker go to the default button color
        //Otherwise make the color picker go to the last color
        buttonColor = prefs.getInt("button_color",-1);
        defaultButtonColor = getResources().getColor(R.color.colorButton);

        if (buttonColor == -1)
        {
            editor.putInt("lastColor", R.color.colorButton);
            editor.commit();
        }
        else
        {
            editor.putInt("lastColor", buttonColor);
            editor.commit();
        }

        //add the back button and drawable into the arraylists
        buttons.add(backButton);
        buttons.add(undoButton);
        drawables.add(R.drawable.button_back_shape);
        drawables.add(R.drawable.button_undo_shape);

        changeColor.setButtons(buttons);
        changeColor.setDrawables(drawables);
        changeColor.changeColors(this, prefs.getInt("button_color",-1));

        //Listener to check when the user presses on the color wheel
        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(int color, boolean fromUser) {

                //change the button colors in real time
                changeColor.changeColors(getApplicationContext(), color);
                //and then save the color so that the rest of the buttons throughout the app change
                editor.putInt("button_color", color);
                editor.commit();
            }
        });

        //This will trigger when the undo button is pressed
        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //change the button colors in real time
                changeColor.changeColors(getApplicationContext(), defaultButtonColor);
                //Toast.makeText(getApplicationContext(), Integer.toString(R.color.colorButton), Toast.LENGTH_SHORT).show();
                //and then save the colour so that the rest of the buttons throughout the app change
                editor.putInt("button_color", defaultButtonColor);
                editor.commit();
            }
        });

    }

    @Override
    protected void onResume()
    {
        super.onResume();

        //Change the colors when switching through activities if necessary
        changeColor.setButtons(buttons);
        changeColor.setDrawables(drawables);
        changeColor.changeColors(this, prefs.getInt("button_color",-1));
    }


    // I will just use onclick for the back buttons since it gets the job done fast
    public void onBackClick(View view) {

        finish();
    }
}

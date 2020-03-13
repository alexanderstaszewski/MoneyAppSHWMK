package com.example.moneyappshwmk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    ImageButton balanceButton, walletButton, cameraButton, transactionButton;
    ChangeColor changeColor = new ChangeColor();

    //Create an arraylist to store the buttons so that if the user changes colors we can access these easily
    ArrayList<ImageButton> buttons = new ArrayList<ImageButton>();
    //Create another arraylist to store the drawables for the buttons
    ArrayList<Integer> drawables = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        balanceButton = (ImageButton) findViewById(R.id.buttonBalance);
        walletButton = (ImageButton) findViewById(R.id.buttonWallet);
        cameraButton = (ImageButton) findViewById(R.id.buttonCamera);
        transactionButton = (ImageButton) findViewById(R.id.buttonTransaction);

        prefs = getApplicationContext().getSharedPreferences(
                "com.example.moneyappshwmk", 0);
        SharedPreferences.Editor editor = prefs.edit();

        //Put all the buttons into the arraylist
        List<ImageButton> tempButtons = Arrays.asList(balanceButton, walletButton, cameraButton, transactionButton);
        buttons.addAll(tempButtons);

        //Put all the drawables for the icons into an arraylist
        List<Integer> tempDrawables = Arrays.asList(R.drawable.button_speaker_shape, R.drawable.button_wallet_shape, R.drawable.button_camera_shape, R.drawable.button_transaction_shape);
        drawables.addAll(tempDrawables);

        //getWindow().getDecorView().setBackgroundColor(prefs.getInt("button_color",-1));
        changeColor.setButtons(buttons);
        changeColor.setDrawables(drawables);
        changeColor.changeColors(this, prefs.getInt("button_color",-1));

    }


    //Add items to the action bar from res/menu/menu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    //Function that listens to whenever an icon is pressed on the app bar, so we don't need to use onClick
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.colorSettings:
                //Get the color picker activity, so we can edit the colors of the buttons
                Intent colorPickerIntent = new Intent(this, ColorPickerActivity.class);
                //Set a flag to clear the activity stack (you cannot go back to this using the back button then)
                colorPickerIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                //Start the color picker activity
                startActivity(colorPickerIntent);

                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}

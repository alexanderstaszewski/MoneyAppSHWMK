package com.example.moneyappshwmk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Add items to the action bar from res/menu/menu_main.xml
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Function that listens to whenever an icon is pressed on the app bar, so we don't need to use onClick
    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        switch (mi.getItemId()) {
            case R.id.colourSettings:
                //Get the colour picker activity, so we can edit the colours of the buttons
                Intent colourPickerIntent = new Intent(this, ColourPickerActivity.class);
                //Set a flag to clear the activity stack (you cannot go back to this using the back button then)
                colourPickerIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                //Start the colour picker activity
                startActivity(colourPickerIntent);

                return true;

            default:
                return super.onOptionsItemSelected(mi);
        }
    }
}

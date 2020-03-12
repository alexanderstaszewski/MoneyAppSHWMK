package com.example.moneyappshwmk;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageButton;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ChangeColour {

    public ArrayList<ImageButton> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<ImageButton> buttons) {
        this.buttons = buttons;
    }

    public ArrayList<Integer> getDrawables() {
        return drawables;
    }

    public void setDrawables(ArrayList<Integer> drawables) {
        this.drawables = drawables;
    }

    private ArrayList<ImageButton> buttons = new ArrayList<ImageButton>();
    private ArrayList<Integer> drawables = new ArrayList<Integer>();

    public void changeColours(Context context, Integer buttonColour)
    {
        //If the user has not chosen a colour yet then buttonColour should be -1, if we don't check this it will become white by default
        if (buttonColour != -1)
        {
            for (int i = 0; i < buttons.size(); i++)
            {
                ImageButton button = buttons.get(i);

                LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(context, drawables.get(i));
                button.setBackground(layerDrawable);

                GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.background_item);

                gradientDrawable.setColor(buttonColour);
            }
        }


        return;
    }
}

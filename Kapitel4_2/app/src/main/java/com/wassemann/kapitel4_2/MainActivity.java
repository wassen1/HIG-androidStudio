package com.wassemann.kapitel4_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final int FOOD_ID = 1;
    private final int DAYS_ID = 2;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    };

    public void chooseDay(View caller){
        String instruction = "Please select your favourite day of week from the list below:";
        String buttonText = "Oki doki";
        String[] array = {"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag"};
        Intent intent = new Intent(this, ChooserActivity.class);
        intent.putExtra(ChooserActivity.PARAM_INSTRUCTION, instruction);
        intent.putExtra(ChooserActivity.PARAM_CHOICES, array);
        intent.putExtra(ChooserActivity.PARAM_BTN_TEXT, buttonText);
        startActivityForResult(intent, DAYS_ID);
    };

    public void chooseFood(View caller) {
        String instruction = "Please select your favourite food from the list below:";
        String buttonText = "Done";
        String[] array = {"Pizza", "Lasagne", "Bolognese", "Cyrrygryta", "Plankstek"};
        Intent intent = new Intent(this, ChooserActivity.class);
        intent.putExtra(ChooserActivity.PARAM_INSTRUCTION, instruction);
        intent.putExtra(ChooserActivity.PARAM_CHOICES, array);
        intent.putExtra(ChooserActivity.PARAM_BTN_TEXT, buttonText);
        startActivityForResult(intent, FOOD_ID);
    };

    public void quit(View caller) {
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String result = data.getStringExtra(ChooserActivity.RETURN_VALUE);
            TextView textView = null;
            if (requestCode == DAYS_ID) {
                textView = (TextView) this.findViewById(R.id.textViewDay);
            }
            else if (requestCode == FOOD_ID) {
                textView = (TextView) this.findViewById(R.id.textViewFood);
            }
            if (textView != null) {
                textView.setText("" + result);
            }
        }
    }


};

package com.wassemann.javainterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Layout
        RelativeLayout bossesLayout = new RelativeLayout(this);
        bossesLayout.setBackgroundColor(Color.GREEN);

        //Button
        Button redButton = new Button(this);
        redButton.setText("Click here!");
        redButton.setBackgroundColor(Color.RED);

        //Currency in
        EditText currencyIn = new EditText(this);

        redButton.setId(1);
        currencyIn.setId(2);


        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams (
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams currencyInDetails = new RelativeLayout.LayoutParams (
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Give rules to position widget
        currencyInDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        currencyInDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        currencyInDetails.setMargins(0, 0, 0, 50);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);



        //Add widget to layout ( button is now a child of layout)
        bossesLayout.addView(redButton, buttonDetails);
        bossesLayout.addView(currencyIn, currencyInDetails);

        //Set this activities content/display to this view
        setContentView(bossesLayout);

    }
}

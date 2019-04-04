package com.wassemann.kapitel5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * Sets the content on the first page
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Sets up an activity that presents a pattern
     *
     * @param caller
     */
    public void SimpleDrawActivity(View caller) {
        this.startActivity(new Intent(this, com.wassemann.kapitel5.SimpleDrawActivity.class));
    }

    /**
     * Sets up an activity that presents a dot upon touch
     *
     * @param caller
     */
    public void InteractionActivity(View caller) {
        this.startActivity(new Intent(this, com.wassemann.kapitel5.InteractionActivity.class));
    }

    /**
     * Sets up an activity that presents many moving dots with text upon touch
     *
     * @param caller
     */
    public void AnimationActivity(View caller) {
        this.startActivity(new Intent(this, com.wassemann.kapitel5.AnimationActivity.class));
    }

}

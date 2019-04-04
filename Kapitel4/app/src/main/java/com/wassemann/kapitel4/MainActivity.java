package com.wassemann.kapitel4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void quit (View caller)
    {
        finish();
    }

    public void firstActivity (View caller)
    {
        this.startActivity(new Intent(this, com.wassemann.kapitel4.FirstActivity.class));
    }

    public void secondActivity(View caller)
    {
        this.startActivity(new Intent(this, com.wassemann.kapitel4.SecondActivity.class));
    }
}


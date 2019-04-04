package com.wassemann.kapitel4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by wassen on 2017-11-17.
 */

public class SecondActivity extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }
    public void quit(View caller)
    {
        finish();
    }

};

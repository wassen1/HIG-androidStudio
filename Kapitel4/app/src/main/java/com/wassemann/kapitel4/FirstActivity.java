package com.wassemann.kapitel4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by wassen on 2017-11-18.
 */

public class FirstActivity extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

    }
    public void quit(View caller)
    {
        finish();
    }
}

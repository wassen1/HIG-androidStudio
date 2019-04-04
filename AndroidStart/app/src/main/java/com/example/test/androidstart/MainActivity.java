package com.example.test.androidstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println(getResources().getResourceName(R.id.button));


        setContentView(R.layout.activity_main);
    }
}

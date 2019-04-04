package com.wassemann.api_canvas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inId = (EditText) findViewById(R.id.editTextUserId);
                EditText inToken = (EditText) findViewById(R.id.editTextToken);

                //get value from text edit
                int userId = Integer.parseInt(inId.getText().toString());

                String accessToken = inToken.getText().toString();

                Intent intent = new Intent(v.getContext(), ResultActivity.class);
                intent.putExtra(ResultActivity.USER_ID, userId);
                intent.putExtra(ResultActivity.ACCESS_TOKEN, accessToken);
                startActivity(intent);

            }
        });
    }
}


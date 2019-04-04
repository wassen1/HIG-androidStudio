package com.wassemann.kapitel4_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;



public class ChooserActivity extends Activity {
    public static final String PARAM_INSTRUCTION = "instr";
    public static final String PARAM_CHOICES = "choices";
    public static final String PARAM_BTN_TEXT = "btnText";
    public static final String RETURN_VALUE = "return";
    private ArrayAdapter<String> adapter;
    private Spinner spinner;
    private String selectedString = "";

    private static final String TAG;

    static {
        TAG = "MyTag";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);



        //Set text in textViewChoose
        TextView txt = (TextView) findViewById(R.id.textViewChoose);
        String instruction = this.getIntent().getStringExtra(PARAM_INSTRUCTION);
        if (instruction != null) {
            txt.setText(instruction);
        }

        //Set text at button
        Button btn = (Button) findViewById(R.id.button);
        String btnText = this.getIntent().getStringExtra(PARAM_BTN_TEXT);
        if (btnText != null) {
            btn.setText(btnText);
        }

        String[] array = this.getIntent().getStringArrayExtra(PARAM_CHOICES);
        if (array != null) {
            setUpTheSpinner(array);
        }
        Log.v(TAG, "Now the chooser activity has been created !");
    }

    private void setUpTheSpinner(String[] array) {
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, array);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                selectedString = spinner.getSelectedItem().toString();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {}

            });


        }
    public void quit(View caller) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(RETURN_VALUE, selectedString);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}



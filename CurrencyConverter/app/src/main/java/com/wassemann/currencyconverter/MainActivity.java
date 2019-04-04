package com.wassemann.currencyconverter;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity {

    private String[] array;
    private ArrayAdapter<CharSequence> adapter;
    private Spinner spinnerFrom, spinnerTo;
    private TextView editTextCurrencyIn;
    private TextView endResult;

    private static final String TAG;

    static {
        TAG = "MyTag";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpTheSpinners();

        Log.v(TAG, "Now the activity has been created !");
    }


    private void setUpTheSpinners() {
        array = getResources().getStringArray(R.array.currencyArray);

        //arrayadapter
        adapter = new ArrayAdapter<CharSequence>(this, R.layout.support_simple_spinner_dropdown_item, array);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //declaration and assignment of array listener
        AdapterView.OnItemSelectedListener spinnerListener = new SpinnerListener();

        //declaration and assignment of text Listener
        TextWatcher textListener = new MyTextWatcher();

        //from spinner
        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        spinnerFrom.setAdapter(adapter);
        spinnerFrom.setOnItemSelectedListener(spinnerListener);

        //to spinner
        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        spinnerTo.setAdapter(adapter);
        spinnerTo.setOnItemSelectedListener(spinnerListener);

        //edit text
        editTextCurrencyIn = (TextView) findViewById(R.id.editTextCurrencyIn);
        editTextCurrencyIn.addTextChangedListener(textListener);

    }

    private void convertCurrencies() {
        try {
            //populate currency array
            String[] currency = getResources().getStringArray(R.array.currencyRateArray);


            //get selected index in spinners
            int index1 = spinnerFrom.getSelectedItemPosition();
            int index2 = spinnerTo.getSelectedItemPosition();

            //get corresponding currency value
            double cur1 = Double.parseDouble(currency[index1]);
            double cur2 = Double.parseDouble(currency[index2]);

            //get value from text edit
            double inText = Double.parseDouble(editTextCurrencyIn.getText().toString());


            //the result
            double result = inText * cur1 / cur2;
            String formResult = String.format("%.2f", result);

            //set the result value on textview
            endResult = (TextView) findViewById(R.id.textViewResult);
            if ((cur1 > 0) && (cur2 > 0)) {
                endResult.setText(formResult);
            }


        } catch (Exception e) {
            Log.v(TAG, "exception!" + e);
        }

    }

    private class SpinnerListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            convertCurrencies();
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class MyTextWatcher implements TextWatcher {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().isEmpty()) {
                endResult.setText("");
            }
            convertCurrencies();
        }

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    }
}

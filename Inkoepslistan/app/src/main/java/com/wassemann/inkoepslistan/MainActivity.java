package com.wassemann.inkoepslistan;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private String[] array;
    private ArrayList<String> resultArray = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private Spinner itemSpinner;
    private TextView endResult;
    private Button adderButton;
    private Button removerButton;
    private EditText editSpinnerItem;
    String itemArray = null;



    private static final String TAG;

    static {
        TAG = "MyTag";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setUpTheSpinner();
        setUpTheButtons();
        Log.v(TAG, "Now the activity has been created !");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putStringArrayList("savedResultArray",resultArray);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        resultArray = savedInstanceState.getStringArrayList("savedResultArray");

        showItems();

    }
    private void setUpTheButtons() {
        //locate the add button in xml
        adderButton = (Button) findViewById(R.id.adderButton);

        //locate the remove button in xml
        removerButton = (Button) findViewById(R.id.removerButton);


        //listen to clicks add button
        adderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItems();
            }
        });

        //listen to clicks remove button
        removerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeItems();
            }
        });

        //locate the edit spinner text
        editSpinnerItem = (EditText) findViewById(R.id.adderEdit);

        editSpinnerItem.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                setUpTheSpinner();
            }

        });

    }
    private void setUpTheSpinner() {
        array = getResources().getStringArray(R.array.itemSpinner);
        int length = array.length;
        //array[length - 1] = "test";

        array[length - 1] = "test";

        //init arrayadapter
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, array);

        //sets design on dropdown
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);


        //identifies the spinner
        itemSpinner = (Spinner) findViewById(R.id.itemSpinner);
        //sets the adapter
        itemSpinner.setAdapter(adapter);



    }

    private void showItems() {
        try {

            //present text in listItemTextView
            endResult = (TextView) findViewById(R.id.listItemsTextView);
            endResult.setText(null);
            for (int i = 0; i < resultArray.size(); i ++) {
                endResult.append(resultArray.get(i));
                endResult.append("\n");
            }

        } catch (Exception e) {
            Log.v(TAG, "exception! In showItems" + e);
        }
    }

public void addItemtoArray() {

}

    private void addItems() {
        try {
            //populate temporary array
            array = getResources().getStringArray(R.array.itemSpinner);

            int index = itemSpinner.getSelectedItemPosition();

            //get value from spinner
            itemArray = array[index];

            //add value from spinner to array
            resultArray.add(itemArray);

            //present text in listItemTextView
            endResult = (TextView) findViewById(R.id.listItemsTextView);
            endResult.setText(null);
            for (int i = 0; i < resultArray.size(); i ++) {
                endResult.append(resultArray.get(i));
                endResult.append("\n");
            }

        } catch (Exception e) {
            Log.v(TAG, "exception!" + e);
        }
    }

    private void removeItems() {
        try {
            //populate temporary array
            array = getResources().getStringArray(R.array.itemSpinner);

            int index1 = itemSpinner.getSelectedItemPosition();

            //get value from spinner
            itemArray = array[index1];

            //add value from spinner to array
            resultArray.remove(itemArray);

            //present text in listItemTextView
            endResult = (TextView) findViewById(R.id.listItemsTextView);
            endResult.setText(null);
            for (int i = 0; i < resultArray.size(); i ++) {
                endResult.append(resultArray.get(i));
                endResult.append("\n");
            }

        } catch (Exception e) {
            Log.v(TAG, "exception!" + e);
        }
    }
}

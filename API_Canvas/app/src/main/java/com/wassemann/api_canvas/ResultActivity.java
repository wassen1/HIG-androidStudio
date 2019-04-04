package com.wassemann.api_canvas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends Activity {

    private static final String TAG = ResultActivity.class.getName();

    public static final String USER_ID = "<USER-ID>";
    public static final String ACCESS_TOKEN = "<ACCESS-TOKEN>";

    private RequestQueue queue;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        queue = Volley.newRequestQueue(this);
        textView = (TextView) findViewById(R.id.result);
        sendRequestAndPrintResponse();


        List<Map<String, String>> contactList = new ArrayList<>();
        contactList.add(makeContact("Kalle", "Persson"));
        contactList.add(makeContact("Anna", "Larsson"));
    }

    private Map<String,String> makeContact(String firstname, String lastname) {
        Map<String,String> map = new HashMap<>();
        map.put("firstname",firstname);
        map.put("lastname",lastname);
        return map;
    }

    private void sendRequestAndPrintResponse() {
        Bundle extras = getIntent().getExtras();
        int id = extras.getInt(USER_ID);
        String token = extras.getString(ACCESS_TOKEN);
        String url = "https://ltu.instructure.com/api/v1/courses/" + id + "/users?access_token=" + token;

        Log.i(TAG, url);

        queue.add(new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.i(TAG, "Response : " + response.toString());
                textView.setText(response);
               /* try {
                    JSONObject person = new JSONObject(response);
                    String id = person.getString("id");
                    String name = person.getString("name");
                } catch (JSONException e) {
                    textView.setText("parsing didnt work");
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Log.i(TAG, " Error : " + error.toString());
                textView.setText("That didn't work!");
            }
        }));

    }


    @Override
    protected void onStop() {
        super.onStop();
        //mRequestQue.cancelAll("");
        queue.stop();
    }

    public void quit(View caller) {
        finish();
    }
}

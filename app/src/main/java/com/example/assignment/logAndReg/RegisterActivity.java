package com.example.assignment.logAndReg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.assignment.R;
import com.example.assignment.Utilities.AppController;
import com.example.assignment.networks.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    ConnectivityManager conMgr;
    ProgressDialog pDialog;
    int success;
    private String url = Server.URL + "register.php";

    private TextView loginInstead;
    private EditText nameR,unameR,emailR,passR;
    private Button signUp;

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private static final String TAG = RegisterActivity.class.getSimpleName();

    String tag_json_obj = "json_obj_reg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                      && conMgr.getActiveNetworkInfo().isAvailable()
                      && conMgr.getActiveNetworkInfo().isConnected()){
            }
            else {
                Toast.makeText(getApplicationContext(), "No Network Connection!", Toast.LENGTH_SHORT).show();
            }

            loginInstead = (TextView) findViewById(R.id.tvAlready);
            nameR = (EditText) findViewById(R.id.textName);
            unameR = (EditText) findViewById(R.id.textUname);
            emailR = (EditText) findViewById(R.id.textEmail);
            passR = (EditText) findViewById(R.id.textPassword);
            signUp = (Button) findViewById(R.id.btnSignUpOk);


            ImplementAll();

        }
    }

    private void ImplementAll() {

        loginInstead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIn = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIn);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String name = nameR.getText().toString();
                String uname = unameR.getText().toString();
                String email = emailR.getText().toString();
                String password = passR.getText().toString();

                if (conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected()){

                    checkRegister(name,uname,email,password);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Network Connection!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkRegister(final String name, final String uname, final String email, final String password) {

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    //check for error in JSON
                    if (success == 1) {
                        Log.e("Sucessfully Register!", jObj.toString());

                        Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_SHORT).show();

                        nameR.setText("");
                        unameR.setText("");
                        emailR.setText("");
                        passR.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    //JSON ERROR
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                hideDialog();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                // Posting parameters to url
                Map<String, String> params = new HashMap<String, String>();

                params.put("username", uname);
                params.put("name",name);
                params.put("email", email);
                params.put("password", password);


                return params;
            }
        };

        //adding request to queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void hideDialog() {
        if (pDialog.isShowing()){
            pDialog.dismiss();
        }
    }

    private void showDialog() {
        if (pDialog.isShowing()){
            pDialog.show();
        }
    }
}

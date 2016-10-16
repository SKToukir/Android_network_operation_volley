package com.example.toukir.networkoperation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LogInActivity extends AppCompatActivity {

    public static final String LOGIN_URL = "http://192.168.43.7/OnlineNoticeSystem/stdLogin.php";
    EditText name,pass;
    public static final String KEY_USERNAME = "name";
    public static final String KEY_PASSWORD = "password";
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView txtLink2 = (TextView) findViewById(R.id.linkTxt2);
        name = (EditText) findViewById(R.id.etLogInName);
        pass = (EditText) findViewById(R.id.etLogInPass);

        txtLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void btnLogIn(View view) {

        final String userName = name.getText().toString().trim();
        final String userPass = pass.getText().toString().trim();

        if (userName.isEmpty() && userPass.isEmpty()){
            Toast.makeText(LogInActivity.this,"Fill all the field!",Toast.LENGTH_LONG).show();
        }else {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    key=response.trim();
                    if (key.equalsIgnoreCase("y")){

                            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                            startActivity(intent);

                    }else {
                        Toast.makeText(getApplicationContext(),"Invalid user name or password!",Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();
                    params.put(KEY_USERNAME,userName);
                    params.put(KEY_PASSWORD,userPass);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
    }
}

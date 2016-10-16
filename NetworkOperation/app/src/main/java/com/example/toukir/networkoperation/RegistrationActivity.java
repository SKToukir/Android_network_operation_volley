package com.example.toukir.networkoperation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    public static final String REGISTER_URL = "http://192.168.43.7/OnlineNoticeSystem/register.php";
    public static final String KEY_USERNAME = "name";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";

    private TextView txtLink;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txtLink = (TextView) findViewById(R.id.linkTxt);
        editTextUsername = (EditText) findViewById(R.id.etName);
        editTextPassword = (EditText) findViewById(R.id.etPass);
        editTextEmail= (EditText) findViewById(R.id.etEmail);

        txtLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this,LogInActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Register(View view) {

        final String userName = editTextUsername.getText().toString().trim();
        final String userPassword = editTextPassword.getText().toString().trim();
        final String userEmail = editTextEmail.getText().toString().trim();

        if (userName.isEmpty() && userPassword.isEmpty() && userEmail.isEmpty()){
            Toast.makeText(RegistrationActivity.this,"Fill all the field!",Toast.LENGTH_LONG).show();
        }else {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(RegistrationActivity.this,response,Toast.LENGTH_LONG).show();
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
                    params.put(KEY_EMAIL,userEmail);
                    params.put(KEY_PASSWORD,userPassword);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

            finish();
        }

    }
}

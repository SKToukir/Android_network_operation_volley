package com.example.toukir.networkoperation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void btnLogIn(View view) {
        Intent intent = new Intent(HomeActivity.this,LogInActivity.class);
        startActivity(intent);
    }

    public void Register(View view) {
        Intent intent = new Intent(HomeActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }
}

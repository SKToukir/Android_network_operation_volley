package com.example.toukir.networkoperation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String deatil = intent.getStringExtra("detail");
        String date = intent.getStringExtra("date");

        TextView txtDate = (TextView) findViewById(R.id.txtdate);
        TextView txtTitle = (TextView) findViewById(R.id.textView);
        TextView txtDetails = (TextView) findViewById(R.id.textView2);

        txtTitle.setText(title);
        txtDetails.setText(deatil);
        txtDate.setText(date);

    }
}

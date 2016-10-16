package com.best.hp_.udacitysunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GetNameActivity extends AppCompatActivity {

    EditText txtName;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);

        txtName = (EditText) findViewById(R.id.txtGetname);
    }

    public void PlayButton(View view) {
        ScoreBoard scoreBoard = new ScoreBoard();
        name = txtName.getText().toString();
        scoreBoard.setPlayerName(name);
        Intent intent = new Intent(GetNameActivity.this, MainActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}

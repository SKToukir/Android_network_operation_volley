package com.example.toukir.networkoperation;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String login_url = "http://192.168.43.7/OnlineNoticeSystem/getJsonData.php";
    NoticeItems noticeItems;
    ListView itemList;
    CustomAdapter adapter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            Log.d("STATE",savedInstanceState.toString());
        }

        new HomeActivity().finish();
        FloatingActionButton fb = (FloatingActionButton) findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRestart();
            }
        });
        adapter = new CustomAdapter(MainActivity.this,R.layout.row);
        itemList = (ListView) findViewById(R.id.listItems);
        requestQueue = Volley.newRequestQueue(this);

        itemList.setAdapter(adapter);
        itemList.setOnItemClickListener(this);

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, login_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray ja = response.getJSONArray("server_response");
                    for (int i = 0; i<ja.length();i++){
                        JSONObject jsonObject = ja.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String details = jsonObject.getString("details");
                        String date = jsonObject.getString("date");

                        noticeItems=new NoticeItems(title,details,date);
                        adapter.add(noticeItems);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley","Error");
            }
        });
        requestQueue.add(jor);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        NoticeItems items = (NoticeItems) adapter.getItem(position);
        String title = items.getTitle();
        String details = items.getDetails();
        String date = items.getDate();

        Intent intent = new Intent(MainActivity.this,ShowDetailsActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("detail",details);
        intent.putExtra("date",date);
        startActivity(intent);
        //Toast.makeText(getApplicationContext(),title+"\n"+details,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

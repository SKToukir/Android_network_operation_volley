package com.tekinarslan.sample.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.tekinarslan.sample.Adapters.CustomAdapter;
import com.tekinarslan.sample.R;

import java.io.File;
import java.io.FilenameFilter;

public class MainActivity extends Activity {
    String[] pdflist;
    //this imageList file array holds .pdf files
    File[] imagelist;
    ListView gridView;
    Button btnClearTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        gridView = (ListView) findViewById(R.id.gridViewItems);
        //File images = Environment.getExternalStorageDirectory();
        File images = new File(Environment.getExternalStorageDirectory()+File.separator + "ReaderRs");

        boolean success = true;

        if (!images.exists()) {
            success = images.mkdir();
        }

        if(success){

        /* this imagelist file array holds the number of .pdf files in your device */
            imagelist = images.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return ((name.endsWith(".pdf")));
                }
            });


        /* try this if you have .pdf files in your device */
            try {

                if (imagelist.length == 0){

                    Toast.makeText(this,"Your ReaderRs file is empty!",Toast.LENGTH_LONG).show();
                }
                //show the number of .pdf files

                pdflist = new String[imagelist.length];
                for (int i = 0; i < imagelist.length; i++) {
                /* get the name of .pdf files and store it in pdflist array */
                    pdflist[i] = imagelist[i].getName();
                }
                gridView.setAdapter(new CustomAdapter(this, pdflist, R.drawable.pdfa));

        /* if you don't have any .pdf files in your device */
            } catch (Exception e) {

                Toast.makeText(this, "No pdf file in your sd card!", Toast.LENGTH_LONG).show();
            }

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String path = imagelist[position].getAbsolutePath();
                    //Toast.makeText(getApplicationContext(),path,Toast.LENGTH_LONG).show();
                    //openPdfIntent(path);
                    Intent intent = new Intent(MainActivity.this, SampleActivity.class);
                    intent.putExtra("file_path", path);
                    startActivity(intent);
                }
            });
        }else{
            Toast.makeText(getApplicationContext(),"File can not be craeted!",Toast.LENGTH_LONG).show();
        }
    }
    /* fire this method when item click on list and get the path of .pdf files and
     pass the path from openPdfIntent as a parameter for showing the required .pdf file by
     opening a class named Second. That extends PdfViewerActivity and this activity implements some methods */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.html, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_html){

            try {
                Intent intent = new Intent(MainActivity.this, HtmlViwerActivity.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this,"Try again!",Toast.LENGTH_LONG).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnSignIn(View view) {

        Toast.makeText(this,"This is a sign in button!",Toast.LENGTH_LONG).show();
    }

    public void btnEdit(View view) {

        Toast.makeText(this,"This is a edit in button!",Toast.LENGTH_LONG).show();
    }

    public void btnMenu(View view) {

        try {
            Intent intent = new Intent(MainActivity.this, HtmlViwerActivity.class);
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this,"Try again!",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}


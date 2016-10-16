package com.tekinarslan.sample.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.widget.GridView;
import android.widget.Toast;

import com.tekinarslan.sample.Adapters.CustomPagerAdapter;
import com.tekinarslan.sample.R;

import java.io.File;
import java.io.FilenameFilter;

public class HtmlViwerActivity extends Activity {

    public static final String HTML_FILE_NAME_LIST = "html_file_name_list";
    public static final String HTML_FILES = "html_file_list";
    CustomPagerAdapter adapter;
    ViewPager viewPager;
    Bundle bundle;
    String[] htmlList;
    File[] htmlFileList;
    GridView htmlGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);

        //htmlGrid = (GridView) findViewById(R.id.gridViewHtmlItems);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        final File htmlFiles = new File(Environment.getExternalStorageDirectory()+File.separator+"HtmlFiles");

        boolean success = true;

        if (!htmlFiles.exists()){

            success = htmlFiles.mkdir();
        }

        if (success) {

            htmlFileList = htmlFiles.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File file, String s) {
                    return (s.endsWith(".html"));
                }
            });

            try{
            if (htmlFileList.length == 0) {

                Toast.makeText(this, "There is no html files in your HtmlFiles directory!", Toast.LENGTH_LONG).show();
            }

            htmlList = new String[htmlFileList.length];

            for (int i = 0; i < htmlFileList.length; i++) {

                htmlList[i] = htmlFileList[i].getName();
            }

            //htmlGrid.setAdapter(new CustomHtmlAdapter(this, htmlList, R.drawable.html));

                adapter = new CustomPagerAdapter(this,htmlList);
                viewPager.setAdapter(adapter);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {

            Toast.makeText(this,"File can not exist. Check your device space!",Toast.LENGTH_LONG).show();
        }

//        htmlGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                String htmlFilePath = htmlFileList[i].getAbsolutePath();
//
//                Intent intent = new Intent(HtmlViwerActivity.this,HtmlView.class);
//                intent.putExtra("html_path",htmlList[i]);
//                intent.putExtra("position",i);
//                startActivity(intent);
//
//            }
//        });

    }
}

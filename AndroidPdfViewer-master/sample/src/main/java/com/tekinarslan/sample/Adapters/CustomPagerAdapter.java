package com.tekinarslan.sample.Adapters;

import android.content.Context;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.tekinarslan.sample.R;

import java.io.File;

/**
 * Created by toukir on 4/8/16.
 */
public class CustomPagerAdapter extends PagerAdapter {

    WebView webView;
    Context context;
    String[] filesName;

    int NumberOfPages;

    LayoutInflater layoutInflater;


    public CustomPagerAdapter(Context contexts,String[] filesName) {

        this.context = contexts;
        this.filesName = filesName;
    }

    @Override
    public int getCount() {
        return NumberOfPages=filesName.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        String fileName = filesName[position];

        //Toast.makeText(context,fileName,Toast.LENGTH_LONG).show();

        String url = "file:///" + Environment.getExternalStorageDirectory().toString() + File.separator + "HtmlFiles/" + filesName[position];


        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = layoutInflater.inflate(R.layout.fragment_screen_slide_page,container,false);

       webView = (WebView) item.findViewById(R.id.htmlWebViewww);
        WebSettings webSetting = webView.getSettings();
        //webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        container.addView(item);
        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }

}



package com.best.hp_.udacitysunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MoreActivity extends AppCompatActivity {

    String[] quesArr = {"লিবিয়ার রাজধানীর নাম","দক্ষিণ আফ্রিকার রাজধানীর নাম","ইরিত্রিয়ার রাজধানীর নাম","ঘানার রাজধানীর নাম","নাইজারের রাজধানীর নাম",
    "লিবিয়ার মুদ্রার নাম","নামিবিয়ার মুদ্রার নাম","মালাবির মুদ্রার নাম","জিবুতির আইনসভার নাম"," গিনির আইনসভার নাম","গ্যাবনের আইনসভার নাম",
    "মোজাম্বিকের আইনসভার নাম "};
    String[] ansArr = {"ত্রিপোলি","কেপটাউন ","আসমারা","আক্রা ","নিয়ামি ","দিনার ","নামিবীয় ডলার","কোয়াচা","ন্যাশনাল অ্যাসেম্বলি","ন্যাশনাল অ্যাসেম্বলি",
    "পার্লামেন্ট","অ্যাসেম্বলি অব দি রিপাবলিক"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
    }
}

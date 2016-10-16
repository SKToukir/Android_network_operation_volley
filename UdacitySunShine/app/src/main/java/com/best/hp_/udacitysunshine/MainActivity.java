package com.best.hp_.udacitysunshine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String positionOne,positionTwo,positionThree,positionFour,positionFive;
    int pointOne,pointTwo,pointThree,pointFour,pointFive;
    ScoreClass scoreClass;

    String playerName;
    ImageView imageOne,imageTwo,imageThree;
    private final long startTime = 30 * 1000;
    private final long interval = 1 * 1000;
    AlertDialog.Builder dialog;
    int life = 3;
    String lifeOver = "You have finish all of your life";
    String gameOverTitle = "Game Over";
    String quesFinishTitle = "Complete All question";
    int i=1;
    int numOfQues =0;
    boolean timeHasStarted=false;
    TextView txtQusetion,txtScore,txtTimer,txtNumberOfQuesTion,txtMyAns;
    Button btnClueOne, btnClueTwo, btnClueThree, btnClueFour, btnSubmit;
    String answer,givenAnswer;
    MyCountDownTimer countDownTimer;
    int ID=0;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        playerName = intent.getStringExtra("name");


        Toast.makeText(MainActivity.this, "Welcome " + playerName, Toast.LENGTH_SHORT).show();

        imageOne = (ImageView) findViewById(R.id.lifeOne);
        imageTwo = (ImageView) findViewById(R.id.lifeTwo);
        imageThree = (ImageView) findViewById(R.id.lifeThree);

        txtMyAns = (TextView) findViewById(R.id.txtMyAns);
//        txtTimer = (TextView) findViewById(R.id.txtTimer);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        txtQusetion = (TextView) findViewById(R.id.quesText);
        btnClueOne = (Button) findViewById(R.id.btnClueOne);
        btnClueTwo = (Button) findViewById(R.id.btnClueTwo);
        btnClueThree = (Button) findViewById(R.id.btnClueThree);
        btnClueFour = (Button) findViewById(R.id.btnClueFour);

        //timer();

        btnSubmit.setOnClickListener(this);
        btnClueOne.setOnClickListener(this);
        btnClueTwo.setOnClickListener(this);
        btnClueThree.setOnClickListener(this);
        btnClueFour.setOnClickListener(this);

        DBQues db = new DBQues(this);

        if (i==1) {

            db.addQues(new QuesBankClass("বাংলাদেশের কোন স্থানটি বিদ্রোহী কবি কাজী নজরুল ইসলামের স্মৃতির সাথে জড়িত-", "চুরুলিয়া", "দরিরামপুর", "শান্তিডাঙ্গা", "কালিগঞ্জ", "দরিরামপুর"));
            db.addQues(new QuesBankClass("বঙ্গভবন হচ্ছে-", "প্রধানমন্ত্রীর সরকারী বাসভবন", "রাষ্ট্রপতির সরকারী বাসভবন", "রাষ্ট্রপতির সচিবালয়", "উপরাষ্ট্রপতির সরকারী বাসভবন", "রাষ্ট্রপতির সরকারী বাসভবন"));
            db.addQues(new QuesBankClass("উত্তরা গণভবন অবস্থিত কোন জেলায়-", "ঠাকুরগাঁয়ে", "সৈয়দপুরে", "রাজশাহীতে", "নাটোরে", "নাটোরে"));
            db.addQues(new QuesBankClass("বাংলাদেশের সরকার প্রধানের উত্তরাঞ্চলীয় সচিবালয়ের নাম-", "বঙ্গ ভবন", "প্রেসিডেন্ট ভবন", "গণ ভবন", "উত্তরা গণভবন", "উত্তরা গণভবন"));
            db.addQues(new QuesBankClass("ঢাকার চন্দ্রিমা উদ্যানের পার্শ্বে অবস্থিত রাষ্ট্রীয় অতিথি ভবনটির নাম-", "পদ্মা", "মেঘনা", "করোতোয়া", "রজনীগন্ধ্যা", "করোতোয়া"));
            db.addQues(new QuesBankClass("ঢাকার বিখ্যাত তারা মসজিদ নির্মান করেছিলেন-", "শায়েস্তা খান", "নওয়াব সলিমুল্লাহ", "মির্জা আহমেদ খান", "খান সাহেব আবুল হাসনাত", "শায়েস্তা খান"));
            db.addQues(new QuesBankClass("প্রাচীন গৌড় রাজ্যের অধীনে ছিল বর্তমান বাংলাদেশের-", "উত্তরবঙ্গ", "দক্ষিণবঙ্গ", "ক ও খ উভয়ই", "কোনটিই নয়", "উত্তরবঙ্গ"));
            db.addQues(new QuesBankClass("আনন্দ বিহার কোথায়-", "রাজশাহীতে", "মহাস্থানগড়ে", "ময়নামতিতে", "পাহাড়পুরে", "ময়নামতিতে"));
            db.addQues(new QuesBankClass("বাগেরহাট ষাট গম্বুজ মসজিদটি কখন নির্মিত হয়েছিল-", "প্রাক মোঘল যুগে", "মোঘল যুগে", "ইংরেজ আমলে", "পাকিস্তানী আমলে", "প্রাক মোঘল যুগে"));
            db.addQues(new QuesBankClass("আওলাদ হোসেন লেনের জামে মসজিদটির নির্মাতা-", "সম্রাট বাবর", "সম্রাট হুমায়ুন", "সুবেদার ইসলাম খান", "শায়েস্তা খান", "সুবেদার ইসলাম খান"));
            db.addQues(new QuesBankClass("মোগল আমলে ঢাকা শহরের প্রাচীনতম মসজিদ-", "লালবাগ শাহী মসজিদ", "সাত গম্বুজ মসজিদ", "চকের মসজিদ", "আওলাদ হোসেন লেনের জামে মসজিদ", "আওলাদ হোসেন লেনের জামে মসজিদ"));
            db.addQues(new QuesBankClass("প্রাক মোগল আমলে ঢাকা শহরের প্রাচীনতম মসজিদ-", "তারা মসজিদ", "বিনিত বিবির মসজিদ", "সাত গম্বুজ মসজিদ", "লালবাগ শাহী মসজিদ", "বিনিত বিবির মসজিদ"));
            db.addQues(new QuesBankClass("স্বাধীন বাংলাদেশের রাজধানী হওয়ার পূর্বে  ঢাকা বাংলার রাজধানী  ছিল-", "একবার", "দুইবার", "তিনবার", "চারবার", "তিনবার"));
            db.addQues(new QuesBankClass("ঢাকার  বিখ্যাত ছোট কাটরা নির্মান করেন -", "ইসলাম খান", "মীর জুমলা", "শায়েস্তা  খান", "শাহজাদা আজম", "শায়েস্তা  খান"));
            db.addQues(new QuesBankClass("প্রাচীনকালে সমতট বলতে বোঝাতো বর্তমান বাংলাদেশের -", "বৃহত্তর নোয়াখালী ও কুমিল্লা জেলাকে", "বগুড়া ও রংপুর জেলাকে", "রাজশাহী ও পাবনা জেলাকে", "খুলনা ও কুষ্টিয়া জেলাকে", "বৃহত্তর নোয়াখালী ও কুমিল্লা জেলাকে"));
            db.addQues(new QuesBankClass("বাংলাদেশের কোথায় মৌর্য শিলালিপি পাওয়া গেছে-", "কুমিল্লার ময়নামতিতে", "রাজশাহীর পাহাড়পুরে", "বগুড়ার মহাস্থানগড়ে", "নারায়ণগঞ্জের সোনারগাঁয়ে", "বগুড়ার মহাস্থানগড়ে"));
            db.addQues(new QuesBankClass("ময়নামতি অবস্থিত-", "ঢাকা জেলায়", "কুমিল্লা জেলায়", "চট্রগ্রাম জেলায়", "নোয়াখালী জেলায়", "কুমিল্লা জেলায়"));
            db.addQues(new QuesBankClass("অষ্টম শতাব্দীতে নির্মিত শালবন  বিহার কোথায়-", "পাহাড়পুরে", "নাটোরে", "ময়নামতিতে", "রাঙ্গামাটিতে", "ময়নামতিতে"));
            db.addQues(new QuesBankClass("সপ্তম শতাব্দীতে নির্মিত পাহাড়পুরের বৌদ্ধবিহারটি কি নামে পরিচিত ছিল-", "সোমপুর বিহার", "শ্রী বিহার", "ধর্মপাল বিহার", "জগদ্দল বিহার", "সোমপুর বিহার"));
            db.addQues(new QuesBankClass("সুবাদার ইসলাম খান ঢাকার নাম রাখেন-", "নাসিরাবাদ", "ইসলামাবাদ", "জাহাঙ্গীরনগর", "জান্নাতবাদ", "জাহাঙ্গীরনগর"));
            db.addQues(new QuesBankClass("বাংলার রাজধানী রাজমহল থেকে ঢাকায় স্থানান্তর করেন-", "ঈসা খান", "সুবাদার ইসলাম খান", "শায়েস্তা খান", "মীর জুমলা", "সুবাদার ইসলাম খান"));
            db.addQues(new QuesBankClass("ঢাকা সর্বপ্রথম বাংলার রাজধানী হয়-", "১২০৬ সালে", "১৩১০ সালে", "১৫২৬ সালে", "১৬১০ সালে", "১৬১০ সালে"));
            db.addQues(new QuesBankClass("হযরত শাহজালাল (রাঃ) এর মাজার অবস্থিত-", "চট্রগ্রামে", "সিলেটে", "ময়মনসিংহে", "রংপুরে", "সিলেটে"));
            db.addQues(new QuesBankClass("লালবাগ কেল্লার আদি নাম-", "আজম দূর্গ", "শায়েস্তা খান দূর্গ", "পরী বিবির দূর্গ", "আওরঙ্গবাদ দূর্গ", "আওরঙ্গবাদ দূর্গ"));
            db.addQues(new QuesBankClass("ঢাকার চকের মসজিদটির নির্মাতা-", "মীর জুমলা", "ইসলাম খান", "শায়েস্তা খান", "মুর্শিদকুলি খান", "শায়েস্তা খান"));
            db.addQues(new QuesBankClass("বাংলাদেশে গারো উপজাতি বাস করে -", "ঢাকা, গাজিপুর ও কুমিল্লায়", "ময়মনসিংহ, টাঙ্গাইল ও নেত্রকোনায়", "সিলেট, হবিগঞ্জ ও চট্রগ্রামে", "দিনাজপুর, রংপুর ও বগুড়ায়", "ময়মনসিংহ, টাঙ্গাইল ও নেত্রকোনায়"));
            db.addQues(new QuesBankClass("বাংলাদেশে চাকমা উপজাতি বাস করে প্রধানত -", "রাঙ্গামাটি ও খাগড়াছড়িতে", "বান্দরবান ও সিলেটে", "চট্রগ্রাম ও ময়মনসিংহে", "সিলেট ও পটুয়াখালিতে", "রাঙ্গামাটি ও খাগড়াছড়িতে"));
            db.addQues(new QuesBankClass("বাংলাদেশে সবচেয়ে বেশী বাস করে কোন উপজাতি?", "মারমা", "চাকমা", "টিপরা", "খাসিয়া", "চাকমা"));
            db.addQues(new QuesBankClass("বাংলাদেশে উপজাতিয় লোকসংখ্যা মোট জনসংখ্যার (১৯৯১ সাল)", "১%", "০.৯%", "১.০৮%", "০.৬%", "১.০৮%"));
            db.addQues(new QuesBankClass("বাংলাদেশে মোট উপজাতিদের সংখ্যা (১৯৯১ সাল)", "৯ লক্ষ", "৮ লক্ষ", "১০ লক্ষ", "১২ লক্ষ", "১২ লক্ষ"));
            db.addQues(new QuesBankClass("বর্তমান হারে জনসংখ্যা বৃদ্ধি পেলে বাংলাদেশের জনসংখ্যা দ্বিগুন হবে-", "১৫ বৎসরে", "৩০ বৎসরে", "৪০ বৎসরে", "৫০ বৎসরে", "৫০ বৎসরে"));
            db.addQues(new QuesBankClass("বাংলাদেশে কিশোর অপরাধীর বয়স সীমা কত? ", "৯-১৮ বছর", "৪-১১ বছর", "৭-১৬ বছর", "৫-১২ বছর", "৭-১৬ বছর"));
            db.addQues(new QuesBankClass("বাংলাদেশে চতুর্থ আদমশুমারি অনুষ্ঠিত হয় -", "২০০০ সালে", "২০০১ সালে", "২০০২ সালে", "২০০৩ সালে", "২০০১ সালে"));
            db.addQues(new QuesBankClass("বাংলাদেশে তৃতীয় আদমশুমারি অনুষ্ঠিত হয় -", "১৯৯০ সালে", "১৯৯১ সালে", "১৯৯২ সালে", "১৯৯৪ সালে", "১৯৯১ সালে"));
            db.addQues(new QuesBankClass("বাংলাদেশে দ্বিতীয় আদমশুমারি অনুষ্ঠিত হয় -", "১৯৮১ সালে", "১৯৭৪ সালে", "১৯৮৪ সালে", "১৯৮৮ সালে", "১৯৮১ সালে"));
            db.addQues(new QuesBankClass("স্বাধীনতার পর দেশে আদমশুমারি প্রথম অনুষ্ঠিত হয় -", "১৯৭৪ সালে", "১৯৭২ সালে", "১৯৮১ সালে", "১৯৮২ সালে", "১৯৭৪ সালে"));
            db.addQues(new QuesBankClass("অবিভক্ত ভারতবর্ষে আদমশুমারি প্রথম অনুষ্ঠিত হয়েছিল -", "১৬৫০ সালে", "১৮৬১ সালে", "১৯০১ সালে", "১৯১১ সালে", "১৮৬১ সালে"));
            db.addQues(new QuesBankClass("বাংলাদেশে মোট জনসংখ্যার শতকরা কত ভাগ হিন্দু -", "১০.৫%", "১৭%", "১৫%", "১২%", "১০.৫%"));
            db.addQues(new QuesBankClass("বাংলাদেশে মোট জনসংখ্যার শতকরা কত ভাগ মুসলমান -", "৮০%", "৮৮.৩%", "৮৫%", "৯০%", "৮৮.৩%"));
            db.addQues(new QuesBankClass("জনসংখ্যার দিক দিয়ে মুসলিম বিশ্বে  প্রথম -", "ইন্দোনেশিয়া", "বাংলাদেশ", "নাইজেরিয়া", "পাকিস্তান", "ইন্দোনেশিয়া"));
            db.addQues(new QuesBankClass("জনসংখ্যার দিক দিয়ে মুসলিম বিশ্বে বাংলাদেশের স্থান -", "১ম", "২য়", "৩য়", "৪র্থ", "৩য়"));
            db.addQues(new QuesBankClass("জনসংখ্যার দিক দিয়ে পৃথিবীতে বাংলাদেশের স্থান -", "৫ম", "৭ম", "৮ম", "৯ম", "৯ম"));
            db.addQues(new QuesBankClass("বিশেষজ্ঞদের মতে বাংলাদেশের জনসংখ্যা ২০ কোটি হবে -", "২০০০ সালে", "২০২০ সালে", "২০২৫ সালে", "২০৩০ সালে", "২০২৫ সালে"));
            db.addQues(new QuesBankClass("বাংলাদেশে জনসংখ্যা বৃদ্ধির হার (২০০১ এর আদমশুমারি) -", "২.৫%", "১.৪৮%", "২.৪৮%", "২.৯%", "১.৪৮%"));
            db.addQues(new QuesBankClass("বাংলাদেশে মৃত্যুর হার-", "প্রতি হাজারে ৪.৭০ জন", "প্রতি হাজারে ৩.৭০জন", "প্রতি হাজারে ৫.৭০ জন", "প্রতি হাজারে ৬.৭০ জন", "প্রতি হাজারে ৩.৭০জন"));
            db.addQues(new QuesBankClass("বাংলাদেশের লোকসংখ্যা (২০০৫ প্রাক্কলিত)-", "১১.১৪ কোটি", "১০ কোটি", "১৩.৫২ কোটি", "১২.৩১ কোটি", "১৩.৫২ কোটি"));
            db.addQues(new QuesBankClass("বাংলাদেশের লোকসংখ্যা (২০০১সমন্বয় ভিত্তিক)-", "১১.১৪ কোটি", "১০ কোটি", "১৩.৭০ কোটি", "১২.৩১ কোটি", "১৩.৭০ কোটি"));
            db.addQues(new QuesBankClass("বাংলাদেশেরলোকসংখ্যা (২০০১শুমারিভিত্তিক)-", "১১.১৪কোটি", "১০কোটি", "১০.৫কোটি", "১২.৩১কোটি", "১২.৩১কোটি"));
            db.addQues(new QuesBankClass("আন্তর্জাতিক ক্ষেত্রে ও জরুরী ডাক সার্ভিসের জন্য আন্তর্জাতিক এক্সপ্রেস মেইল সার্ভিস প্রবর্তন করা হয়-", "২ ফেব্রুয়ারি, ১৯৮৫", "২ ফেব্রুয়ারি, ১৯৮৭", "২ ফেব্রুয়ারি, ১৯৮৯", "২ ফেব্রুয়ারি, ১৯৯১", "২ ফেব্রুয়ারি, ১৯৮৭"));
            db.addQues(new QuesBankClass("আভ্যন্তরীণ সার্ভিসের উন্নয়নের জন্য দ্রুততর ডাক সার্ভিস হিসাবে (জি.ই.পি.) সার্ভিস চালু করা হয়-", "১৯৮০ সালে", "১৯৮২ সালে", "১৯৮৪ সালে", "১৯৮৬ সালে", "১৯৮৪ সালে"));
            i++;
        }else {
            Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show();
        }
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));
//        db.addQues(new QuesBankClass("ques", "a", "b", "c", "d", "ans"));

//
//  Log.d("Reading:", "Reading ques");
//
//        QuesBankClass string = db.getQuesWithChoices(4);
//        String getString =
//                "Ques: "+string.getQues()+" A:"+string.getClueA()
//                +"B: "+string.getClueB()+" C: "+string.getClueC()
//                +" D:"+string.getClueD()+" Ans:"+string.getAns();
//        Log.d("Question:-",getString);
//
//        boolean correct = db.getAns(4,"Dhaka");
//
//        if (correct){
//            Log.d("Answer is :-","correct");
//        }else {
//            Log.d("Answer is :-","wrong");
//        }

//        Random random = new Random();
//        ID = random.nextInt(4-1)+1;

        generateQuestion(getRandomId());

    }



    private void timer() {
        countDownTimer = new MyCountDownTimer(startTime, interval);

//        txtTimer.setText(txtTimer.getText()+String.valueOf(startTime / 1000));
        txtTimer.setText(txtTimer.getText()+String.valueOf(startTime+1000));
        countDownTimer.start();
        timeHasStarted=true;
    }

    private void generateQuestion(int id) {
        DBQues db = new DBQues(this);

        numOfQues++;

        if (numOfQues==50) {

            countDownTimer.cancel();
            gameOverDialog(quesFinishTitle);
            Toast.makeText(this,"Question is finish",Toast.LENGTH_LONG).show();


        }else {
            QuesBankClass question = db.getQuesWithChoices(id);
            txtQusetion.setText(question.getQues());
            btnClueOne.setText(question.getClueA());
            btnClueTwo.setText(question.getClueB());
            btnClueThree.setText(question.getClueC());
            btnClueFour.setText(question.getClueD());
            answer = question.getAns();
            txtMyAns.setText(null);
            //txtNumberOfQuesTion.setText(numOfQues + "/5");


        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnClueOne:
                givenAnswer = btnClueOne.getText().toString();
                txtMyAns.setText(givenAnswer);
                //Toast.makeText(this,givenAnswer,Toast.LENGTH_LONG).show();
                break;
            case R.id.btnClueTwo:
                givenAnswer = btnClueTwo.getText().toString();
                txtMyAns.setText(givenAnswer);
                //Toast.makeText(this,givenAnswer,Toast.LENGTH_LONG).show();
                break;
            case R.id.btnClueThree:
                givenAnswer = btnClueThree.getText().toString();
                txtMyAns.setText(givenAnswer);
                //Toast.makeText(this,givenAnswer,Toast.LENGTH_LONG).show();
                break;
            case R.id.btnSubmit:
                String answer = txtMyAns.getText().toString();
                //Toast.makeText(this,givenAnswer+" "+String.valueOf(ID),Toast.LENGTH_LONG).show();
                if (answer.isEmpty()){
                    Toast.makeText(MainActivity.this,"Select one answer first!",Toast.LENGTH_LONG).show();
                }else {
                    checkAnswer(givenAnswer, ID);
                }
                    break;
            default:
                givenAnswer = btnClueFour.getText().toString();
                txtMyAns.setText(givenAnswer);
               //Toast.makeText(this,givenAnswer,Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void checkAnswer(String givenAnswer, int id) {
        DBQues db = new DBQues(this);
        boolean result=db.getAns(id,givenAnswer);
        //Toast.makeText(this,givenAnswer+" "+String.valueOf(result)+" "+String.valueOf(id),Toast.LENGTH_LONG).show();
        if (result==true){
            score++;
            //Toast.makeText(this,"Correct answer...",Toast.LENGTH_LONG).show();
            txtScore.setText(String.valueOf(score));
            generateQuestion(getRandomId());
        }else {

            //score--;
            Toast.makeText(MainActivity.this,"Wrong answer!",Toast.LENGTH_LONG).show();
            generateQuestion(getRandomId());
            life--;
            Life(life);
//            if (score==0){
//
//                gameOverDialog(lifeOver);
//
//            }else {
//
//                txtScore.setText(String.valueOf(score));
//                generateQuestion(getRandomId());
//                Toast.makeText(this,"Wrong answer...",Toast.LENGTH_LONG).show();
//            }

        }
    }

    public int getRandomId(){
//        Random random = new Random();
//        ID = random.nextInt(4-1)+1;
//            ID++;
//        return ID;

        for (int i=0; i< 50; i++) {
            ID = (int)(Math.random()*20)+1;
            return ID;
        }

        return 1;
    }
   public class MyCountDownTimer extends CountDownTimer{

        MyCountDownTimer(long startTime, long interval){
            super(startTime,interval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            txtTimer.setText("" + millisUntilFinished +1000);
        }

        @Override
        public void onFinish() {
            btnSubmit.setVisibility(View.INVISIBLE);
            //txtTimer.setText("Time's Up");
            //gameOverDialog(gameOverTitle);
        }
    }
    public void gameOverDialog(String title){
        dialog = new AlertDialog.Builder(this);
        dialog.setTitle(title);
        dialog.setMessage(playerName+" your score: " + score + "\n\nNext time do better!");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



                finish();
                dialog.cancel();
            }
        });
        dialog.create();
        dialog.show();
    }

    public void Life(int number){

        switch (number){
            case 0:
                imageOne.setVisibility(View.INVISIBLE);
                imageTwo.setVisibility(View.INVISIBLE);
                imageThree.setVisibility(View.INVISIBLE);
                gameOverDialog(gameOverTitle);
                break;
            case 1:
                imageOne.setVisibility(View.VISIBLE);
                imageTwo.setVisibility(View.INVISIBLE);
                imageThree.setVisibility(View.INVISIBLE);
                break;
            case 2:
                imageOne.setVisibility(View.VISIBLE);
                imageTwo.setVisibility(View.VISIBLE);
                imageThree.setVisibility(View.INVISIBLE);
                break;

        }
    }

}

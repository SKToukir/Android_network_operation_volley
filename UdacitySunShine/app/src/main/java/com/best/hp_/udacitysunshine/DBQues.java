package com.best.hp_.udacitysunshine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP_$$) on 18-Dec-15.
 */
public class DBQues extends SQLiteOpenHelper {

    public static final int DB_VERSION = 14;
    public static final String DB_NAME = "database_question";
    public static final String TABLE_NAME = "multipleChoice_tbl";
    public static final String COLOUMN_ID = "id";
    public static final String COLOUMN_QUES = "question";
    public static final String COLOUMN_CLUE_A = "A";
    public static final String COLOUMN_CLUE_B = "B";
    public static final String COLOUMN_CLUE_C = "C";
    public static final String COLOUMN_CLUE_D = "D";
    public static final String COLOUMN_CLUE_ANS = "Ans";

    public DBQues(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUES_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLOUMN_ID + " INTEGER PRIMARY KEY," + COLOUMN_QUES + " TEXT,"
                + COLOUMN_CLUE_A + " TEXT," + COLOUMN_CLUE_B + " TEXT," + COLOUMN_CLUE_C + " TEXT," + COLOUMN_CLUE_D + " TEXT," + COLOUMN_CLUE_ANS + " TEXT" +")";
        db.execSQL(CREATE_QUES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public void addQues(QuesBankClass aClass){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLOUMN_QUES,aClass.getQues());
        values.put(COLOUMN_CLUE_A,aClass.getClueA());
        values.put(COLOUMN_CLUE_B,aClass.getClueB());
        values.put(COLOUMN_CLUE_C,aClass.getClueC());
        values.put(COLOUMN_CLUE_D,aClass.getClueD());
        values.put(COLOUMN_CLUE_ANS,aClass.getAns());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public QuesBankClass getQuesWithChoices(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{COLOUMN_QUES, COLOUMN_CLUE_A, COLOUMN_CLUE_B, COLOUMN_CLUE_C, COLOUMN_CLUE_D, COLOUMN_CLUE_ANS}, COLOUMN_ID + "=?", new String[]{String.valueOf(id)},null,null,null);

        if (cursor != null)
            cursor.moveToFirst();
        QuesBankClass aClass = new QuesBankClass(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));

        return aClass;
    }

    public boolean getAns(int id,String choice){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{COLOUMN_CLUE_ANS}, COLOUMN_ID + "=?", new String[]{String.valueOf(id)},null,null,null,null);

        if (cursor!=null)
            cursor.moveToFirst();
        String ans = cursor.getString(0);

        if (ans.equals(choice)){
            return true;
        }else {
            return false;
        }

    }
}

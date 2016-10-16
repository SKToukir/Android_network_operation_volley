package com.best.hp_.udacitysunshine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP_$$) on 27-Dec-15.
 */
public class DBScore extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 8;
    private static final String DATABASE_NAME = "db_score";
    public static final String TABLE_NAME = "scoreBoardTable";
    private static final String COLOUMN_ID = "Id";
    private static final String COLOUMN_NAME = "name";
    private static final String COLOUMN_SCORE = "scores";
    private static final String COLOUMN_TIME = "time";

    public DBScore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SCORE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLOUMN_ID + " INTEGER PRIMARY KEY," + COLOUMN_NAME + " TEXT," + COLOUMN_SCORE + " TEXT," + COLOUMN_TIME + " TEXT"+")";
        db.execSQL(CREATE_SCORE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void addScore(ScoreBoard score){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLOUMN_ID,score.getID());
        values.put(COLOUMN_NAME,score.getPlayerName());
        values.put(COLOUMN_SCORE,score.getPlayerName());
        values.put(COLOUMN_TIME,score.getTimeTook());

        db.insert(TABLE_NAME, null, values);
    }

    public List<ScoreBoard> getAllScore() {
        List<ScoreBoard> scoreList = new ArrayList<ScoreBoard>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ScoreBoard scoreBoard = new ScoreBoard();
                scoreBoard.setID(Integer.parseInt(cursor.getString(0)));
                scoreBoard.setPlayerName(cursor.getString(1));
                scoreBoard.setScore(Integer.parseInt(cursor.getString(2)));
                scoreBoard.setTimeTook(cursor.getString(3));
                // Adding contact to list
                scoreList.add(scoreBoard);
            } while (cursor.moveToNext());
        }

        // return contact list
        return scoreList;
    }

}

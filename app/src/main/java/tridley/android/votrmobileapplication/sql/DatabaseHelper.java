package tridley.android.votrmobileapplication.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tridley.android.votrmobileapplication.model.AccessCode;
import tridley.android.votrmobileapplication.model.AccountInfo;
import tridley.android.votrmobileapplication.model.Answers;
import tridley.android.votrmobileapplication.model.CreatePoll;
import tridley.android.votrmobileapplication.model.GivenAnswer;
import tridley.android.votrmobileapplication.model.Poll;
import tridley.android.votrmobileapplication.model.PollHistroy;
import tridley.android.votrmobileapplication.model.Questions;
import tridley.android.votrmobileapplication.model.User;

/**
 * Created by FourthLord on 11/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "UserManager.db";

    private static final String TABLE_USER = "user";
    private static final String TABLE_ACCESSCODE = "access code";
    private static final String TABLE_ACCOUNTINFO = "account info";
    private static final String TABLE_ANSWERS= "answers";
    private static final String TABLE_CREATEPOLL = "create poll";
    private static final String TABLE_GIVENANSWER = "given answer";
    private static final String TABLE_POLL = "poll";
    private static final String TABLE_POLLHISTORY = "poll history";
    private static final String TABLE_QUESTIONS= "questions";

//access code table
    private static final String COLUMN_ACCESS_CODE = "access_code";

    private String CREATE_ACCESSCODE_TABLE = "CREATE TABLE " + TABLE_ACCESSCODE + "("
            + COLUMN_ACCESS_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT," + ")";

    private String DROP_ACCESSCODE_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUESTIONS;


    //account info table
    private static final String COLUMN_ACCOUNT_ID = "account id";

    private String CREATE_ACCOUNTINFO_TABLE = "CREATE TABLE " + TABLE_ACCOUNTINFO + "("
            + COLUMN_ACCOUNT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + ")";

    private String DROP_ACCOUNTINFO_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUESTIONS;


    //answers table
    private static final String COLUMN_ANSWER = "answer";

    private String CREATE_ANSWERS_TABLE = "CREATE TABLE " + TABLE_ANSWERS + "("
        + COLUMN_ANSWER + " TEXT," + ")";

    private String DROP_ANSWERS_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUESTIONS;


//poll table

    private static final String COLUMN_POLLTITLE = "title";
    private static final String COLUMN_POLLANSWER_ = "answer";
    private static final String COLUMN_POLLQUESTION = "question";


    private String CREATE_POLL_TABLE = "CREATE TABLE " + TABLE_POLL + "("
            + COLUMN_POLLTITLE + " TEXT," + COLUMN_POLLANSWER_ + " TEXT,"
            + COLUMN_POLLQUESTION + "TEXT," + ")";

    private String DROP_POLL_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUESTIONS;


//given answer table

    private static final String COLUMN_GIVENANSWER = "given answers";

    private String CREATE_GIVENANSWER_TABLE = "CREATE TABLE " + TABLE_GIVENANSWER + "("
            + COLUMN_GIVENANSWER + " TEXT," + ")";

    private String DROP_GIVENANSWER_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUESTIONS;


    //create poll table
    private static final String COLUMN_CREATEPOLL_ID = "poll id";
    private static final String COLUMN_CREATEPOLL_TITLE = "title";
    private static final String COLUMN_CREATEPOLL_CODE = "code";
    private static final String COLUMN_CREATEPOLL_OPTIONS = "options";


    private String CREATE_CREATEPOLL_TABLE = "CREATE TABLE " + TABLE_CREATEPOLL + "("
            + COLUMN_CREATEPOLL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CREATEPOLL_TITLE+ " TEXT,"
            + COLUMN_CREATEPOLL_CODE + "INTEGER," + COLUMN_CREATEPOLL_OPTIONS + "TEXT" + ")";

    private String DROP_CREATEPOLL_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUESTIONS;


    //poll history table
    private static final String COLUMN_POLLHISTORY_TITLE= "title";

    private String CREATE_POLLHISTORY_TABLE = "CREATE TABLE " + TABLE_POLLHISTORY + "("
            + COLUMN_POLLHISTORY_TITLE + " TEXT," + ")";

    private String DROP_POLLHISTORY_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUESTIONS;


    //questions table
    private static final String COLUMN_QUESTIONS = "categories";

    private String CREATE_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_QUESTIONS + "("
            + COLUMN_QUESTIONS + " TEXT," + ")";

    private String DROP_QUESTIONS_TABLE = "DROP TABLE IF EXISTS " + TABLE_QUESTIONS;







    //user table
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + "TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_ACCESSCODE_TABLE);
        db.execSQL(CREATE_ACCOUNTINFO_TABLE);
        db.execSQL(CREATE_ANSWERS_TABLE);
        db.execSQL(CREATE_CREATEPOLL_TABLE);
        db.execSQL(CREATE_GIVENANSWER_TABLE);
        db.execSQL(CREATE_POLLHISTORY_TABLE);
        db.execSQL(CREATE_POLL_TABLE);
        db.execSQL(CREATE_QUESTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_ACCESSCODE_TABLE);
        db.execSQL(DROP_ACCOUNTINFO_TABLE);
        db.execSQL(DROP_ANSWERS_TABLE);
        db.execSQL(DROP_CREATEPOLL_TABLE);
        db.execSQL(DROP_GIVENANSWER_TABLE);
        db.execSQL(DROP_POLLHISTORY_TABLE);
        db.execSQL(DROP_POLL_TABLE);
        db.execSQL(DROP_QUESTIONS_TABLE);
        onCreate(db);
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean checkUser(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }
//accesscode populate
public void addAccessCode(AccessCode code){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();

    values.put(COLUMN_ACCESS_CODE, code.getAccessCode());

    db.insert(TABLE_ACCESSCODE, null, values);
    db.close();

}
//accountinfo populate
public void addAccountInfo(AccountInfo account){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();

    values.put(COLUMN_ACCOUNT_ID, account.getId());

    db.insert(TABLE_ACCOUNTINFO, null, values);
    db.close();

}
    //answers populate
    public void addAnwers(Answers answers){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_ANSWER, answers.getAnswer());

        db.insert(TABLE_ANSWERS, null, values);
        db.close();

    }
    //createpoll populate
    public void addCreatePoll(CreatePoll createPoll){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_CREATEPOLL_CODE, createPoll.getCode());
        values.put(COLUMN_CREATEPOLL_ID, createPoll.getId());
        values.put(COLUMN_CREATEPOLL_OPTIONS, createPoll.getOptions());
        values.put(COLUMN_CREATEPOLL_TITLE, createPoll.getTitle());

        db.insert(TABLE_CREATEPOLL, null, values);
        db.close();

    }
    //givenanswer populate
    public void addGivenAnswer(GivenAnswer givenAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_GIVENANSWER, givenAnswer.getGivenAnswer());

        db.insert(TABLE_GIVENANSWER, null, values);
        db.close();

    }
    //poll populate
    public void addPoll(Poll poll){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_POLLTITLE, poll.getPollTitle());
        values.put(COLUMN_POLLANSWER_, poll.getPollAnswer());
        values.put(COLUMN_POLLQUESTION, poll.getPollQuestion());

        db.insert(TABLE_POLL, null, values);
        db.close();

    }
    //pollhitory populate
    public void addPollHistory(PollHistroy pollHistroy){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_POLLHISTORY_TITLE, pollHistroy.getTitle());

        db.insert(TABLE_POLLHISTORY, null, values);
        db.close();

    }
    //questions populate
    public void addQuestions(Questions questions){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_QUESTIONS, questions.getQuestion());

        db.insert(TABLE_QUESTIONS, null, values);
        db.close();

    }
}

package duydev.com.foodorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by duy dev on 10/17/2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context, int version) {
        super(context, "coco5.sqlite", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS USER(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "USER_EMAIL TEXT, USER_PASS TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

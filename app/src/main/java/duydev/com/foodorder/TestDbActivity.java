package duydev.com.foodorder;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;

public class TestDbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_db);
        DBHelper dbHelper = new DBHelper(this, 1);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
//        String sql = "CREATE TABLE FOOD(FOOD_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "FOOD_NAME TEXT, FOOD_PRICE INTEGER,FOOD_ICON BLOB, MENU_ID INTEGER," +
//                "FOREIGN KEY(MENU_ID) REFERENCES MENU(MENU_ID))";
//        sqLiteDatabase.execSQL(sql);
        String []names = {"Lẩu cá hồi", "Chả cuốn bí xanh lạ mà ngon", "Mì spaghetti xúc xích hải sản", "Trà đào ngâm"};
        int []prices = {150000, 25000, 49000, 12000};
        int []images = {R.drawable.ic_item_food, R.drawable.ic_chacuon, R.drawable.ic_mi, R.drawable.ic_tra};
        for(int i = 0 ; i < 2; i++){
            ContentValues values = new ContentValues();
            values.put("FOOD_NAME", names[i]);
            values.put("FOOD_PRICE", prices[i]);
            values.put("FOOD_ICON", convertImage(images[i]));
            values.put("MENU_ID", 7);
            sqLiteDatabase.insert("FOOD", null, values);
        }
        sqLiteDatabase.close();
//        String sql = "SELECT * FROM MENU";
//        sqLiteDatabase.rawQuery(sql, null);
//        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
//        if(cursor.moveToFirst()){
//
//            do{
//                Log.d("Kiem tra",cursor.getString(1) + "");
//            }while (cursor.moveToNext());
//        }
//        Log.d("Kiem tra","k co");
    }
    public byte[] convertImage(int res){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), res);
        ByteArrayOutputStream outputStreamStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStreamStream);
        return outputStreamStream.toByteArray();
    }
}

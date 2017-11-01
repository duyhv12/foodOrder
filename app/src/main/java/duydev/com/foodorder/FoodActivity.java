package duydev.com.foodorder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerFoodAdapter;

public class FoodActivity extends AppCompatActivity {
    private RecyclerView rcvFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //get data from menu activity
        int menu_id = getIntent().getIntExtra("menu_id", -1);

        rcvFood = (RecyclerView) findViewById(R.id.rcvFood);
        //get data from id menu
        String sql = "SELECT * FROM FOOD WHERE MENU_ID = " + menu_id;
        DBHelper dbHelper = new DBHelper(this, 1);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        List<ItemFood>items = new ArrayList<>();
        if(cursor.moveToFirst()){

            do{

                String name = cursor.getString(1);
                int price = cursor.getInt(2);
                byte []icFood = cursor.getBlob(3);
                Bitmap bitmap = BitmapFactory.decodeByteArray(icFood, 0, icFood.length);
                items.add(new ItemFood(name, price, bitmap));
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();

        RecyclerFoodAdapter adapter = new RecyclerFoodAdapter(this, items);
        rcvFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rcvFood.setAdapter(adapter);
    }
}

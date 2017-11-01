package duydev.com.foodorder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerMenuAdapter;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //load database
        DBHelper dbHelper = new DBHelper(this, 1);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "SELECT * FROM MENU";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        List<ItemMenu>items = new ArrayList<>();
        if(cursor.moveToFirst()){

            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                byte []image = cursor.getBlob(2);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                items.add(new ItemMenu(id,name, bitmap));
            }while(cursor.moveToNext());
        }
        RecyclerView rcvMenu = (RecyclerView) findViewById(R.id.rcvMenu);
        rcvMenu.setLayoutManager(new GridLayoutManager(this, 2));
        RecyclerMenuAdapter adapter = new RecyclerMenuAdapter(this, items);
        rcvMenu.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

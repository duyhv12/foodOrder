package duydev.com.foodorder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerAdapter;

public class DetailActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private RecyclerView rcvData;
    private List<ItemTable>items;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private SearchView mMSearchView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.navagation_drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        items = new ArrayList<>();
        //GET DATABASE
        DBHelper dbHelper = new DBHelper(this, 1);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String sql = "SELECT * FROM DESK";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if(cursor.moveToFirst()){

            do{
                String name = cursor.getString(1);
                byte []image = cursor.getBlob(2);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                items.add(new ItemTable(name, bitmap));
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();

        rcvData = (RecyclerView)findViewById(R.id.rcvData);
        GridLayoutManager layout = new GridLayoutManager(this, 4);
        rcvData.setLayoutManager(layout);
        adapter = new RecyclerAdapter(this, items);
        rcvData.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem menuItem = menu.findItem(R.id.itemSearch);
        mMSearchView = (SearchView)menuItem.getActionView();
        mMSearchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<ItemTable>itemSearch = new ArrayList<>();
        for(ItemTable text : items){
            if(text.getNameTable().toLowerCase().contains(newText)) {
                itemSearch.add(text);
            }
        }
        adapter = new RecyclerAdapter(this, itemSearch);
        rcvData.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return true;
    }
}

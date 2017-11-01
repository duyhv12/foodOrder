package duydev.com.foodorder;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.ViewPagerAdapter;
import fragment.FragmentLogin;
import fragment.FragmentSlider;

public class MainActivity extends AppCompatActivity{

    private List<ItemSlider>itemSliders;
    private Fragment []fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("coco5", MODE_PRIVATE);
        String user = sharedPreferences.getString("user", "");
        if(!user.equals("")){
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
            finish();
        }
        itemSliders = new ArrayList<>();
        fragments = new Fragment[4];

        itemSliders.add(new ItemSlider(R.drawable.logo, "Trà sữa đậm phong cách", "đúng điệu", R.drawable.item_slider_2, R.drawable.item_slider_1, R.drawable.item_slider_1));
        itemSliders.add(new ItemSlider(R.drawable.logo_2, "Món ăn phong phú đậm", "chất thái lan", R.drawable.item_slider_1, R.drawable.item_slider_2, R.drawable.item_slider_1));
        itemSliders.add(new ItemSlider(R.drawable.logo_3, "Không chỉ đơn thuần là ẩm", "thực thái.", R.drawable.item_slider_1, R.drawable.item_slider_1, R.drawable.item_slider_2));

        for (int i = 0 ; i < itemSliders.size(); i++){
            FragmentSlider fragment1 = new FragmentSlider();
            Bundle bundle = new Bundle();
            bundle.putSerializable("slider", itemSliders.get(i));
            fragment1.setArguments(bundle);
            fragments[i] = fragment1;
        }
        FragmentLogin fragment2 = new FragmentLogin();
        fragments[3] = fragment2;

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this, fragments);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpgContent);
        viewPager.setAdapter(adapter);


    }

}

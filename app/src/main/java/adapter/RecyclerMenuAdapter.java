package adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import duydev.com.foodorder.FoodActivity;
import duydev.com.foodorder.ItemMenu;
import duydev.com.foodorder.R;

/**
 * Created by duy dev on 10/19/2017.
 */

public class RecyclerMenuAdapter extends RecyclerView.Adapter<RecyclerMenuAdapter.MyHolder>{

    private Context context;
    private List<ItemMenu> items;

    public RecyclerMenuAdapter(Context context, List<ItemMenu>items){
        this.context = context;
        this.items = items;
        Log.d("kiem tra 1", items.size() + "");
    }
    @Override
    public RecyclerMenuAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_table,parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerMenuAdapter.MyHolder holder, final int position) {
        holder.icTable.setImageBitmap(items.get(position).getImage());
        holder.nameTable.setText(items.get(position).getName());
        holder.icTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FoodActivity.class);
                intent.putExtra("menu_id", items.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private ImageView icTable;
        private TextView nameTable;
        public MyHolder(View itemView) {
            super(itemView);
            icTable = (ImageView) itemView.findViewById(R.id.icTable);
            nameTable = (TextView) itemView.findViewById(R.id.nameTable);
        }
    }
}

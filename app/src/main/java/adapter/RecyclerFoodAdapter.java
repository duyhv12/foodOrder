package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import duydev.com.foodorder.ItemFood;
import duydev.com.foodorder.ItemMenu;
import duydev.com.foodorder.R;

/**
 * Created by duy dev on 10/19/2017.
 */

public class RecyclerFoodAdapter extends RecyclerView.Adapter<RecyclerFoodAdapter.MyHolder>{

    private Context context;
    private List<ItemFood> items;

    public RecyclerFoodAdapter(Context context, List<ItemFood>items){
        this.context = context;
        this.items = items;
    }
    @Override
    public RecyclerFoodAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_food,parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerFoodAdapter.MyHolder holder, int position) {
        holder.icFood.setImageBitmap(items.get(position).getIcFood());
        holder.nameFood.setText(items.get(position).getName());
        holder.priceFood.setText(items.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private ImageView icFood;
        private TextView nameFood;
        private TextView priceFood;
        public MyHolder(View itemView) {
            super(itemView);
            icFood = (ImageView) itemView.findViewById(R.id.imFood);
            nameFood = (TextView) itemView.findViewById(R.id.tvNameFood);
            priceFood = (TextView) itemView.findViewById(R.id.tvPriceFood);
        }
    }
}

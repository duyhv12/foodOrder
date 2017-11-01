package adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import duydev.com.foodorder.ItemTable;
import duydev.com.foodorder.MenuActivity;
import duydev.com.foodorder.R;

/**
 * Created by duy dev on 10/19/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    private Context context;
    private List<ItemTable> items;

    public RecyclerAdapter(Context context, List<ItemTable>items){
        this.context = context;
        this.items = items;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_table, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.icTable.setImageBitmap(items.get(position).getIcTablel());
        holder.nameTable.setText(items.get(position).getNameTable());
        holder.icTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.layout_custom_dialog);
                ImageView icOrder = (ImageView) dialog.findViewById(R.id.icOrder);
                ImageView icCard = (ImageView) dialog.findViewById(R.id.icCard);
                TextView tvCancel = (TextView) dialog.findViewById(R.id.tvCancel);
                icOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, MenuActivity.class);
                        context.startActivity(intent);
                        dialog.dismiss();
                    }
                });
                icCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                tvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class  MyHolder extends RecyclerView.ViewHolder{
        ImageView icTable;
        TextView nameTable;

        public MyHolder(View itemView) {
            super(itemView);
            icTable = (ImageView) itemView.findViewById(R.id.icTable);
            nameTable = (TextView) itemView.findViewById(R.id.nameTable);
        }
    }
}

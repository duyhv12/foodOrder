package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import duydev.com.foodorder.ItemSlider;
import duydev.com.foodorder.R;

/**
 * Created by duy dev on 10/16/2017.
 */

public class FragmentSlider extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_slider, container, false);

        ImageView imLogo = (ImageView) view.findViewById(R.id.imLogo);
        TextView tvSlogan1 = (TextView) view.findViewById(R.id.tvSlogan1);
        TextView tvSlogan2 = (TextView) view.findViewById(R.id.tvSlogan2);
        ImageView imItemSlider1 = (ImageView) view.findViewById(R.id.itemSlider1);
        ImageView imItemSlider2 = (ImageView) view.findViewById(R.id.itemSlider2);
        ImageView imItemSlider3 = (ImageView) view.findViewById(R.id.itemSlider3);

        ItemSlider itemSlider = (ItemSlider) getArguments().getSerializable("slider");

        imLogo.setImageResource(itemSlider.getImLogo());
        tvSlogan1.setText(itemSlider.getSlogan1());
        tvSlogan2.setText(itemSlider.getSlogan2());
        imItemSlider1.setImageResource(itemSlider.getImItemSlider1());
        imItemSlider2.setImageResource(itemSlider.getImItemSlider2());
        imItemSlider3.setImageResource(itemSlider.getImItemSlider3());

        return view;
    }
}

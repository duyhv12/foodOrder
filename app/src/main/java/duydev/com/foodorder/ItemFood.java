package duydev.com.foodorder;

import android.graphics.Bitmap;

/**
 * Created by duy dev on 10/20/2017.
 */

public class ItemFood {

    private String name;
    private int price;
    private Bitmap icFood;

    public ItemFood(String name, int price, Bitmap icFood) {
        this.name = name;
        this.price = price;
        this.icFood = icFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Bitmap getIcFood() {
        return icFood;
    }

    public void setIcFood(Bitmap icFood) {
        this.icFood = icFood;
    }
}

package duydev.com.foodorder;

import android.graphics.Bitmap;

/**
 * Created by duy dev on 10/19/2017.
 */

public class ItemMenu {
    private int id;
    private String name;
    private Bitmap image;

    public ItemMenu(int id, String name, Bitmap image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

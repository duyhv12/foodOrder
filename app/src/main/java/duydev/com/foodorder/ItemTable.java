package duydev.com.foodorder;

import android.graphics.Bitmap;

/**
 * Created by duy dev on 10/19/2017.
 */

public class ItemTable {
    private String nameTable;
    private Bitmap icTablel;

    public ItemTable(String nameTable, Bitmap icTablel) {
        this.nameTable = nameTable;
        this.icTablel = icTablel;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public Bitmap getIcTablel() {
        return icTablel;
    }

    public void setIcTablel(Bitmap icTablel) {
        this.icTablel = icTablel;
    }
}

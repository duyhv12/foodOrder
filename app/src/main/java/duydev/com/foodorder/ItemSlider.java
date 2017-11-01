package duydev.com.foodorder;

import java.io.Serializable;

/**
 * Created by duy dev on 10/16/2017.
 */

public class ItemSlider implements Serializable {

    private int imLogo;
    private String slogan1;
    private String slogan2;
    private int imItemSlider1;
    private int imItemSlider2;
    private int imItemSlider3;

    public ItemSlider(int imLogo, String slogan1, String slogan2, int imItemSlider1, int imItemSlider2, int imItemSlider3) {
        this.imLogo = imLogo;
        this.slogan1 = slogan1;
        this.slogan2 = slogan2;
        this.imItemSlider1 = imItemSlider1;
        this.imItemSlider2 = imItemSlider2;
        this.imItemSlider3 = imItemSlider3;
    }

    public int getImLogo() {
        return imLogo;
    }

    public void setImLogo(int imLogo) {
        this.imLogo = imLogo;
    }

    public String getSlogan1() {
        return slogan1;
    }

    public void setSlogan1(String slogan1) {
        this.slogan1 = slogan1;
    }

    public String getSlogan2() {
        return slogan2;
    }

    public void setSlogan2(String slogan2) {
        this.slogan2 = slogan2;
    }

    public int getImItemSlider1() {
        return imItemSlider1;
    }

    public void setImItemSlider1(int imItemSlider1) {
        this.imItemSlider1 = imItemSlider1;
    }

    public int getImItemSlider2() {
        return imItemSlider2;
    }

    public void setImItemSlider2(int imItemSlider2) {
        this.imItemSlider2 = imItemSlider2;
    }

    public int getImItemSlider3() {
        return imItemSlider3;
    }

    public void setImItemSlider3(int imItemSlider3) {
        this.imItemSlider3 = imItemSlider3;
    }
}

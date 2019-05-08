package Sokoban;

import java.awt.Image;

public class Karakter {

	private final int Bosluk = 20;

    private int x;
    private int y;
    private Image image;

    public Karakter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean Sol_Hareket(Karakter adam) {
        if (((this.x() - Bosluk) == adam.x()) &&
            (this.y() == adam.y())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Sag_Hareket(Karakter adam) {
        if (((this.x() + Bosluk) == adam.x())
                && (this.y() == adam.y())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Ust_Hareket(Karakter adam) {
        if (((this.y() - Bosluk) == adam.y()) &&
            (this.x() == adam.x())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Alt_Hareket(Karakter adam) {
        if (((this.y() + Bosluk) == adam.y())
                && (this.x() == adam.x())) {
            return true;
        } else {
            return false;
        }
    }
}
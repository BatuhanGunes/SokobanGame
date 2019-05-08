package Sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Kutu extends Karakter {
	
	public Kutu(int x, int y) {
        super(x, y);
        URL loc = this.getClass().getResource("kutu.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }

    public void Kutu_Hareket(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
    }

}

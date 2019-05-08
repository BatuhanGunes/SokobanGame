package Sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Sokoban extends Karakter {

	public Sokoban(int x, int y) {
        super(x, y);

        URL loc = this.getClass().getResource("sokoban.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }

    public void Hareket(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
    }
}

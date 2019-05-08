package Sokoban;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Fayans extends Karakter {
	
	public Fayans(int x, int y) {
        super(x, y);

        URL loc = this.getClass().getResource("hedef.png");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }

}

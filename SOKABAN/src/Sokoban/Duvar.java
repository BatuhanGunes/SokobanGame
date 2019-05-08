package Sokoban;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;


public class Duvar extends Karakter{

	private Image image;

    public Duvar(int x, int y) {
        super(x, y);

        URL loc = this.getClass().getResource("duvar.png");
        ImageIcon iia = new ImageIcon(loc);
        image = iia.getImage();
        this.setImage(image);
    	
    }
}

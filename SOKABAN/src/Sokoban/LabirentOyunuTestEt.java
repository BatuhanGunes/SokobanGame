package Sokoban;

import javax.swing.JFrame;

public class LabirentOyunuTestEt extends JFrame {

private final int Bos = 30;
	
	public LabirentOyunuTestEt(){
		InitUI();
	}
	
    public void InitUI() {
        Labirent labirent = new Labirent();
        add(labirent);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(labirent.getHaritaWidth() + Bos, labirent.getHaritaHeight() + 2*Bos);
        setLocationRelativeTo(null);
        setTitle("Sokoban");
    }

	public static void main(String[] args) {
		
		LabirentOyunuTestEt testprogram = new LabirentOyunuTestEt();
		testprogram.setVisible(true);
		testprogram.setResizable(false);
	}
}

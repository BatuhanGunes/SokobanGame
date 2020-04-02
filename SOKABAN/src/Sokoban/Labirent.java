package Sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Labirent extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final int Dolu = 30;
    private final int Bos = 20;
    private final int Sol_Carpisma = 1;
    private final int Sag_Carpisma = 2;
    private final int Ust_Carpisma = 3;
    private final int Alt_Carpisma = 4;

    private ArrayList<Karakter> Duvarlar = new ArrayList<Karakter>();
    private ArrayList<Karakter> Kutular = new ArrayList<Karakter>();
    private ArrayList<Karakter> Fayanslar = new ArrayList<Karakter>();
    private Sokoban soko;
    private int w = 0;
    private int h = 0;
    private boolean Tamamlandi = false;
    

   
    private String level =
    		
    " , , ,#,#,#,#,#, , , , , , , , \n"+
    " , , ,#, , , ,#, , , , , , , , \n"+
    " , , ,#, ,$,$,#,#,#,#, , , , , \n"+
    " , , ,#, , ,$, ,$, ,#, , , , , \n"+
    " , , ,#, ,$,#, , , ,#, , , , , \n"+
    "#,#,#,#, , ,#,#,$, ,#,#,#,#,#,#\n"+
    "#,@, , , , ,#,#, , , , , ,.,.,#\n"+
    "#,#, , , , , , , , , , , ,.,.,#\n"+
    " ,#,#,#,#,#,#,#,#,#,#, , ,.,.,#\n"+
    " , , , , , , , , , ,#,#,#,#,#,#\n";
    		
    	
 
    public Labirent() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        Oyunicinde();
    }

    public int getHaritaWidth() {
        return this.w;
    }

    public int getHaritaHeight() {
        return this.h;
    }

    public final void Oyunicinde() {
        
        int x = Dolu;
        int y = Dolu;
        
        Duvar duvar;
        Kutu k;
        Fayans z;


        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            if (item == '\n') {
                y += Bos;
                if (this.w < x) {
                    this.w = x;
                }

                x = Dolu;
            } else if (item == '#') {
                duvar = new Duvar(x, y);
                Duvarlar.add(duvar);
                x += Bos;
            } else if (item == '$') {
                k = new Kutu(x, y);
                Kutular.add(k);
                x += Bos;
            } else if (item == '.') {
                z = new Fayans(x, y);
                Fayanslar.add(z);
                x += Bos;
            } else if (item == '@') {
                soko = new Sokoban(x, y);
                x += Bos;
            } else if (item == ' ') {
                x += Bos;
            }
            
            h = y;
        }}

    public void OyunuOlustur(Graphics g) {

        g.setColor(new Color(250, 240, 170));	// Arka planin rengini Degistirir
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList<Karakter> Oyun = new ArrayList<Karakter>();
        Oyun.addAll(Duvarlar);
        Oyun.addAll(Fayanslar);
        Oyun.addAll(Kutular);
        Oyun.add(soko);
       
        for (int i = 0; i < Oyun.size(); i++) {

            Karakter item = (Karakter) Oyun.get(i);

            if ((item instanceof Sokoban)
                    || (item instanceof Kutu)) {
                g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
            } else {
                g.drawImage(item.getImage(), item.x(), item.y(), this);
            }

            if (Tamamlandi) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Tebrikler", 25, 20);
            }}}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        OyunuOlustur(g);
    }

    		class TAdapter extends KeyAdapter {

        @Override
    public void keyPressed(KeyEvent e) {

            if (Tamamlandi) {
                return;
            }

            
            int key = e.getKeyCode();


            if (key == KeyEvent.VK_LEFT) {
                if (DuvarKontrol(soko,
                        Sol_Carpisma)) {
                    return;
                }

                if (KutuKontrol(Sol_Carpisma)) {
                    return;
                }

                soko.Hareket(-Bos, 0);

            } else if (key == KeyEvent.VK_RIGHT) {

                if (DuvarKontrol(soko,
                		Sag_Carpisma)) {
                    return;
                }

                if (KutuKontrol(Sag_Carpisma)) {
                    return;
                }

                soko.Hareket(Bos, 0);

            } else if (key == KeyEvent.VK_UP) {

                if (DuvarKontrol(soko,
                		Ust_Carpisma)) {
                    return;
                }

                if (KutuKontrol(Ust_Carpisma)) {
                    return;
                }

                soko.Hareket(0, -Bos);

            } else if (key == KeyEvent.VK_DOWN) {

                if (DuvarKontrol(soko,
                		Alt_Carpisma)) {
                    return;
                } 
                if (KutuKontrol(Alt_Carpisma)) {
                    return;
                }
                soko.Hareket(0, Bos);
            } else if (key == KeyEvent.VK_R) {
                TekrarBaslat();
            }repaint();
        }}

    private boolean DuvarKontrol(Karakter adam, int S) {

        if (S == Sol_Carpisma) {

            for (int i = 0; i < Duvarlar.size(); i++) {
                Duvar duvar = (Duvar) Duvarlar.get(i);
                if (adam.Sol_Hareket(duvar)) {
                    return true;
                }}return false;

        } else if (S == Sag_Carpisma) {

            for (int i = 0; i < Duvarlar.size(); i++) {
                Duvar duvar = (Duvar) Duvarlar.get(i);
                if (adam.Sag_Hareket(duvar)) {
                    return true;
                }}return false;

        } else if (S == Ust_Carpisma) {

            for (int i = 0; i < Duvarlar.size(); i++) {
                Duvar duvar = (Duvar) Duvarlar.get(i);
                if (adam.Ust_Hareket(duvar)) {
                    return true;
                }} return false;

        } else if (S == Alt_Carpisma) {

            for (int i = 0; i < Duvarlar.size(); i++) {
                Duvar duvar = (Duvar) Duvarlar.get(i);
                if (adam.Alt_Hareket(duvar)) {
                    return true;
                } }return false;
        }return false;
    }

    private boolean KutuKontrol(int S) {

        if (S == Sol_Carpisma) {

            for (int i = 0; i < Kutular.size(); i++) {

                Kutu kutu = (Kutu) Kutular.get(i);
                if (soko.Sol_Hareket(kutu)) {

                    for (int j=0; j < Kutular.size(); j++) {
                        Kutu item = (Kutu) Kutular.get(j);
                        if (!kutu.equals(item)) {
                            if (kutu.Sol_Hareket(item)) {
                                return true;
                            } }
                        if (DuvarKontrol(kutu,
                                Sol_Carpisma)) {
                            return true;
                        }}
                    
                    kutu.Kutu_Hareket(-Bos, 0);
                    Tamamlandi();
                }}return false;

        } else if (S == Sag_Carpisma) {

            for (int i = 0; i < Kutular.size(); i++) {

                Kutu kutu = (Kutu) Kutular.get(i);
                if (soko.Sag_Hareket(kutu)) {
                    for (int j=0; j < Kutular.size(); j++) {

                        Kutu item = (Kutu) Kutular.get(j);
                        if (!kutu.equals(item)) {
                            if (kutu.Sag_Hareket(item)) {
                                return true;
                            }}
                        if (DuvarKontrol(kutu,
                                Sag_Carpisma)) {
                            return true;
                        }}
                    kutu.Kutu_Hareket(Bos, 0);
                    Tamamlandi();                   
                }}return false;

        } else if (S == Ust_Carpisma) {

            for (int i = 0; i < Kutular.size(); i++) {

                Kutu kutu = (Kutu) Kutular.get(i);
                if (soko.Ust_Hareket(kutu)) {
                    for (int j = 0; j < Kutular.size(); j++) {

                        Kutu item = (Kutu) Kutular.get(j);
                        if (!kutu.equals(item)) {
                            if (kutu.Ust_Hareket(item)) {
                                return true;
                            } }
                        if (DuvarKontrol(kutu,
                                Ust_Carpisma)) {
                            return true;
                        }}
                    kutu.Kutu_Hareket(0, -Bos);
                    Tamamlandi();
                }} return false;
        } else if (S == Alt_Carpisma) {
        
            for (int i = 0; i < Kutular.size(); i++) {

                Kutu kutu = (Kutu) Kutular.get(i);
                if (soko.Alt_Hareket(kutu)) {
                    for (int j = 0; j < Kutular.size(); j++) {

                        Kutu item = (Kutu) Kutular.get(j);
                        if (!kutu.equals(item)) {
                            if (kutu.Alt_Hareket(item)) {
                                return true;
                            }}
                        if (DuvarKontrol(kutu,
                                Alt_Carpisma)) {
                            return true;
                        }}
                    kutu.Kutu_Hareket(0, Bos);
                    Tamamlandi();
                }}} return false;
    }
   
    public void Tamamlandi() {

        int num = Kutular.size();
        int Bitti = 0;

        for (int i = 0; i < num; i++) {
            Kutu kutu = (Kutu) Kutular.get(i);
            for (int j = 0; j < num; j++) {
                Fayans fyns = (Fayans) Fayanslar.get(j);
                if (kutu.x() == fyns.x()
                        && kutu.y() == fyns.y()) {
                    Bitti += 1;
                }}}
        
        if (Bitti == num) {
            Tamamlandi = true;
            repaint();
       } }
    

  
    public void TekrarBaslat() {

        Fayanslar.clear();
        Kutular.clear();
        Duvarlar.clear();
        Oyunicinde();
        if (Tamamlandi) {
            Tamamlandi = false;
}}}
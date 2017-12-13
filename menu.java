package deadlyzombies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class menu {
public void render (Graphics g) {
	Font fnt0=new Font ("algerian",Font.BOLD,25);
	Font fnt1=new Font ("Agency FB",Font.BOLD,50);
	g.setFont(fnt0);
	g.setColor(Color.BLACK);
	g.drawString("reverse edition", 588, 75);
	//g.drawString("reverse edition", 588, 75);
	//g.drawString("reverse edition", 588, 75);
	 g.setColor(new Color(255,255,255,128));
     g.fillRect(20, 20, 150, 70);
     g.fillRect(20, 95, 150, 70);
     g.fillRect(20, 170, 150, 70);
     g.setFont(fnt1);
     g.setColor(Color.RED);
 	g.drawString("PLAY",50, 70);
 	g.setColor(Color.black);
 	g.drawString("HELP",50, 145);
 	g.drawString("QUIT",50, 220);
}
}

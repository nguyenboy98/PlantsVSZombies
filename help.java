package deadlyzombies;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class help {
public void render (Graphics g) {
	Font fnt2=new Font ("algerian",Font.BOLD,25);
	Font fnt3=new Font ("Baskerville Old Face",Font.ITALIC,12);
	g.setFont(fnt2);
     g.setColor(Color.RED);
 	g.drawString("RULE:",60, 280);
 	  g.setFont(fnt2);
 	g.setColor(Color.black);
 	g.drawString("HELP",50, 145);
 	g.drawString("QUIT",50, 220);
}
}
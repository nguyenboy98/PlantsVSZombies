package deadlyzombies;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Help {
public void render (Graphics g) {
	Font fnt2=new Font ("algerian",Font.BOLD,25);
	Font fnt3=new Font ("Baskerville Old Face",Font.ITALIC,12);
	g.setFont(fnt2);
     g.setColor(Color.RED);
 	g.drawString("RULE:",60, 280);
 	  g.setFont(fnt3);
 	
 	Image i1=Toolkit.getDefaultToolkit().getImage("./res/select1.jpg");  
    g.drawImage(i1, 500, 260, 60, 60, null);
    Image i2=Toolkit.getDefaultToolkit().getImage("./res/select2.jpg");  
    g.drawImage(i2, 500, 325, 60, 60, null);
    Image i3=Toolkit.getDefaultToolkit().getImage("./res/select3.jpg");  
    g.drawImage(i3, 500, 390, 60, 60, null);
    Image i4=Toolkit.getDefaultToolkit().getImage("./res/selec4.jpg");  
    g.drawImage(i4,500, 455, 60, 60, null);
    Image i5=Toolkit.getDefaultToolkit().getImage("./res/select5.jpg");  
    g.drawImage(i5, 900, 260, 60, 60, null);
    Image i6=Toolkit.getDefaultToolkit().getImage("./res/select6.jpg");  
    g.drawImage(i6, 900, 325, 60, 60, null);
    g.setColor(Color.black);
 	g.drawString("Health: 45",570, 290);
 	g.drawString("Health: 85",570, 355);
 	g.drawString("Health: 85",570, 420);
 	g.drawString("Health: 75",570, 485);
 	g.drawString("Health: 195",970, 290);
 	g.drawString("Health: 55",970, 355);

 	
 	
}}
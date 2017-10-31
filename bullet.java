package deadlyzombies;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class bullet extends Object {
//Random r= new Random();
    //ID (id) = new ID;
	private BufferedImage bg,bullet;
	public bullet(int x, int y, ID id) {
		super(x, y, id);
	    //velX=r.nextInt(4)+1;
		//velY=r.nextInt(4);
		velX=3;
	}
public void tick() {
	/*if(x==game.WIDTH||y==game.HEIGHT||x==0||y==0)
	{velX=-velX;	
	 velY=-velY;}*/
		x+=velX;
		y+=velY;
}
public void render (Graphics g) {
	//g.setColor(Color.white);
	//g.fillRect(x,y,30,30);
//	try {
//		bg= ImageIO.read(new File("C:\\Users\\nguye\\Desktop\\Regular_Zombie.png"));
//	    g.drawImage(bg,0,0,null);
        Image i=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\bullet.png");  
        g.drawImage(i, x, y, 50, 50, null);
       
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
	}
}

package deadlyzombies;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class FireBullet extends Object {
private static final Object objec = null;

	private BufferedImage bg,bullet;
	Handler handler;
	private Object object;
	public FireBullet(int x, int y, ID id,Handler handler) {
		super(x, y, id);
	   
		velX=3;
		this.handler=handler;
	}
	public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y, 20,20);
}
	
public void tick() {
	
		x+=velX;
		y+=velY;
		
}


public void render (Graphics g) {
	g.setColor(new Color(255,255,255,0));
	g.fillRect(x,y,20,20);

        Image i=Toolkit.getDefaultToolkit().getImage("./res/bullet.png");  
        g.drawImage(i, x, y, 50, 50, null);
       

	}

}



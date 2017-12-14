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
//Random r= new Random();
    //ID (id) = new ID;
	private BufferedImage bg,bullet;
	Handler handler;
	private Object object;
	public FireBullet(int x, int y, ID id,Handler handler) {
		super(x, y, id);
	    //velX=r.nextInt(4)+1;
		//velY=r.nextInt(4);
		velX=3;
		this.handler=handler;
	}
	public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y, 20,20);
}
	
public void tick() {
	/*if(x==game.WIDTH||y==game.HEIGHT||x==0||y==0)
	{velX=-velX;	
	 velY=-velY;}*/
		x+=velX;
		y+=velY;
		//collision();
}
/*private void collision(){

    for(int i = 0; i < handler.object.size(); i++){
    Object tempObject = handler.object.get(i);
    if(tempObject.getId() == ID.zombies/* || tempObject.getId()==ID.FastEnemy||tempObject.getId()== ID.SmartEnemy){
                    if(getBounds().intersects(tempObject.getBounds())){
                    	zombies.HEALTH-= 5;
                    	System.out.print(zombies.HEALTH);
                    
                    	
                   if(zombies.HEALTH==80)
                    	{handler.removeObject(handler.object.get(i)); 
                    	zombies.HEALTH=100;}
                   
                    handler.removeObject(this);
                    handler.addObject(new bullet(295,y,ID.bullet,handler) );
                    }
            }
    }
 }*/

public void render (Graphics g) {
	g.setColor(new Color(255,255,255,0));
	g.fillRect(x,y,20,20);

        Image i=Toolkit.getDefaultToolkit().getImage("./res/bullet.png");  
        g.drawImage(i, x, y, 50, 50, null);
       

	}

}



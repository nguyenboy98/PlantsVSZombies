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

public class ZombieFly extends Object {

	Handler handler;
	
	private BufferedImage bg,Regular_Zombie;
	
	
	protected int HEALTH=55;
	public ZombieFly(int x, int y, ID id,Handler handler) {
		
		super(x, y, id);
	   
		
		this.handler=handler;
		this.HEALTH=HEALTH;
	
		
		
		
	}
	 public Rectangle getBounds(){
         return new Rectangle((int) x,(int) y, 32, 32);
         
 }
public void tick() {
	
	if(HEALTH==5) {velX=0;}
		x-=velX;
		y-=velY;
		velX=2;
		collision();
		if(x<240) {handler.removeObject(this);}
}
private void collision(){

    for(int i = 0; i < handler.object.size(); i++){
    Object tempObject = handler.object.get(i);
    if(tempObject.getId() == ID.bullet){
                    if(getBounds().intersects(tempObject.getBounds())){
                    	HEALTH-= 5;
                    	System.out.print(HEALTH);
                    
                    	handler.removeObject(handler.object.get(i));
                   
                    }
                   
            }
    if(tempObject.getId() == ID.firebullet){
        if(getBounds().intersects(tempObject.getBounds())){
        	HEALTH-= 20;
        	System.out.print(HEALTH);
        
        	handler.removeObject(handler.object.get(i));
       
        }
        
}
    if(HEALTH<=0)
	{handler.removeObject(this);
	Game.zombiescount--;
	}    
    
    if(tempObject.getId() == ID.plants || tempObject.getId()==ID.potatoplants||tempObject.getId()== ID.iceplants){
         if(getBounds().intersects(tempObject.getBounds())){velX=0;}
        }
    }
 }

public void render (Graphics g) {
	g.setColor(new Color(255,255,255,0));
	g.fillRect(x,y,30,30);
if(HEALTH==5) {Image i=Toolkit.getDefaultToolkit().getImage("./res/die3.gif");  
                g.drawImage(i, x-10, y, 100, 100, null);
                }
else { Image i=Toolkit.getDefaultToolkit().getImage("./res/fly2.gif");  
        g.drawImage(i, x-10, y, 100, 100, null);}
        
       

       

	}

}



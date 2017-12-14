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

public class Plants extends Object {

	Handler handler;
	private BufferedImage bg,plants;
	private int HEALTH=100;
	int t=0;

	public Plants(int x, int y, ID id,Handler handler) {
		super(x, y, id);
	    
		velX=0;
		this.handler=handler;
		this.HEALTH=HEALTH;
	}
	 public Rectangle getBounds(){
         return new Rectangle((int) x+30,(int) y+30, 60, 50);}
public void tick() {
		t++;
	
		x+=velX;
		y+=velY;
		collision();
		
		if(t>250) {t=0;}
}
private void collision(){
    for(int i = 0; i < handler.object.size(); i++){
    Object tempObject = handler.object.get(i);
    if(tempObject.getId() == ID.zombiehard ||tempObject.getId()== ID.zombiebuck||tempObject.getId()== ID.zombiefly||tempObject.getId()== ID.zombiefootball||tempObject.getId()== ID.zombiegiant||tempObject.getId()== ID.zombies){
                    if(getBounds().intersects(tempObject.getBounds())){
                    
                    	
                    	HEALTH-=1;
                    	if(HEALTH==0)
                    	{handler.removeObject(handler.object.get(i));
                    		handler.removeObject(this);
                    		Game.countplants--;
                    	}
                    	
                    	
                    }
            }
    if(tempObject.getId() == ID.zombies && tempObject.getY() == y+7 &&t%50==0|| tempObject.getId()==ID.zombiefly&&tempObject.getY() == y+7 &&t%50==0|| tempObject.getId()==ID.zombiefootball&&tempObject.getY() == y+7 &&t%50==0|| tempObject.getId()==ID.zombiebuck&&tempObject.getY() == y+7 &&t%50==0|| tempObject.getId()==ID.zombiegiant&&tempObject.getY() == y+7 &&t%50==0|| tempObject.getId()==ID.zombiehard&&tempObject.getY() == y+7 &&t%50==0)
	 {handler.addObject(new Bullet(315,y+35,ID.bullet,handler) );}
    }
}
public void render (Graphics g) {
	g.setColor(new Color(255,255,255,0));
	g.fillRect(x+30,y+30,60,50);
   if(HEALTH<20) {Image i=Toolkit.getDefaultToolkit().getImage("./res/plantsdie.gif");  
   g.drawImage(i, x+20, y+27, 60, 60, null);}
   else{Image i=Toolkit.getDefaultToolkit().getImage("./res/plant.gif");  
        g.drawImage(i, x, y, 100, 100, null);}
       
        
	}
}

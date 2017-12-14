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

public class PotatoPlants extends Object {
//Random r= new Random();
    //ID (id) = new ID;
	Handler handler;
	private BufferedImage bg,plants;
	private int HEALTH=500;
	
	public PotatoPlants(int x, int y, ID id,Handler handler) {
		super(x, y, id);
	    //velX=r.nextInt(4)+1;
		//velY=r.nextInt(4);
		velX=0;
		this.handler=handler;
		this.HEALTH=HEALTH;
	}
	 public Rectangle getBounds(){
         return new Rectangle((int) x+30,(int) y+30, 60, 50);}
public void tick() {
	/*if(x==game.WIDTH||y==game.HEIGHT||x==0||y==0)
	{velX=-velX;	
	 velY=-velY;}*/
	
		x+=velX;
		y+=velY;
		collision();
		
}
private void collision(){
    for(int i = 0; i < handler.object.size(); i++){
    Object tempObject = handler.object.get(i);
    if(tempObject.getId() == ID.zombiehard ||tempObject.getId()== ID.zombiebuck||tempObject.getId()== ID.zombiefly||tempObject.getId()== ID.zombiefootball||tempObject.getId()== ID.zombiegiant||tempObject.getId()== ID.zombies){
                    if(getBounds().intersects(tempObject.getBounds())){
                    	
                    	
                    	HEALTH-=1;
                    	if(HEALTH==0)
                    	{//handler.removeObject(handler.object.get(i));
                    		handler.removeObject(this);
                    		Game.countplants--;
                    	}
                    	
                    	
                    }
            }
    }
}
public void render (Graphics g) {
	g.setColor(new Color(255,255,255,0));
	g.fillRect(x+30,y+30,60,50);
     if(HEALTH<250&&HEALTH>=50) {Image i=Toolkit.getDefaultToolkit().getImage("./res/potatohalf.gif");  
     g.drawImage(i, x+17, y+20, 70, 70, null);}
     else if(HEALTH<50){Image i=Toolkit.getDefaultToolkit().getImage("./res/potatodie.gif");  
        g.drawImage(i, x+17, y+20, 70, 70, null);}
     else {Image i=Toolkit.getDefaultToolkit().getImage("./res/potato.gif");  
     g.drawImage(i, x+17, y+20, 70, 70, null);}
       
        
	}
}

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

public class zombies extends Object {
//Random r= new Random();
    //ID (id) = new ID;
	Handler handler;
	
	private BufferedImage bg,Regular_Zombie;
	//static int HEALTH=100;
	
	protected int HEALTH=65;
	public zombies(int x, int y, ID id,Handler handler) {
		
		super(x, y, id);
	    //velX=r.nextInt(4)+1;
		//velY=r.nextInt(4);
		velX=1;
		
		this.handler=handler;
		this.HEALTH=HEALTH;
	
		
		//handler.addObject(new bullet(295,y+20,ID.bullet,handler) );
		
	}
	 public Rectangle getBounds(){
         return new Rectangle((int) x,(int) y, 32, 32);
         
 }
public void tick() {
	/*if(x==game.WIDTH||y==game.HEIGHT||x==0||y==0)
	{velX=-velX;	
	 velY=-velY;}*/
	if(HEALTH==05 || HEALTH==7) {velX=0;}
		x-=velX;
		y-=velY;
		collision();
}
/*private void collision(){
    for(int i = 0; i < handler.object.size(); i++){
    Object tempObject = handler.object.get(i);
    if(tempObject.getId() == ID.plants /*|| tempObject.getId()==ID.bullet/*||tempObject.getId()== ID.SmartEnemy){
                    if(getBounds().intersects(tempObject.getBounds())){
                    	System.out.print("sucess" );
                    	
                    	handler.removeObject(handler.object.get(i)); 
                    }
            }
    }
}*/
private void collision(){

    for(int i = 0; i < handler.object.size(); i++){
    Object tempObject = handler.object.get(i);
    if(tempObject.getId() == ID.bullet/* || tempObject.getId()==ID.FastEnemy||tempObject.getId()== ID.SmartEnemy*/){
                    if(getBounds().intersects(tempObject.getBounds())){
                    	HEALTH-= 5;
                    	System.out.print(HEALTH);
                    
                    	handler.removeObject(handler.object.get(i));
                   if(HEALTH==0)
                    	{handler.removeObject(this); 
                    	}
                   //handler.removeObject(handler.object.get(i));
                    
                  //  handler.addObject(new bullet(295,y+20,ID.bullet,handler) );
                    }
                    
            }
    if(tempObject.getId() == ID.plants/* || tempObject.getId()==ID.FastEnemy||tempObject.getId()== ID.SmartEnemy*/){
        if(getBounds().intersects(tempObject.getBounds())){HEALTH=7;}}
    }
 }
public void render (Graphics g) {
	//g.drawImage(LoadImage.zombie,x,y,100,100,null);
	g.setColor(new Color(255,255,255,0 ));
    g.fillRect(x,y,32,32);
if(HEALTH==5) {Image i=Toolkit.getDefaultToolkit().getImage("F:\\\\other\\\\zombie-vs-plant\\\\zombie-vs-plant\\\\zombie vs plant\\\\image\\\\die3.gif");  
                g.drawImage(i, x-10, y, 100, 100, null);
                }
else { Image i=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\zombie11.gif");  
        g.drawImage(i, x-10, y, 100, 100, null);}
        
       

       

	}

}



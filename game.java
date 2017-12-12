package deadlyzombies;
import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class game extends Canvas  implements Runnable, MouseListener, MouseMotionListener ,KeyListener {
        private static final long serialVersionUID = 1550691097823471818L;      
public static final int WIDTH = 1400, HEIGHT = 600;// WIDTH / 12 * 9;
        private Thread thread;
        private boolean running = false;
        private Handler handler;
        private Random r;
        private int n=0;
        int k1=3;
		int k2=5;
		int k3=7;
		int k4=8;
		int k5=2;
		int k6=6;
		public static int win=0;
      public game() {
    	  int x=0, y=0;
    	  new frame(WIDTH,HEIGHT,"DEADLY ZOMBIES",this);
    	  handler = new Handler();
    	  
    	  handler.addObject(new plants(250,50,ID.plants,handler) );
    	  handler.addObject(new plants(250,150,ID.plants,handler) );
    	  handler.addObject(new plants(250,250,ID.plants,handler) );
    	  handler.addObject(new plants(250,350,ID.plants,handler) );
    	  handler.addObject(new plants(250,450,ID.plants,handler) );
    	 
    	  //r=new Random();
    	  //handler.addObject(new zombies(0,0,ID.zombies));
    	 /* for (int i=0;i<5;i++)
    	  {
    		 // handler.addObject(new zombies(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.zombies));
    		  handler.addObject(new zombies(0,i*100+40,ID.zombies));
    		 // handler.addObject(new zombies(100,100,ID.zombies));
    		  
    	  }*/
    	  
    	  addMouseMotionListener(this);
    	  addMouseListener(this);
    	  
      }
        public synchronized void start(){
                thread = new Thread(this);
                thread.start();
                running = true;
        }
        public synchronized void stop(){
                try{
                        thread.join();
                        running = false;
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
        public void run(){
               
                long lastTime = System.nanoTime();
                double amountOfTicks = 60.0;
                double ns = 1000000000 / amountOfTicks;
                double delta = 0;
                long timer = System.currentTimeMillis();
                int frames = 0;
                while(running){
                        long now = System.nanoTime();
                        delta += (now - lastTime) / ns;
                        lastTime = now;
                        while(delta >= 1){
                                tick();
                                delta--;
                        }
                        if(running)
                                render();
                        frames++;
                        if(System.currentTimeMillis() - timer > 1000){
                                timer += 240;
                                System.out.println("FPS: " + frames);
                                frames = 0;
                        }
                }
                stop();
        }
        private void tick(){
               handler.tick();
        }
        
       private void render(){
            BufferStrategy bs = this.getBufferStrategy();
            if(bs == null){
                    this.createBufferStrategy(3);
                    return;
            }      
            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.black);
           g.fillRect(0, 0, WIDTH, HEIGHT);
            Image i=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\Frontyard.jpg");  
            g.drawImage(i, 0, 0, 1400, 600, null);
            Image i1=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\select1.jpg");  
            g.drawImage(i1, 0, 0, 90, 90, null);
            Image i2=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\select2.jpg");  
            g.drawImage(i2, 0, 92, 90, 90, null);
            Image i3=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\select3.jpg");  
            g.drawImage(i3, 0, 184, 90, 90, null);
            Image i4=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\selec4.jpg");  
            g.drawImage(i4, 0, 276, 90, 90, null);
            Image i5=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\select5.jpg");  
            g.drawImage(i5, 0, 368, 90, 90, null);
            Image i6=Toolkit.getDefaultToolkit().getImage("F:\\other\\zombie-vs-plant\\zombie-vs-plant\\zombie vs plant\\image\\select6.jpg");  
            g.drawImage(i6, 0, 460, 90, 90, null);
            g.setColor(Color.black);
            g.drawString(""+k1,80,90);
            g.drawString(""+k2,80,182);
            g.drawString(""+k3,80,274);
            g.drawString(""+k4,80,366);
            g.drawString(""+k5,80,458);
            g.drawString(""+k1,80,550);
            
          handler.render(g);
            g.dispose();
            bs.show();
            
    }
       
		public static void main(String args[]){
                        new game();
                    
        }
		
            
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("Mouse Clicked");
			int x = e.getX();
			int y= e.getY();
			
			
			if(x>0 && x<90 && y>0 && y<90){ n=1; }
			if(x>0 && x<90 && y>92 && y<182){n=2; }
			if(x>0 && x<90 && y>184 && y<274){n=3;}
			if(x>0 && x<90 && y>276 && y<366){n=4;}
			if(x>0 && x<90 && y>368 && y<458){n=5;}
			if(x>0 && x<90 && y>460 && y<550){n=6;}
			
			if (x>=90 && y>=80 && y<=180) {if(n==1 &&k1!=0) {handler.addObject(new zombiefootball(1200,107-50,ID.zombiefootball,handler));k1--;}
			                            if(n==2 &&k2!=0) {handler.addObject(new zombiebuck(1200,107-50,ID.zombiebuck,handler));k2--;}
			                            if(n==3 &&k3!=0) {handler.addObject(new zombiehard(1200,107-50,ID.zombiehard,handler));k3--;}
			                            if(n==4 &&k4!=0) {handler.addObject(new zombies(1200,107-50,ID.zombies,handler));k4--;}
			                            if(n==5 &&k5!=0) {handler.addObject(new zombiegiant(1200,107-50,ID.zombiegiant,handler));k5--;}
			                            if(n==6 &&k6!=0) {handler.addObject(new zombiefly(1200,107-50,ID.zombiefly,handler));k6--;}
			}
			
			/*for(int i=0; i<2; i++ ) { 
	  			handler.addObject(new bullet(295,75,ID.bullet,handler) );
	  			try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	  			}*/
			
			if (x>=90 && y>180 && y<=280)  {if(n==1 && k1!=0) {handler.addObject(new zombiefootball(1200,207-50,ID.zombiefootball,handler));k1--;}
            if(n==2 &&k2!=0) {handler.addObject(new zombiebuck(1200,207-50,ID.zombiebuck,handler));k2--;}
            if(n==3 &&k3!=0 ) {handler.addObject(new zombiehard(1200,207-50,ID.zombiehard,handler));k3--;}
            if(n==4 &&k4!=0) {handler.addObject(new zombies(1200,207-50,ID.zombies,handler));k4--;}
            if(n==5 &&k5!=0) {handler.addObject(new zombiegiant(1200,207-50,ID.zombiegiant,handler));k5--;}
            if(n==6 &&k6!=0) {handler.addObject(new zombiefly(1200,207-50,ID.zombiefly,handler));k6--;}
			
				
				/*for(int i=0; i<2;i++ ) { 
		  			handler.addObject(new bullet(295,175,ID.bullet,handler) );
		  			try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  			}*/
				}
			if (x>=90 && y>280 && y<=380) {
				if(n==1 &&k1!=0) {handler.addObject(new zombiefootball(1200,307-50,ID.zombiefootball,handler));k1--;}
                if(n==2 &&k2!=0) {handler.addObject(new zombiebuck(1200,307-50,ID.zombiebuck,handler));k2--;}
                if(n==3 &&k3!=0) {handler.addObject(new zombiehard(1200,307-50,ID.zombiehard,handler));k3--;}
                if(n==4 &&k4!=0) {handler.addObject(new zombies(1200,307-50,ID.zombies,handler));k4--;}
                if(n==5 &&k5!=0) {handler.addObject(new zombiegiant(1200,307-50,ID.zombiegiant,handler));k5--;}
                if(n==6 &&k6!=0) {handler.addObject(new zombiefly(1200,307-50,ID.zombiefly,handler));k6--;}
				/*for(int i=0; i<2; i++ ) { 
		  			handler.addObject(new bullet(295,275,ID.bullet,handler) );
		  			try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  			}*/
				}
			if (x>=90 && y>380 && y<=480) {
				if(n==1 &&k1!=0) {handler.addObject(new zombiefootball(1200,407-50,ID.zombiefootball,handler));k1--;}
                if(n==2 &&k2!=0) {handler.addObject(new zombiebuck(1200,407-50,ID.zombiebuck,handler));k2--;}
                if(n==3 &&k3!=0) {handler.addObject(new zombiehard(1200,407-50,ID.zombiehard,handler));k3--;}
                if(n==4 &&k4!=0) {handler.addObject(new zombies(1200,407-50,ID.zombies,handler));k4--;}
                if(n==5 &&k5!=0) {handler.addObject(new zombiegiant(1200,407-50,ID.zombiegiant,handler));k5--;}
                if(n==6 &&k6!=0) {handler.addObject(new zombiefly(1200,407-50,ID.zombiefly,handler));k6--;}
				/*for(int i=0; i<2; i++ ) { 
		  			handler.addObject(new bullet(295,375,ID.bullet,handler) );
		  			try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  			}*/
				}
			if (x>=90 && y>480 && y<=580) {
				if(n==1 &&k1!=0) {handler.addObject(new zombiefootball(1200,507-50,ID.zombiefootball,handler));k1--;}
                if(n==2 &&k2!=0) {handler.addObject(new zombiebuck(1200,507-50,ID.zombiebuck,handler));k2--;}
                if(n==3 &&k3!=0) {handler.addObject(new zombiehard(1200,507-50,ID.zombiehard,handler));k3--;}
                if(n==4 &&k4!=0) {handler.addObject(new zombies(1200,507-50,ID.zombies,handler));k4--;}
                if(n==5 &&k5!=0) {handler.addObject(new zombiegiant(1200,507-50,ID.zombiegiant,handler));k5--;}
                if(n==6 &&k6!=0) {handler.addObject(new zombiefly(1200,507-50,ID.zombiefly,handler));k6--;}
				/*for(int i=0; i<2; i++ ) { 
		  			handler.addObject(new bullet(295,475,ID.bullet,handler) );
		  			try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  			}*/
				}
			System.out.print("x= "+ x +",y= " + y );	
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
		

			
		}
		@Override
		public void mousePressed(MouseEvent e) {
		
			
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			
			
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
}

package deadlyzombies;
import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.Random;
public class game extends Canvas implements Runnable, MouseListener, MouseMotionListener {
        private static final long serialVersionUID = 1550691097823471818L;      
public static final int WIDTH = 1400, HEIGHT = 600;// WIDTH / 12 * 9;
        private Thread thread;
        private boolean running = false;
        private Handler handler;
        private Random r;
      public game() {
    	  int x=0, y=0;
    	  new frame(WIDTH,HEIGHT,"DEADLY ZOMBIES",this);
    	  handler = new Handler();
    	  handler.addObject(new plants(250,50,ID.plants) );
    	  handler.addObject(new plants(250,150,ID.plants) );
    	  handler.addObject(new plants(250,250,ID.plants) );
    	  handler.addObject(new plants(250,350,ID.plants) );
    	  handler.addObject(new plants(250,450,ID.plants) );
    	 
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
                                timer += 1000;
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
			
			if (y>=80 && y<=180) {
			handler.addObject(new zombies(x-50,107-50,ID.zombies));
			for(int i=0; i<2; i++ ) { 
	  			handler.addObject(new bullet(295,75,ID.bullet) );
	  			try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	  			}
			}
			if (y>180 && y<=280) {
				handler.addObject(new zombies(x-50,207-50,ID.zombies));
				for(int i=0; i<2; i++ ) { 
		  			handler.addObject(new bullet(295,175,ID.bullet) );
		  			try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  			}
				}
			if (y>280 && y<=380) {
				handler.addObject(new zombies(x-50,307-50,ID.zombies));
				for(int i=0; i<2; i++ ) { 
		  			handler.addObject(new bullet(295,275,ID.bullet) );
		  			try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  			}
				}
			if (y>380 && y<=480) {
				handler.addObject(new zombies(x-50,407-50,ID.zombies));
				for(int i=0; i<2; i++ ) { 
		  			handler.addObject(new bullet(295,375,ID.bullet) );
		  			try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  			}
				}
			if (y>480 && y<=580) {
				handler.addObject(new zombies(x-50,507-50,ID.zombies));
				for(int i=0; i<2; i++ ) { 
		  			handler.addObject(new bullet(295,475,ID.bullet) );
		  			try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  			}
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
}

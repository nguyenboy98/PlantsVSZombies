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

import javax.swing.JOptionPane;

public class Game extends Canvas  implements Runnable, MouseListener, MouseMotionListener ,KeyListener {
        private static final long serialVersionUID = 1550691097823471818L;      
public static final int WIDTH = 1400, HEIGHT = 600;
        private Thread thread;
        private boolean running = false;
        private Handler handler;
        private int n=0;
        int k1=3;
		int k2=5;
		int k3=7;
		int k4=8;
		int k5=2;
		int k6=6;
		
		static int zombiescount=1;
		private Menu menu;
		private Help help;
		static int levl=1;
		public static int countplants=levl*5;
	
		private enum STATE {
			MENU,HELP,WIN,END,
			GAME;
		}
		private static STATE State=STATE.MENU;
		
       
		public Game() {
    	 
    	  int x=0, y=0;
    	  new Frame(WIDTH,HEIGHT,"DEADLY ZOMBIES",this);
    	  handler = new Handler();
    	gamestart();
    	  
    	 menu=new Menu();
    	 help=new Help();
    	 
    	  
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
        	if(State==STATE.GAME) {
        		
        
               handler.tick();
               
               level();
             
        	}}
        
       private void render(){
            BufferStrategy bs = this.getBufferStrategy();
            if(bs == null){
                    this.createBufferStrategy(3);
                    return;
            }      
            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.white);
           g.fillRect(0, 0, WIDTH, HEIGHT);
           if(State==STATE.GAME) {
        	Image i=Toolkit.getDefaultToolkit().getImage("./res/Frontyard.jpg");  
            g.drawImage(i, 0, 0, 1400, 600, null);
            Image i1=Toolkit.getDefaultToolkit().getImage("./res/select1.jpg");  
            g.drawImage(i1, 0, 0, 90, 90, null);
            Image i2=Toolkit.getDefaultToolkit().getImage("./res/select2.jpg");  
            g.drawImage(i2, 0, 92, 90, 90, null);
            Image i3=Toolkit.getDefaultToolkit().getImage("./res/select3.jpg");  
            g.drawImage(i3, 0, 184, 90, 90, null);
            Image i4=Toolkit.getDefaultToolkit().getImage("./res/selec4.jpg");  
            g.drawImage(i4, 0, 276, 90, 90, null);
            Image i5=Toolkit.getDefaultToolkit().getImage("./res/select5.jpg");  
            g.drawImage(i5, 0, 368, 90, 90, null);
            Image i6=Toolkit.getDefaultToolkit().getImage("./res/select6.jpg");  
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
         
          
            if (State==STATE.MENU){
            	Image i=Toolkit.getDefaultToolkit().getImage("./res/menux2.gif");  
                g.drawImage(i, 0, 0, 1400, 600, null);
                Image i2=Toolkit.getDefaultToolkit().getImage("./res/title.png");  
                g.drawImage(i2, 480, 0, 480,240 , null);
            	menu.render(g);
            	g.dispose();
                bs.show();
            }
             if(State==STATE.HELP) {
            	Image i=Toolkit.getDefaultToolkit().getImage("./res/rule.png");  
                g.drawImage(i, 0, 0, 400, 600, null);
                Image i1=Toolkit.getDefaultToolkit().getImage("./res/rule.png");  
                g.drawImage(i1, 420, 0, 400, 600, null);
                Image i2=Toolkit.getDefaultToolkit().getImage("./res/rule.png");  
                g.drawImage(i2, 840, 0, 400, 600, null); 
                help.render(g);
            	g.dispose();
                bs.show();
            }
           if(State==STATE.WIN) {
        	   Image i2=Toolkit.getDefaultToolkit().getImage("./res/SWG.png");  
               g.drawImage(i2, 500, 0, 600, 400, null); 
               Image i=Toolkit.getDefaultToolkit().getImage("./res/exit.png");  
               g.drawImage(i, 700, 450, 100, 100, null); 
           	   g.dispose();
               bs.show();
           }
           if(State==STATE.END) {
        	   Image i2=Toolkit.getDefaultToolkit().getImage("./res/game_over.png");  
               g.drawImage(i2, 0, 0, 1400, 600, null); 
               Image i=Toolkit.getDefaultToolkit().getImage("./res/exit2.png");  
               g.drawImage(i, 0, 0, 100, 100, null); 
               Image i1=Toolkit.getDefaultToolkit().getImage("./res/continue.png");  
               g.drawImage(i1, 450,500, 500, 90, null); 
           	   g.dispose();
               bs.show();
           }
    }
       
		public static void main(String args[]){
			if(State==STATE.MENU) {
           new Game();}
                    
        }
		
            
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Mouse Clicked");
			int x = e.getX();
			int y= e.getY();
			if(State==STATE.END) {
				if(x>450&&x<950&&y>500&&y<590) {State=STATE.GAME;k1=3;k2=3;k3=3;k4=3;k5=3;k6=3;zombiescount=36;}
				
				if(x>0&&x<100&&y>0&&y<100) {System.exit(1);}
			}
			if(State==STATE.WIN) {
				if(x>700&&x<800&&y>450&&y<550) {System.exit(1);}
				
			
			}
			if(State==STATE.MENU) {
				if(x>20&&x<170&&y>20&&y<90) {State=STATE.GAME;}
				if(x>20&&x<170&&y>95&&y<165) {State=STATE.HELP;}
				if(x>20&&x<170&&y>170&&y<240) {System.exit(1);}
			}
			if(State==STATE.GAME){
			if(x>0 && x<90 && y>0 && y<90){ n=1; }
			if(x>0 && x<90 && y>92 && y<182){n=2; }
			if(x>0 && x<90 && y>184 && y<274){n=3;}
			if(x>0 && x<90 && y>276 && y<366){n=4;}
			if(x>0 && x<90 && y>368 && y<458){n=5;}
			if(x>0 && x<90 && y>460 && y<550){n=6;}
			
			if (x>=90 && y>=80 && y<=180) {if(n==1 &&k1!=0) {handler.addObject(new ZombieFootball(1200,107-50,ID.zombiefootball,handler));k1--;}
			                            if(n==2 &&k2!=0) {handler.addObject(new ZombieBuck(1200,107-50,ID.zombiebuck,handler));k2--;}
			                            if(n==3 &&k3!=0) {handler.addObject(new ZombieHard(1200,107-50,ID.zombiehard,handler));k3--;}
			                            if(n==4 &&k4!=0) {handler.addObject(new Zombies(1200,107-50,ID.zombies,handler));k4--;}
			                            if(n==5 &&k5!=0) {handler.addObject(new ZombieGiant(1200,107-50,ID.zombiegiant,handler));k5--;}
			                            if(n==6 &&k6!=0) {handler.addObject(new ZombieFly(1200,107-50,ID.zombiefly,handler));k6--;}
			}
			
			
			
			if (x>=90 && y>180 && y<=280)  {if(n==1 && k1!=0) {handler.addObject(new ZombieFootball(1200,207-50,ID.zombiefootball,handler));k1--;}
            if(n==2 &&k2!=0) {handler.addObject(new ZombieBuck(1200,207-50,ID.zombiebuck,handler));k2--;}
            if(n==3 &&k3!=0 ) {handler.addObject(new ZombieHard(1200,207-50,ID.zombiehard,handler));k3--;}
            if(n==4 &&k4!=0) {handler.addObject(new Zombies(1200,207-50,ID.zombies,handler));k4--;}
            if(n==5 &&k5!=0) {handler.addObject(new ZombieGiant(1200,207-50,ID.zombiegiant,handler));k5--;}
            if(n==6 &&k6!=0) {handler.addObject(new ZombieFly(1200,207-50,ID.zombiefly,handler));k6--;}
			
				
				
				}
			if (x>=90 && y>280 && y<=380) {
				if(n==1 &&k1!=0) {handler.addObject(new ZombieFootball(1200,307-50,ID.zombiefootball,handler));k1--;}
                if(n==2 &&k2!=0) {handler.addObject(new ZombieBuck(1200,307-50,ID.zombiebuck,handler));k2--;}
                if(n==3 &&k3!=0) {handler.addObject(new ZombieHard(1200,307-50,ID.zombiehard,handler));k3--;}
                if(n==4 &&k4!=0) {handler.addObject(new Zombies(1200,307-50,ID.zombies,handler));k4--;}
                if(n==5 &&k5!=0) {handler.addObject(new ZombieGiant(1200,307-50,ID.zombiegiant,handler));k5--;}
                if(n==6 &&k6!=0) {handler.addObject(new ZombieFly(1200,307-50,ID.zombiefly,handler));k6--;}
				
				}
			if (x>=90 && y>380 && y<=480) {
				if(n==1 &&k1!=0) {handler.addObject(new ZombieFootball(1200,407-50,ID.zombiefootball,handler));k1--;}
                if(n==2 &&k2!=0) {handler.addObject(new ZombieBuck(1200,407-50,ID.zombiebuck,handler));k2--;}
                if(n==3 &&k3!=0) {handler.addObject(new ZombieHard(1200,407-50,ID.zombiehard,handler));k3--;}
                if(n==4 &&k4!=0) {handler.addObject(new Zombies(1200,407-50,ID.zombies,handler));k4--;}
                if(n==5 &&k5!=0) {handler.addObject(new ZombieGiant(1200,407-50,ID.zombiegiant,handler));k5--;}
                if(n==6 &&k6!=0) {handler.addObject(new ZombieFly(1200,407-50,ID.zombiefly,handler));k6--;}
				
				}
			if (x>=90 && y>480 && y<=580) {
				if(n==1 &&k1!=0) {handler.addObject(new ZombieFootball(1200,507-50,ID.zombiefootball,handler));k1--;}
                if(n==2 &&k2!=0) {handler.addObject(new ZombieBuck(1200,507-50,ID.zombiebuck,handler));k2--;}
                if(n==3 &&k3!=0) {handler.addObject(new ZombieHard(1200,507-50,ID.zombiehard,handler));k3--;}
                if(n==4 &&k4!=0) {handler.addObject(new Zombies(1200,507-50,ID.zombies,handler));k4--;}
                if(n==5 &&k5!=0) {handler.addObject(new ZombieGiant(1200,507-50,ID.zombiegiant,handler));k5--;}
                if(n==6 &&k6!=0) {handler.addObject(new ZombieFly(1200,507-50,ID.zombiefly,handler));k6--;}
				
				}
			
		}
	}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
		

			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		
			
			
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
		public void keyPressed(KeyEvent e) {}
			// TODO Auto-generated method stub
			public void gamestart() {
				
				if(levl==1||levl==2||levl==3)
		    	  {handler.addObject(new Plants(250,50,ID.plants,handler) );
		    	  handler.addObject(new Plants(250,150,ID.plants,handler) );
		    	  handler.addObject(new Plants(250,250,ID.plants,handler) );
		    	  handler.addObject(new Plants(250,350,ID.plants,handler) );
		    	  handler.addObject(new Plants(250,450,ID.plants,handler) );}
		    	  if(levl==2||levl==3)
		    	  { handler.addObject(new PotatoPlants(325,50,ID.potatoplants,handler) );
		    	  handler.addObject(new PotatoPlants(325,150,ID.potatoplants,handler) );
		    	  handler.addObject(new PotatoPlants(325,250,ID.potatoplants,handler) );
		    	  handler.addObject(new PotatoPlants(325,350,ID.potatoplants,handler) );
		    	  handler.addObject(new PotatoPlants(325,450,ID.potatoplants,handler) );}
		    	  if(levl==3)
		    	  {  handler.addObject(new IcePLants(415,50,ID.iceplants,handler));
		    	  handler.addObject(new IcePLants(415,150,ID.iceplants,handler));
		    	  handler.addObject(new IcePLants(415,250,ID.iceplants,handler));
		    	  handler.addObject(new IcePLants(415,350,ID.iceplants,handler));
		    	  handler.addObject(new IcePLants(415,450,ID.iceplants,handler));}
		    	  
		    	  
			}
			
		
	public void level() {
		if(countplants==0) {
			k1+=3;k2+=3;k3+=3;k4+=3;k5+=3;k6+=3;
			zombiescount=k1+k2+k3+k4+k5+k6;
			System.out.println ("win :..... "+zombiescount);
			levl++;
			if(levl>3) {State=STATE.WIN;JOptionPane.showMessageDialog(null, "You win");}
			else{countplants=levl*5;
			System.out.println ("plants :..... "+countplants);
			JOptionPane.showMessageDialog(null, "welcome to stage "+levl);
			gamestart();}}
		if (zombiescount==0&&countplants>0) {State=STATE.END;}
	}
	
}

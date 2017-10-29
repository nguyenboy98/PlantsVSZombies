package deadlyzombies;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class zombies extends Object {
Random r= new Random();
	public zombies(int x, int y, ID id) {
		super(x, y, id);
	    velX=r.nextInt(4)+1;
		velY=r.nextInt(4);
		//velX=1;
	}
public void tick() {
	x+=velX;
	y+=velY;
}
public void render (Graphics g) {
	g.setColor(Color.white);
	g.fillRect(x,y,30,30);
}
}

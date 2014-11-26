import java.awt.Color;
import java.awt.Graphics;

//Contains drawings of two initial paddles and ball

public class Paddle extends Entity {

	
	public Paddle(int x, int y) {
		super(x, y);
	}
	
	
	//KeyListener logic
	boolean keyreleasedup = true;
	boolean keyreleaseddown = true;



	public void Update() {
		if(keyreleasedup == false) {
			setY((int) (getY()-5));
		}

		if(keyreleaseddown == false) {
			setY((int) (getY()+5));
		}
	}
	//draws p1 paddle
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)getX(), (int)getY() , 30, 90);



	}

}



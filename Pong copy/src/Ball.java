import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;



public class Ball extends Entity implements KeyListener {

	private double VelocX;
	private double VelocY;
	private Paddle p1,p2;
	
	public Ball(int x, int y,Paddle p1, Paddle p2) {
		super(x, y);
		this.p1 = p1;
		this.p2 = p2;
	}


	boolean spacePressed = false;

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!spacePressed) {
				VelocX = (int)(Math.random()*5)-2;
				if(VelocX == 0) {
					VelocX = -2;
				}

				VelocY = (int)(Math.random()*3)-1;
				if(VelocY == 0) {
					VelocY = -1;
				}
				spacePressed = true;
			}
		}
	}

	boolean valueInRange(double d, double e, double f) {
		return (d >= e) && (d <= f);
	}

	boolean padBallOverlap(Paddle h) {

		boolean xOverlap = valueInRange(h.getX(), getX(), getX() + 20) || valueInRange(getX(), h.getX(), h.getX() + 30);

		boolean yOverlap = valueInRange(h.getY(), getY(), getY() + 20)|| valueInRange(getY(), h.getY(), h.getY() + 90); 
		
		return xOverlap && yOverlap;


	}





	public void draw(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval((int)getX(), (int)getY(), 20, 20);
	}



	public void Update() {
		setX(getX()+VelocX);
		setY(getY() + VelocY);

		if(getY()>=700) {
			VelocY *= -1;
		}

		if(getY()<=20) {
			VelocY *= -1;
		}

		if(getX()>=980) {
			VelocX *= -1;
		}

		if(getX()<=0) {
			VelocX *= -1;

		}

		if( padBallOverlap(p1) && VelocX < 0 ) {
			VelocX = (1.5) * Math.cos((Math.PI)/4);
			VelocY = (1.5) * Math.sin((Math.PI)/4);
		}
		if( padBallOverlap(p2) && VelocX > 0){
			VelocX = (-1.5) * Math.cos((Math.PI)/4);
			VelocY = (1.5) * Math.sin((Math.PI)/4);
		}

	}






	//Unused methods
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}


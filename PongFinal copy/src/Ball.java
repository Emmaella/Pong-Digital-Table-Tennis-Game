import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;



public class Ball extends Entity implements KeyListener {

	protected double VelocX;
	private double VelocY;
	private Paddle p1,p2;
	private Random random = new Random();
	int score1;
	int score2;

	public Ball(int x, int y,Paddle p1, Paddle p2) {
		super(x, y);
		this.p1 = p1;
		this.p2 = p2;
	}


	boolean spacePressed = false;

	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!spacePressed) {
				VelocX = (2) * (int)(Math.random()*5)-2;
				if(VelocX == 0) {
					VelocX = -2.5;
				}

				VelocY = (2) * (int)(Math.random()*3)-1;
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
		if (spacePressed){
			setX(getX()+VelocX);
			setY(getY() + VelocY);

			if(getY()>=700) {
				VelocY *= -1;
				
			}

			if(getY()<=20) {
				VelocY *= -1;
			}

		
			
			if( padBallOverlap(p1) && VelocX < 0 ) {
				VelocX = (5.5) * Math.cos((Math.PI)/4) + random.nextDouble();
				VelocY = (5.5) * Math.sin((Math.PI)/4) + random.nextDouble();
			}
			if( padBallOverlap(p2) && VelocX > 0){
				VelocX = (-5.5) * Math.cos((Math.PI)/4) + ((2.5) * (random.nextDouble()));
				VelocY = (5.5) * Math.sin((Math.PI)/4) + ((2.5) * (random.nextDouble()));
			}
		}
	}

	public void resetBall() {
		setX(490);
		setY(320);
		spacePressed = false;
		VelocX = 0;
		VelocY = 0;


	}


	public boolean getSpacePressed(){
		return spacePressed;
	}



	//Unused methods
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}


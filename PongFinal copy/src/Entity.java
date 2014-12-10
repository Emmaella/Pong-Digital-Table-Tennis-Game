import java.awt.Graphics;


public abstract class Entity {

	private double x=0;
	private double y=0;
	public Paddle p1;
	public Paddle p2;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double d) {
		this.x = d;
	}

	public void setY(double d) {
		this.y = d;
	}


	//Abstract methods for other classes
	public abstract void Update();



	public abstract void draw(Graphics g);




}

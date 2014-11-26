import java.awt.*;


public class MidLine extends Entity {

	public MidLine(int x, int y) {
		super(x, y);
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)getX(), (int)getY(), 15, 720);
	}
	
	public void Update() {
		
	}


}

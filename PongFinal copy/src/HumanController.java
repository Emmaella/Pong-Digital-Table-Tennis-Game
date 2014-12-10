import java.awt.Graphics;
import java.awt.event.*; 

//movement for p1 paddle
public class HumanController extends Paddle implements KeyListener {



	public HumanController(int x, int y) {
		super(x, y);
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			keyreleasedup = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_S) {
			keyreleaseddown = false;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			keyreleasedup = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			keyreleaseddown = true;
		}
	}
	





}
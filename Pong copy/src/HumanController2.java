import java.awt.Graphics;
import java.awt.event.*; 

//movement for p2 paddle
public class HumanController2 extends Paddle implements KeyListener {
	



	public HumanController2(int x, int y) {
		super(x, y);
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			keyreleasedup = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			keyreleaseddown = false;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			keyreleasedup = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			keyreleaseddown = true;
		}
	}





}
import java.awt.Color;
import java.awt.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class JavaPong extends Frame{
private static final long serialVersionUID = 1L;


HumanController h = new HumanController(0 , 315);
HumanController2 h2  = new HumanController2(970, 315);
Ball ball = new Ball(490, 320, h, h2);
MidLine line = new MidLine(493, 0);

boolean canContinue = true;

	public void Update() {
		
		Graphics g = null;
		addKeyListener(h);
		addKeyListener(h2);
		addKeyListener(ball);
		while(canContinue){
			//Set background, smooth updates
			BufferedImage b = new BufferedImage(1000,720,BufferedImage.TYPE_INT_ARGB);
			g = b.getGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			//draw black rectangle
			//redraw paddles, line, score
			//draw and continuously update paddles and ball
			h.Update();
			h.draw(g);
			h2.Update();
			h2.draw(g);
			line.draw(g);
			ball.Update();
			ball.draw(g);
			
			
		
			
			
			
			
			
			
			g = this.getGraphics();
			g.drawImage(b,0,0,null);
		}
		if (g != null)
			g.dispose();
	}

	
	public static void main (String [] args) {
		
		JavaPong frame = new JavaPong();
		
		frame.setSize(1000, 720);
		frame.setVisible(true);
		frame.Update();
		
	}

}

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Score extends Entity{

	private int score1;
	private int score2;
	private Ball forScore;
	private boolean scored1 = false;
	private boolean scored2 = false;
	private boolean winp1 = false;
	private boolean winp2 = false;


	public Score(int x, int y, Ball score) {
		super(x, y);
		this.forScore = score;

	}

	public void Update() {
		if(forScore.getX()>=980) {
			scored1 = true;
			score1 += 1;
			forScore.resetBall();


		}

		if(forScore.getX()<=0) {
			scored2 = true;
			score2 += 1;
			forScore.resetBall();

		}
		if(forScore.getSpacePressed()){
			scored1 = false;
			scored2 = false;
		}
		
		if(score1 == 11) {
			winp1 = true;
			score1 = 0;
			score2 = 0;
		}
		
		if(score2 == 11) {
			winp2 = true;
			score1 = 0;
			score2 = 0;
		}
	}


	public void draw(Graphics g) {
		g.setFont(new Font("Impact", Font.PLAIN, 30));
		//Font.setColor(Color.blue);
		String Sscore1 = "" + score1;
		String Sscore2 = "" + score2;
		g.drawString(Sscore1, 345, 75);
		g.drawString(Sscore2, 645, 75);
		if(scored1 && score1 != 11) {
			g.drawString("Point!", 320, 150);
		}
		else if(scored2 && score2 != 11) {
			g.drawString("Point!", 620, 150);
		} 
		else if(winp1) {
			g.drawString("Winner!", 320, 150);
		}
		else if(winp2) {
			g.drawString("Winner!", 620, 150);
		}

	}


}
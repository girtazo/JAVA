package ball;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallToRight extends Applet implements Runnable, ActionListener{
	
	private int width, height;
	private Font font;
	private Button button;
	private Ball ball = null;
	
	public void init(){
		font = new Font("Verdana", Font.BOLD, 26);
		this.width = Integer.parseInt(this.getParameter("WIDTH"));
		this.height = Integer.parseInt(this.getParameter("HEIGHT"));
		
		this.setLayout(new GridLayout(6, 0));
		this.add(button = new Button("Parar"));
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		button.setLabel("Bola parada");
		ball.stopMoving();
	}
	
	public void start(){
		if(ball == null){
			ball = new Ball(0, height/2);
			ball.start();
		}			
	}

	@Override
	public void run() {
		ball.run();		
	}
	
	public void paint(Graphics g){
		setBackground(Color.WHITE);
		g.setFont(this.font);
		g.setColor(Color.BLACK);
		g.fillArc(ball.getX(), ball.getY(), 40, 40, 0, 360);
	}
	
	private class Ball extends Thread{
		
		private int x, y;
		private boolean stop;
		
		public Ball(int initialX, int initialY){
			x = initialX;
			y = initialY;
			stop = false;
		}
		
		public int getX(){ return x; }
		public int getY(){ return y; }
		
		public void stopMoving(){
			stop = true;
		}
		
		private void moveRight(){
			x += 1;
		}
		
		private boolean canMoveToRight(){
			if(x < (width - 40))
				return true;
			else return false;
		}  
		
		public void run(){
			while( canMoveToRight() && !stop ){

				moveRight();
				repaint();
				
				try {
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			button.setLabel("Bola parada");
		}
	}
}

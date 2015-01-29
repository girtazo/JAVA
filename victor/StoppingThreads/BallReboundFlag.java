package StoppingThreads;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallReboundFlag extends Applet implements Runnable, ActionListener{
	
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
		ball.stop = true;
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
		
		private final int LEFT = 1, RIGHT = 2;
		private int x, y, direction;
		public volatile boolean stop;
				
		public Ball(int initialX, int initialY){
			x = initialX;
			y = initialY;
			stop = false;
			direction = RIGHT;
		}
		
		public int getX(){ return x; }
		public int getY(){ return y; }
		
		private void moveLeft(){
			x -= 1;
		}
		
		private void moveRight(){
			x += 1;
		}
		
		private boolean canMoveToLeft(){
			if(x > 0)
				return true;
			else return false;
		}
		
		private boolean canMoveToRight(){
			if(x < (width - 40))
				return true;
			else return false;
		}  
		
		public void run(){
			
			while( !stop ){

				switch(direction){
					case LEFT:
						moveLeft();
						
						if( !canMoveToLeft() )
							direction = RIGHT;
						break;
					case RIGHT:
						moveRight();

						if( !canMoveToRight() )
							direction = LEFT;
						break;
				}
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
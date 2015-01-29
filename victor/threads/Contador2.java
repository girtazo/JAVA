package threads;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;


public class Contador2 extends Applet implements Runnable {

	private Font font;
	private Counter firstCounter, secondCounter;

	public void init(){
		font = new Font("Verdana", Font.BOLD, 26);
	}
	
	public void start(){
		if(firstCounter == null || secondCounter == null){
			firstCounter = new Counter(0, 5);
			secondCounter = new Counter(100, 2);
			firstCounter.start();
			secondCounter.start();
		}
	}
	
	@Override
	public void run() {
		firstCounter.run();
		secondCounter.run();
	}
	
	public void paint(Graphics g){
		g.clearRect(1, 1, getSize().width, getSize().height);
		setBackground(Color.yellow);
		g.setFont(font);
		g.drawString(Integer.toString(firstCounter.getTime()), 
				(int)(getSize().width*0.4), (int)(getSize().height*0.5));
		g.drawString(Integer.toString(secondCounter.getTime()), 
				(int)(getSize().width*0.4), (int)(getSize().height*0.75));
	}
	
	private class Counter extends Thread{
		private int start;
		private int step;
		private boolean stop;
		
		public Counter(int start, int step){
			super();
			this.start = start;
			this.step = step;
			this.stop = false;
		}
		
		public void setStop(boolean stop){
			this.stop = stop;
		}
		
		public int getTime(){
			return start;
		}
		
		public void run(){
			while(!stop){
				start += step;
				repaint();
				
				try{
					sleep(1000);
				}catch(Exception e){}
			}
		}
	}

}

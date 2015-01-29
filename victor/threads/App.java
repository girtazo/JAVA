package threads;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class App implements ActionListener{
	
	private Counter firstCounter;
	private Counter secondCounter;
	private Counter thirdCounter;
	private int readyToPrint = 0;
	private Frame frame = null;
	private Container container = null;
	private Button button = null;
	private Font font = null;
	
	public App(){
		frame = new Frame();
		frame.setSize(new Dimension(300, 300));
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e) {
				System.exit(0);				
			}			
		});
		frame.add(container = new Container());
		container.setSize(new Dimension(300, 300));
		container.setVisible(true);
		container.setLayout(new GridLayout(6, 0));
		container.add(button = new Button("Parar hilo 2"));
		button.addActionListener(this);
		font = new Font("Verdana", Font.BOLD, 26);
		
		firstCounter = new Counter(0, 5);
		secondCounter = new Counter(100, 2);
		thirdCounter = new Counter(45,3);
		firstCounter.start();
		secondCounter.start();
		thirdCounter.start();
		firstCounter.run();
		secondCounter.run();
		thirdCounter.run();
	}
	
	public void repaint(){
		Graphics g = container.getGraphics();

		g.clearRect(1, 1, container.getSize().width, container.getSize().height);
		container.setBackground(Color.WHITE);
		g.setFont(font);
		g.drawString(Integer.toString(firstCounter.getTime()), 
				(int)(container.getSize().width*0.4), (int)(container.getSize().height*0.25));
		g.drawString(Integer.toString(secondCounter.getTime()), 
				(int)(container.getSize().width*0.4), (int)(container.getSize().height*0.5));
		g.drawString(Integer.toString(thirdCounter.getTime()), 
				(int)(container.getSize().width*0.4), (int)(container.getSize().height*0.75));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		secondCounter.stopMoving();
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
		
		public void stopMoving(){
			stop = true;
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

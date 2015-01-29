package threads;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.io.IOException;

public class Contador3 {
	private static Counter firstCounter;
	private static Counter secondCounter;
	private static Counter thirdCounter;
	private static int readyToPrint = 0;
	private static Container container = null;
	
	public static void main(String[]args){
		container = new Container();
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
	
	public static void repaint(){
		if(readyToPrint >= 3){
			System.out.println("#############################################");
			System.out.printf("Hilo 1: %d\n", firstCounter.getTime());
			System.out.printf("Hilo 2: %d\n", secondCounter.getTime());
			System.out.printf("Hilo 3: %d\n", thirdCounter.getTime());
			System.out.println("#############################################");
			readyToPrint = 0;
		}else
			readyToPrint++;
		try{
			Runtime.getRuntime().exec("clear");
		}catch(IOException ioex){}
	}
	
	private static class Counter extends Thread{
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

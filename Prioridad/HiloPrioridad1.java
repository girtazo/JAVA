/*
Prioridad entero entre 1 y 10
1 mínima -->MIN_PRIORITY
5 medio --> NORM_PRIORITY
10 máxima --> MAX_PRIORITY
2 hilos igual prioridad round-robbin
*/

class HiloPrioridad1 extends Thread {
	//propiedades	
	private int c=0; //vble contador
	private boolean stopHilo=false; //boolean parar contador hilo

public int getContador(){
	return c;
	}

public void pararHilo(){
	stopHilo=true;
	}
public void run(){
	while (!stopHilo) c++;
	}

}

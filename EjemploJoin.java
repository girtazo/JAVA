

class Hilo extends Thread {

int n;

public Hilo(String nom,int n){
	super(nom);//asigna string nom a nombre hilo
    this.n=n; //asigna valor y a n
	}

public void run(){
	for (int i=1;i<=n;i++){
				System.out.println(getName() +":"+ i);
				i++;
			try {
				sleep(1000);
				}catch (InterruptedException ignore){}
			}
		
		}	

 }






//EjemploJoin ----------------------------------------------------------------------------
 class EjemploJoin {

	 public static void main (String[] args){
		
         Hilo h1=new Hilo("hilo1",3);
		 Hilo h2=new Hilo("hilo2",5);
          Hilo h3=new Hilo("hilo3",7);
        
        h1.start();
        h2.start();
        h3.start();
        
        try {
            
            h1.join();h2.join();h3.join();
        } catch (InterruptedException e) {}
        
System.out.println("Final del programa");
		
	 }
		 
 }

//-------------------------------------------------------------------------------

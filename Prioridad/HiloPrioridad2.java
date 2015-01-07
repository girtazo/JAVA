
// Hilo escribe su nombre 5 veces
class HiloPrioridad2 extends Thread {
	//	propiedades 
	String nom;
HiloPrioridad2 (String cadena) {
	nom=cadena;
	}
public void run(){
	System.out.println ("Ejecutando ["+ nom + "]");
	for (int i=1;i<6;i++){
		System.out.println (" " + nom +" :"+ i +"");
		}
	}

}

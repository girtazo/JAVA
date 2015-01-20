package test.Sockettest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/* cliente*/
public class Sockettest extends Activity {
	/** Called when the activity is first created. */


	//textview muestra estado conexión
	private TextView txtstatus;
	
	//editext entrada ip, puerto y mensaje
	private EditText ipinput, portinput, input_txt;

	//socket
	Socket miCliente;
	
	//variable muestra estado conexión
	private boolean connected;



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	
		//recojo objetos del formulario
		ipinput = (EditText) findViewById(R.id.ipinput); //ip
		portinput = (EditText) findViewById(R.id.portinput); //puerto
		input_txt = (EditText) findViewById(R.id.input_txt); //editext entrada
		txtstatus = (TextView) findViewById(R.id.txtstatus);//txt estado conexion
		
	}
		
		
	
		// conectar. metodo conecta y actualiza txtstatus
		public void Conectando(View v) {
			//Nos conectamos y obtenemos el estado de la conexion
				boolean conectstatus = Connect();
				//si nos pudimos conectar
				if (conectstatus) {//mostramos mensaje 
					txtstatus.setTextColor(Color.GREEN);
					txtstatus.setText("conectado");

				} else {//error al conectarse 
					txtstatus.setTextColor(Color.RED);
					txtstatus.setText("Error conectando");
				}
			}
		
		

	//Metodo conexion--Conecta y devuelve true o false según si lo ha conseguido
	public boolean Connect() {
		//Obtengo datos ingresados en campos
		String IP = ipinput.getText().toString();
		int PORT = Integer.valueOf(portinput.getText().toString());

		try {//creamos sockets con los valores anteriores
			miCliente = new Socket(IP, PORT);
			//si nos conectamos
			if (miCliente.isConnected() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			//Si hubo algun error mostrmos error
			txtstatus.setTextColor(Color.RED);
			txtstatus.setText(" !!! ERROR  !!!");
			Log.e("Error connect()", "" + e);
			return false;
		}
	}

	
 
	//send_texto. envio y recibo contestación
	public void Send_texto(View v)  {

		//envio y recibo
		try {
	
			//ENVIO
			//me declaro flujo de tipo DataOutputstream (SALIDA)
			DataOutputStream flujo;
			
			//creo flujo salida y conecto con el del socket
			flujo = new DataOutputStream(miCliente.getOutputStream());


			if (miCliente.isConnected())// si la conexion continua
			{
			
				flujo.writeUTF("hola que tal!!");

				
			} else {//en caso de que no halla conexion al enviar el msg
				txtstatus.setTextColor(Color.RED);
				txtstatus.setText(" !!! ERROR  !!!");
				
			}
			
			//RECIBO RESPUESTA SERVIDOR--------------
			
			//me declaro flujo de tipo DataInputStream 
			DataInputStream flujo_entrada;
			
			//creo flujo entrada y conecto con el del socket
			flujo_entrada = new DataInputStream(miCliente.getInputStream());

					
			if (miCliente.isConnected())// si la conexion continua
			{
						
				 String cadena_recibo=flujo_entrada.readUTF();
				// input_txt.setText(cadena_recibo);
				 //muestro en toast
				 Toast.makeText(getApplicationContext(), cadena_recibo, Toast.LENGTH_SHORT).show();

				
			} else {//en caso de que no halla conexion al enviar el msg
				txtstatus.setTextColor(Color.RED);
				txtstatus.setText(" !!! ERROR EN RESPUESTA !!!");
				
			}

		} catch (IOException e) {// hubo algun error
			Log.e("Snd_Msg() ERROR -> ", "" + e);

		}
}//fin Send_Texto
	
	

	

}

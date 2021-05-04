package ezfish;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ShinichiKD
 */
public class Cliente implements Runnable{
    
    //    Puerto al cual se conectara , en el packet logger tienes Ejemplo: Server: 127.0.0.1:65124 
    //   127.0.0.1 = localhost
    // 65124= puerto , este varia para cada vez que habres el packetlogger 
    
    int puerto;
    //Te permitira conectarte al servidor creado por el packetlogger, para mas info busca Conexicon TPC
    //en resumen cliente-servidor , tu haras la parte del cliente y packelogger sera tu servidor.
    Socket cliente;
    //Servira para envir datos al packetlogger
    PrintStream out;
    //Sevira para recibir los datos desde el packetlogger
    BufferedReader in;
    DataInputStream in2;
    Boolean bazaropen=false;
    Boolean pescando = false;
    Boolean pescar=false;
    
    
    public Cliente(int p){
        this.puerto = p;
    }
     @Override
    public void run() {
//        PrintWriter out ;
        
//        DataOutputStream out2;

        try {
            //Realizas la conexion 
            cliente = new Socket("127.0.0.1",puerto);
            if (cliente.isConnected()) {
                System.out.println("Conexion establecida");
                //Aqui leeras los datos
                in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                out = new PrintStream(cliente.getOutputStream());
                while(true){
                    
                    if (in.readLine().equals("0 guri 6 1 13449 30 0") ) {
                            pescar=true;
                                
                            System.out.println("Listo para pescar");
                    }else{
                        pescar= false;
                    }
                    
                    if (pescando==false ) {
                        sleep(1000);
                        out.print("1 u_s 1 1 13449");
                        
                        
                        pescando=true;

                    }else{
                        if (pescar==true) {
                            out.print("1 u_s 2 1 13449");
                            
                            sleep(10000);
                            pescando=false;
                        }
                        
                    }
                    //Inicialicas para poder leer desde el packetlogger
                    //in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                    
                    //caso base: solo leer linea y mostrarla
                    
//--------------------------------------------------------------------------------------------------------------------------------------------                    
                    // los datos que envias tendran 1 adelante ejemplo  1 walk 148 116 0 21
                    //Los que recibes 0 wopen 32 2 632

                    //Aqui deberas realizar las acciones, dependiendo de lo que quieras leer Ejemplos:                                   
                    //ESTO es cuando quieres buscar por un identificador en especifico Se corta la linea por espacios
                    // en este caso walk
                    
                    
                    //Para descomentar y comentar selecciona todas las lineas de codigo que quieres y luego  ctrl+shift+c 
                    
                    
                    
//--------------------------------------------------------------------------------------------------------------------------------------------
 //                   Puede que haya casos en los que 1 sola string no te sirva para leer el dato que necesitas
 //                     ya que recibes muchos datos y no sera suficiente el tiempo para revisar 1 por 1, asi que podrias5
 //                     agregar mas in.readline();
 
//                      Ejemplo: Para saber cuando bazar esta abierto,puedes tratar de probar para que veas
//                    borra String linea2,linea2 = in.readline y compara solo line1, y veras que aveces no te lee cuando bazar
//                      esta abierto.



 //Para descomentar y comentar selecciona todas las lineas de codigo que quieres y luego  ctrl+shift+c     
//                    String linea1 = in.readLine();
//                    String linea2= in.readLine();
//                    String linea3= in.readLine();
//                    if (linea1.equals("0 wopen 32 2 631") || linea2.equals("0 wopen 32 2 631") || linea3.equals("0 wopen 32 2 631")) {
//                        System.out.println("bazaropen");
//                    }  
//--------------------------------------------------------------------------------------------------------------------------------------------                   
                    
                    //Cuando quieres buscar un evento en especifico por ejemplo cuando abres bazar
                  
                    
                    
                    
                    
                    
                    
                    
                    
                }            
            }else{
                System.out.println("No se ha podido establecer conexion");
            }
        } catch (IOException ex) {
            System.out.println(ex.getCause());
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
}

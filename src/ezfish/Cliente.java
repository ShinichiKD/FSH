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
public class Cliente {
    
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
    String TextSearch="";
    Boolean Encontrado=false;
    Boolean pescando=false;
    
    public Cliente(int p){
        this.puerto = p;
        
    }
    

    public void  Comenzar() throws InterruptedException {
//        PrintWriter out ;
        
//        DataOutputStream out2;
        System.out.println("Entre");
        try {
            //Realizas la conexion 
            cliente = new Socket("127.0.0.1",puerto);
                
                    if (cliente.isConnected()) {
                        System.out.println("Conexion establecida");
                    in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));    
                    //Aqui leeras los datos
                        String linea = in.readLine();
                        while (linea!=null) {                            
                            
                               
                            if (linea.equals("0 guri 6 1 13449 30 0") ||linea.equals("0 guri 6 1 13449 31 0") ) {
                                System.out.println("Pez Encontrado");
                                sleep(10);
                                Pescar();
                                sleep(5000);
                                free();
                                sleep(3000);
                                Tirar();
                            }
                            
                           
                            linea=in.readLine();
                            
                        }
                
                    }else{
                        System.out.println("No se ha podido establecer conexion");
                    }
                
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void Pescar(){
        EnviarMensaje("1 u_s 2 1 13449");

    }
    public void Tirar(){
        EnviarMensaje("1 u_s 1 1 13449");
    }
    public void free(){
        EnviarMensaje("1 u_s 3 1 13449");
    }
    public String getTextSearch() {
        return TextSearch;
    }

    public void setTextSearch(String TextSearch) {
        this.TextSearch = TextSearch;
    }

    public Boolean getEncontrado() {
        return Encontrado;
    }

    public void setEncontrado(Boolean Encontrado) {
        this.Encontrado = Encontrado;
    }
    public void EnviarMensaje(String mensaje){
        try {
            cliente = new Socket("localhost",puerto);
            in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            out = new PrintStream(cliente.getOutputStream());
            out.print(mensaje);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
}

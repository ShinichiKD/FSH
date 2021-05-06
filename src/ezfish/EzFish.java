/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezfish;

import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author ShinichiKD
 */
public class EzFish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Boolean pescando=false;
        int Puerto;
        Thread hilo;
        Thread hilo2;
        Thread hilo3;
         Thread hilo4;
         
        Scanner teclado  = new Scanner(System.in);
        System.out.print("Ingrese el puerto: ");
        Puerto =  teclado.nextInt();
                  
        Cliente cliente = new Cliente(Puerto);
        Cliente cliente3 = new Cliente(Puerto);
        Cliente cliente2 = new Cliente(Puerto);
     Cliente cliente4 = new Cliente(Puerto);
       
            
            
            System.out.println("S");
        
            if (pescando==false) {
              
                cliente.setTextSearch("0 guri 6 1 13449 30 0");  
                hilo = new Thread(cliente);
                hilo.start();
                
//                cliente2.setTextSearch("0 guri 6 1 13449 30 0");    
//                hilo2 = new Thread(cliente2);
//                hilo2.start();
                
                cliente3.setTextSearch("0 guri 6 1 13449 31 0");
                hilo3 = new Thread(cliente3);
                hilo3.start();
//                cliente4.setTextSearch("0 guri 6 1 13449 31 0");
//                hilo4 = new Thread(cliente4);
//                hilo4.start();
                cliente.Tirar();
                pescando=true;
            }
            
       
        
        
        // TODO code application logic here
    }
    
}

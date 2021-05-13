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
        cliente.CastLine();
        cliente.Comenzar();
            
            
            
       
        
        
        // TODO code application logic here
    }
    
}


















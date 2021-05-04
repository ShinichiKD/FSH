/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezfish;

import java.util.Scanner;

/**
 *
 * @author ShinichiKD
 */
public class EzFish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int Puerto;
        Thread hilo;
        Scanner teclado  = new Scanner(System.in);
        System.out.print("Ingrese el puerto: ");
        Puerto =  teclado.nextInt();
        System.out.println("Ss");
        Cliente cliente = new Cliente(Puerto);
        hilo = new Thread(cliente);
        hilo.start();
        // TODO code application logic here
    }
    
}

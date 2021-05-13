/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezfish;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ShinichiKD
 */
public class Skill implements Runnable{

   
    public int tiempoMilisegundos;
    public boolean free;
    public Thread hilo;
    public int count=0;
    public Skill(boolean free,int tiempo){
        this.free = free;
        this.tiempoMilisegundos = tiempo*1000;
        hilo = new Thread(this);
    }
   
    
    
    @Override
    public void run() {
        free=false;
        
        while(count!= tiempoMilisegundos){
            try {
                
                count=count+1000;
                sleep(1000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Skill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        free= true;
        count=0;
        
    } 
    
       
    public void Comenzar(){
        hilo = new Thread(this);
        hilo.start();
    }
    

    public boolean isFree() {
        return free;
    }

  
    
}




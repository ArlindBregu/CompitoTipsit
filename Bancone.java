/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensaaziendale;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *<p>Classe che viene utilizzata come Buffer singolo</p>
 * @author informatica
 */
public class Bancone { 
    
    Semaphore semVuoto = new Semaphore(1);
    Semaphore semPieno  = new Semaphore(0);
    int numeroPiatto;       //variabile che indica il numero del piatto
    int numProgressivo = 1; //variabile per aggiornare il numero progressivo dei piatti
    
    /**
     * <p>Metodo che constrolla se il semaforo è verde per depositare il numeroProgressivo sul numeroPiatto e aggiornare il numeroProgressivo</p>
     */
    public void deposita(){ 
        
        try {
            semVuoto.acquire();
        } catch (InterruptedException ex) {
        }
        
        numeroPiatto = numProgressivo;
        
        System.out.println("Il piatto n. " +this.numeroPiatto +" è pronto");
        semPieno.release();
        numProgressivo++;
    }
    
    /**
     *<p>Metodo che controlla sel il semaforo è rosso per consumare il numeroPiatto</p>
     * @return numeroPiatto
     */
    public int preleva(){  //Metodo che controlla sel il semaforo è rosso per consumare il numeroPiatto
    
        try {
            semPieno.acquire();
        } catch (InterruptedException ex) {
        }
        
        System.out.println("consumo: " +this.numeroPiatto);
        semVuoto.release();
        return this.numeroPiatto;
    }
    
}

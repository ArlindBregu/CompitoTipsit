/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensaaziendale;

/**
 *<p>Classe usata per provare il progetto</p>
 * @author informatica
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        Bancone b = new Bancone();  //Variabile condivisa
        
        CuocoProduttore cP = new CuocoProduttore(b, 1); 

  
        System.out.println("Inizio pausa pranzo");
        
        cP.start();
        
        for(int i=0; i<cP.numeroPiattiDaServire; i++){
        
            DipendenteConsumatore dP = new DipendenteConsumatore(b);
            dP.start();
        }
        
        for(int i=0; i<cP.numeroPiattiDaServire; i++){
        
            DipendenteConsumatore dP = new DipendenteConsumatore(b);
            dP.join();
        }
        
        cP.join();
        
        System.out.println("Fine pausa Pranzo");
    }
    
}

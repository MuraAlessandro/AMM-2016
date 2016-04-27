package milestone.classi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ale
 */
public class ContoFactory {
    
    private static ContoFactory singleton;
    public static ContoFactory getInstance() {
        if (singleton == null) {
            singleton = new ContoFactory();
        }
        return singleton;
    }  
    
    public ContoFactory(){
         
    Conto cont1 = new Conto();
    cont1.setId(0);
    cont1.setSaldo(220.05);
    
    Conto cont2 = new Conto();
    cont2.setId(1);
    cont2.setSaldo(95.30);
    
    Conto cont3 = new Conto();
    cont3.setId(2);
    cont3.setSaldo(1500.00);
    
    Conto cont4 = new Conto();
    cont4.setId(3);
    cont4.setSaldo(300.99);
    
    Conto cont5 = new Conto();
    cont5.setId(4);
    cont5.setSaldo(40000.00);
    
    
    }
}

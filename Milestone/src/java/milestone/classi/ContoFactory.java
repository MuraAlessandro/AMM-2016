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
         

    }
}
